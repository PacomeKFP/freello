package org.enspy.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import org.enspy.api.model.*;


@Repository
public interface ProjectRepository extends JpaRepository<Projects, Integer> {
}