package org.enspy.freello.services;

import java.util.Optional;
import java.util.UUID;

import org.enspy.freello.models.Project;
import org.enspy.freello.models.User;
import org.enspy.freello.models.dto.CreateProjectDto;
import org.enspy.freello.repositories.ProjectRepository;
import org.enspy.freello.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;

    public Iterable<Project> findAll(){
        return projectRepository.findAll();
    }

    public Optional<Project> findOne(UUID id){
        return projectRepository.findById(id);
    }

    public Project save(Project project){
        return projectRepository.save(project);
    }

    public Iterable<Project> add(CreateProjectDto createProjectDto){

        User user = userRepository.findByEmail(createProjectDto.getAdminAsUser().getEmail());
        Project projects = new Project( createProjectDto.getName(), user );
        projectRepository.save(projects);

        return projectRepository.findAll();
    }

    public Optional<Project> update(UUID id, CreateProjectDto createProjectDto){
        Optional<Project> projectOpt = projectRepository.findById(id);
        if(projectOpt.isPresent()){
            Project project = projectOpt.get();
            project.setName(createProjectDto.getName());
            projectRepository.save(project);
        }
        return projectOpt;
    }

    public void delete(UUID id){
        projectRepository.deleteById(id);
    }
}
