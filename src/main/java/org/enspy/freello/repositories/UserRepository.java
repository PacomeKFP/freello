package org.enspy.freello.repositories;

import java.util.UUID;

import org.enspy.freello.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, UUID> {
}
