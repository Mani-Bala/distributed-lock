package com.spring.lock.controller;

import com.spring.lock.service.LockService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class LockController {

    public final LockService lockService;

    @PutMapping("/lock")
    public String lock(){
        return lockService.lock();
    }

}
