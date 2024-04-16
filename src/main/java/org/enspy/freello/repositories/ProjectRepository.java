package org.enspy.freello.repositories;

import java.util.UUID;

import org.enspy.freello.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, UUID> {

}
