package com.openandroid.project.service;

import com.openandroid.project.model.Apps;
import com.openandroid.project.repository.IAppsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppsService {
    @Autowired
    private IAppsRepository appsRepository;

    public List<Apps> getAllApps() {
        return appsRepository.findAll();
    }
}
