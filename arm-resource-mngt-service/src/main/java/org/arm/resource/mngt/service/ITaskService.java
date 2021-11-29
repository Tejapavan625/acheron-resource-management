package org.arm.resource.mngt.service;

import java.util.List;

import org.arm.resource.mngt.entity.Task;
import org.arm.resource.mngt.exceptions.TaskNotFoundException;

public interface ITaskService {

	public List<Task> getAllTask() throws TaskNotFoundException;

	public void createTasks(Task tasks);
}
