package org.aku.freello.services;

import lombok.Data;
import org.aku.freello.models.Project;
import org.aku.freello.models.dto.CreateProjectDto;
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

    public Project inviteCollaborator(UUID id, String email) {
        // TODO: Implements this method.

        // TODO: verify if the id correspond to an existing project

        ///TODO:  send mail to the collaborator,

        // TODO: add the mail to the list of project collaborators

        return new Project();
    }
}
