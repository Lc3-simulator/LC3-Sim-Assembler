//package com.example.yourproject;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LC3RESTController {

    private final LC3Instance lc3Instance = new LC3Instance();

    @PostMapping("/assemble")
    public String assemble(@RequestBody String assemblyCode) {
        // Use your Assembler class to assemble the code
        // Load it into the lc3Instance
        // Return a response
    }

    @GetMapping("/memory")
    public short[] getMemory() {
        // Return the current state of memory
    }

    @GetMapping("/registers")
    public short[] getRegisters() {
        // Return the current state of registers
    }

    @PostMapping("/execute")
    public String execute() {
        // Execute one instruction or a set of instructions
        // Return a response
    }
}
