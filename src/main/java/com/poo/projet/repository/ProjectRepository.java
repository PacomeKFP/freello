package com.poo.projet.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poo.projet.models.Project;

public interface ProjectRepository extends JpaRepository <Project, UUID>{

}
