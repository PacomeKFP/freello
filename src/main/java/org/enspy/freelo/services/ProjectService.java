package org.enspy.freelo.services;

import lombok.Data;
import org.enspy.freelo.exception.ResourceNotFoundException;
import org.enspy.freelo.models.Project;
import org.enspy.freelo.models.dto.CreateProjectDto;
import org.enspy.freelo.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@Data
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public Iterable<Project> findAll() {
        return projectRepository.findAll();
    }

    public Optional<Project> findOne(UUID id) {
        return projectRepository.findById(id);
    }

    public void delete(UUID id) {
        projectRepository.deleteById(id);
    }

    public Project add(CreateProjectDto createProjectDto) {
        Project project = new Project(createProjectDto.getName(), createProjectDto.getAdmin());
        return projectRepository.save(project);
    }
    public Project updateProject(UUID id, Project projectDetails) {
        Project project = projectRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Projet non trouvé pour cet id :: " + id));
        project.setName(projectDetails.getName());
        project.setAdmin(projectDetails.getAdmin());
        project.setMembers(projectDetails.getMembers());
        return projectRepository.save(project);
    }
}
