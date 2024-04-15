package org.enspy.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;

import org.enspy.api.model.*;
import org.enspy.api.repository.*;

import lombok.Data;


@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Optional<Projects> getProject(final int id) {
        return projectRepository.findById(id);
    }

    public Iterable<Projects> getAllProjects() {
        return projectRepository.findAll();
    }

    public void deleteProject(final int id) {
        projectRepository.deleteById(id);
    }

    public Projects saveProject(Projects project) {
        return projectRepository.save(project);
    }

    public Projects updateProject(Projects project) {
        if (project.getId() != null && projectRepository.existsById(project.getId())) {
            return projectRepository.save(project);
        }
        throw new EntityNotFoundException("User with id " + project.getId() + " not found.");
    }
}