package com.openandroid.project.repository;

import com.openandroid.project.model.Developer;

import java.util.Optional;

public interface IDeveloperRepository {
    Optional<Developer> findByEmail(String email);

    Optional<Developer> findByResetToken(String resetToken);
}
