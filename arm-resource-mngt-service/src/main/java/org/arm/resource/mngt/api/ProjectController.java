package org.arm.resource.mngt.api;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.arm.resource.mngt.entity.Priority;
import org.arm.resource.mngt.entity.Project;
import org.arm.resource.mngt.entity.Status;
import org.arm.resource.mngt.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {
	
	@Autowired
	private IProjectService projectService;
	
	
	@GetMapping("/project")
	public List<Project> allt(){
		return projectService.getAllProject();
	}
	
	@GetMapping("/project/create")
	public void createProject(){
		Project project = new Project();
		// project.setCampaignId(1);
		project.setCreateDate(new Timestamp(new Date().getTime()));
		project.setEndDate(new Timestamp(new Date().getTime() + 15*86400 ));
		project.setIsDeleted(0);
		project.setStartDate(new Timestamp(new Date().getTime()));
		project.setPriority(Priority.HIGH);
		project.setProjectName("New Project");
		project.setProjectOwner("Test");
		project.setStatus(Status.IN_PROGRESS);
		
		projectService.save(project);
	}
}
