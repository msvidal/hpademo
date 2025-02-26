package com.msvidal.hpademo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/load")
public class CpuIntensiveController {

    @GetMapping("/cpu")
    public ResponseEntity<String> consumeCpu() {
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start < 5000) {
            Math.pow(Math.random(), Math.random());
        }
        return ResponseEntity.ok("CPU Load Generated!");
    }

    @GetMapping("/memory")
    public ResponseEntity<String> consumeMemory() {
        List<byte[]> memoryHog = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            memoryHog.add(new byte[1024 * 1024]);
        }
        return ResponseEntity.ok("Memory Load Generated!");
    }
}
