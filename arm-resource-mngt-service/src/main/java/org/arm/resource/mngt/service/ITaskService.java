package org.arm.resource.mngt.service;

import java.util.List;

import org.arm.resource.mngt.entity.Task;

public interface ITaskService {

	public List<Task> getAllTask();

	public void createTasks(Task tasks);
}
