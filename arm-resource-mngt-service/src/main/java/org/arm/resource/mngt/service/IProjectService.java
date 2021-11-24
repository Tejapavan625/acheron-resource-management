package org.arm.resource.mngt.service;

import java.util.List;

import org.arm.resource.mngt.entity.Project;

public interface IProjectService {

	public List<Project> getAllProject();

	public void save(Project project);
}
