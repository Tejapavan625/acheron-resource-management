package org.arm.resource.mngt.service;

import java.util.List;

import org.arm.resource.mngt.entity.Campaign;
import org.arm.resource.mngt.entity.ExceptionMessage;
import org.arm.resource.mngt.entity.Project;
import org.arm.resource.mngt.exceptions.CampaignNotFoundException;
import org.arm.resource.mngt.repository.CampaignRepository;
import org.arm.resource.mngt.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService implements IProjectService {

	@Autowired
	ProjectRepository projectRepository;

	@Override
	public List<Project> getAllProject() {
		List<Project> projectList=projectRepository.findAll();
		if(projectList.isEmpty()) {
			throw new CampaignNotFoundException(ExceptionMessage.CampaignDataEmpty.getMessage());
		}
			
			return projectList;

		}
	

	@Override
	public void save(Project project) {
		projectRepository.save(project);
	}

}
