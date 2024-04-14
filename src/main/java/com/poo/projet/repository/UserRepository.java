package com.poo.projet.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poo.projet.models.User;

public interface UserRepository extends JpaRepository <User, UUID> {

}
