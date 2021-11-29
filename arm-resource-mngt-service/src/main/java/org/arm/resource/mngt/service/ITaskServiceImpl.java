package org.arm.resource.mngt.service;

import java.util.List;

import org.arm.resource.mngt.entity.Campaign;
import org.arm.resource.mngt.entity.ExceptionMessage;
import org.arm.resource.mngt.entity.Task;
import org.arm.resource.mngt.exceptions.TaskNotFoundException;
import org.arm.resource.mngt.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ITaskServiceImpl implements ITaskService {

	@Autowired
	TaskRepository taskRepository;

	@Override
	public List<Task> getAllTask() {
		List<Task> taskList= taskRepository.findAll();
		if(taskList.isEmpty()) {
			throw new TaskNotFoundException(ExceptionMessage.TaskDataEmpty.getMessage());
			
		}
		return taskList;
	}

	@Override
	public void createTasks(Task tasks) {
		taskRepository.save(tasks);
		
	}
}
