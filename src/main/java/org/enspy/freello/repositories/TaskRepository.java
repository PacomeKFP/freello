package org.enspy.freello.repositories;

import java.util.UUID;

import org.enspy.freello.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, UUID> {

}
