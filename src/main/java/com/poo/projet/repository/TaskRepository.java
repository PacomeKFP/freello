package com.poo.projet.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poo.projet.models.Tasks;

public interface TaskRepository extends JpaRepository <Tasks, UUID> {

}
