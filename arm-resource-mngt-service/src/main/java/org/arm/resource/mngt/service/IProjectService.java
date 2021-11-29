package org.arm.resource.mngt.service;

import java.util.List;

import org.arm.resource.mngt.entity.Project;
import org.arm.resource.mngt.exceptions.ProjectNotFoundException;

public interface IProjectService {

	public List<Project> getAllProject() throws ProjectNotFoundException;

	public void save(Project project);
}
