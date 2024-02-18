package com.openandroid.project.controller;

import com.openandroid.project.model.Apps;
import com.openandroid.project.service.AppsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/service-menu")
public class AppsController {
    @Autowired
    private AppsService appsService;

    @GetMapping("/list")
    public ResponseEntity<List<Apps>> getAllServiceMenus() {
        List<Apps> appsList = appsService.getAllApps();
        return ResponseEntity.ok(appsList);
    }
}
