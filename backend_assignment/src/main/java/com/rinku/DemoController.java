package com.rinku;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/program")
public class DemoController {
    private final AssemblyLang assemblyLang;

    @Autowired
    public DemoController(AssemblyLang assemblyLang) {
        this.assemblyLang = assemblyLang;
    }

    @PostMapping("/execute")
    public ResponseEntity<String> executeProgram(@RequestBody String[] instructions) {
        try {
            assemblyLang.executeProgram(instructions);
            return ResponseEntity.ok("Program executed successfully and status saved to the database.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred during execution.");
        }
    }
}
