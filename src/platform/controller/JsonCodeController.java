package platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import platform.model.Code;
import platform.model.CodeDTO;
import platform.model.ResponseId;
import platform.service.CodeService;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/code")
@Validated
public class JsonCodeController {

    private final CodeService codeService;

    @Autowired
    public JsonCodeController(CodeService codeService) {
        this.codeService = codeService;
    }


    @GetMapping(path = "/{id}")
    @ResponseBody
    public ResponseEntity<Code> getCodeSnippetById(@PathVariable("id") UUID id) {
        return ResponseEntity.ok()
                .header("Content-Type", "application/json")
                .body(codeService.getCodeById(id));
    }

    @GetMapping(path = "/latest")
    @ResponseBody
    public ResponseEntity<List<Code>> getLatestCodeSnippets() {
        return ResponseEntity.ok()
                .header("Content-Type", "application/json")
                .body(codeService.getLatestCode());
    }

    @PostMapping(path = "/new")
    @ResponseBody
    public ResponseEntity<ResponseId> putCodeSnippet(@RequestBody @Valid CodeDTO newCode) {
        return ResponseEntity.ok()
                .header("Content-Type", "application/json")
                .body(new ResponseId(codeService.putCode(newCode)));
    }




/*    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<Code> getJsonCodeById(@PathVariable("id")   @Size(min = 36, max = 36) String id) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-Type",
                "application/json");
        return ResponseEntity
                .ok()
                .headers(responseHeaders)
                .body(codeService.getCodeById(id));
    }

    @GetMapping("/latest")
    @ResponseBody
    public ResponseEntity<List<Code>> getLastCodeList() {
        return ResponseEntity
                .ok()
                .header("Content-Type",
                        "application/json")
                .body(codeService.getFirst10CodesSortByDate());
    }

    @PostMapping(value = "/new")
    @ResponseBody
    public ResponseEntity<ResponseId> saveCode(@RequestBody @Valid Code record) {
        return ResponseEntity
                .ok()
                .header("Content-Type",
                        "application/json")
                .body(new ResponseId(codeService.addCode(record)));
    }*/

}
