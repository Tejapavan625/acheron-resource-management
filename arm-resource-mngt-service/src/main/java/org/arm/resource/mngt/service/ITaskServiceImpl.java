package org.arm.resource.mngt.service;

import java.util.List;

import org.arm.resource.mngt.entity.Campaign;
import org.arm.resource.mngt.entity.Task;
import org.arm.resource.mngt.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ITaskServiceImpl implements ITaskService {

	@Autowired
	TaskRepository taskRepository;

	@Override
	public List<Task> getAllTask() {
		// TODO Auto-generated method stub
		return taskRepository.findAll();
	}

	@Override
	public void createTasks(Task tasks) {
		taskRepository.save(tasks);
		
	}
}
