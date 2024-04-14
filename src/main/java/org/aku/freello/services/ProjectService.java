package org.aku.freello.services;

import lombok.Data;
import org.aku.freello.dto.CreateProjectDto;
import org.aku.freello.models.Project;
import org.aku.freello.repositories.ProjectRepository;
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

    public Project create(CreateProjectDto createProjectDto) {
        Project project = new Project(createProjectDto.getName(), createProjectDto.getAdminAsUser());
        return projectRepository.save(project);
    }
}
