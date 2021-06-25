package platform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import platform.exception.CodeNotFoundException;
import platform.model.Code;
import platform.model.CodeDTO;
import platform.repository.CodeRepository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CodeService {

    private final CodeRepository codeRepository;

    @Autowired
    public CodeService(CodeRepository codeRepository) {
        this.codeRepository = codeRepository;
    }


    public Code getCodeById(UUID id) {
        Code codeSnippet = codeRepository.findById(id).orElseThrow(CodeNotFoundException::new);

        if (codeSnippet.getTime() >= 1 || codeSnippet.getViews() >= 1) {
            if (codeSnippet.getViews() > 0) {
                codeSnippet.setViewsLimited(true);
                codeSnippet.setViews(codeSnippet.getViews() - 1);
                if (codeSnippet.getViews() < 1) {
                    codeRepository.deleteById(codeSnippet.getId());
                    return codeSnippet;
                }

                codeSnippet = codeRepository.save(codeSnippet);
            }
            if (codeSnippet.getTime() > 0) {
                codeSnippet.setTime(codeSnippet.getTime() -
                        ChronoUnit.SECONDS.between(codeSnippet.getLocalDateTime(), LocalDateTime.now()));
                if (codeSnippet.getTime() < 1) {
                    codeRepository.deleteById(codeSnippet.getId());
                    throw new CodeNotFoundException();
                }
            }
        }
        return codeSnippet;
    }

    public UUID putCode(CodeDTO newCode) {
        LocalDateTime localDateTime = LocalDateTime.now();
        Code codeToSave = new Code();
        codeToSave.setId(UUID.randomUUID());
        codeToSave.setCode(newCode.getCode());
        codeToSave.setLocalDateTime(localDateTime);
        codeToSave.setTime(newCode.getTime());
        codeToSave.setViews(newCode.getViews());

        codeToSave.setRestrictedByTime(newCode.getTime() != 0);
        codeToSave.setRestrictedByViews(newCode.getViews() != 0);

        return codeRepository.save(codeToSave).getId();
    }

    public List<Code> getLatestCode() {
        return codeRepository
                .findAllByRestrictedByTimeAndRestrictedByViewsOrderByLocalDateTimeDesc(false,
                        false)
                .stream().limit(10).collect(Collectors.toList());

    }

}
