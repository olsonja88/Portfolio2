package com.olsonja.portfolio2.repository;

import com.olsonja.portfolio2.model.Project;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
