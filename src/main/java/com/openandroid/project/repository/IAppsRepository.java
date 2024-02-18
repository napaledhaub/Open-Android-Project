package com.openandroid.project.repository;

import com.openandroid.project.model.Apps;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IAppsRepository extends JpaRepository<Apps, Long> {
}
