package org.enspy.freello.repositories;

import org.enspy.freello.models.Tasks;
import org.enspy.freello.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
}
