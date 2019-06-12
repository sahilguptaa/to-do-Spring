package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.Task;
import com.example.demo.entity.User;
import com.example.demo.repo.TasksRepo;
import com.example.demo.repo.UserRepo;

@org.springframework.stereotype.Service
public class Service {

	@Autowired
	private TasksRepo taskRepository;

	@Autowired
	private UserRepo userRepository;
	
	public void saveUsers() {
		User userA = new User();
		userA.setUserId("USER A");
		userA.setPassword("passwordA");
		User userB = new User();
		userB.setUserId("USER B");
		userB.setPassword("passwordB");
		userRepository.save(userA);
		userRepository.save(userB);
	}
	
	public List<Task> fetchAllTasks(Integer userId) {
		return taskRepository.findByUserId(userId);
	}
	
	public List<Task> fetchAllIncompleteTasks(Integer userId) {
		return taskRepository.findByUserIdAndStatus(userId, "Pending");
	}

	public boolean saveTask(Task task) {
		taskRepository.save(task);
		return true;

	}

	public boolean changeStatus(int taskId) {
		try {
			Task statusChangedTask = new Task();
			Optional<Task> optionalTask = taskRepository.findById(taskId);
			if (optionalTask.isPresent()) {
				statusChangedTask = optionalTask.get();
			}
			statusChangedTask.setStatus("Completed");
			taskRepository.save(statusChangedTask);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public List<Task> searchTask(String content) {
		// TODO Auto-generated method stub
		return taskRepository.findByContent(content);
	}

}
