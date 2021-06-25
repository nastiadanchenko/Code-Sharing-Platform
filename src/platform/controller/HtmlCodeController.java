package platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import platform.service.CodeService;

import javax.validation.constraints.Size;
import java.util.UUID;


@Controller
@RequestMapping("/code")
@Validated
public class HtmlCodeController {

    private final CodeService codeService;

    @Autowired
    public HtmlCodeController(CodeService codeService) {
        this.codeService = codeService;
    }


    @GetMapping(path = "/{id}")
    public String getCodeSnippetById(Model model, @PathVariable("id") UUID id) {
        model.addAttribute("code", codeService.getCodeById(id));
        return "codeTemp";
    }

    @GetMapping(path = "/latest")
    public String getCodeSnippetById(Model model) {
        model.addAttribute("latestCode", codeService.getLatestCode());
        return "codeLatest";
    }

    @GetMapping(path = "/new")
    public String getNewCode(Model model) {
        return "codeCreate";
    }


}
