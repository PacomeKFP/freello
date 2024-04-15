package org.enspy.freelo.repositories;

import org.enspy.freelo.models.Project;
import org.enspy.freelo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
}

