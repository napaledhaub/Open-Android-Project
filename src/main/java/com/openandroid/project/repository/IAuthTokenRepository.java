package com.openandroid.project.repository;

import com.openandroid.project.model.AuthToken;
import com.openandroid.project.model.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface IAuthTokenRepository extends JpaRepository<AuthToken, Long> {
    AuthToken findByToken(String token);

    @Transactional
    void deleteByToken(String token);

    AuthToken findByParticipant(Developer developer);
}
