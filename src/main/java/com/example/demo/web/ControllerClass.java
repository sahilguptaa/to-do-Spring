package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Task;
import com.example.demo.service.Service;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ControllerClass {

	@Autowired
	private Service taskService;

	@PostMapping("/searchTask")
	public List<Task> searchTask(@RequestBody String content){
		return taskService.searchTask(content);
	}
	
	
	@PostMapping("/fetchAllTasks")
	public List<Task> fetchAllTasks(@RequestBody Integer userId){
		return taskService.fetchAllTasks(userId);
	}
	
	@PostMapping("/fetchAllIncompleteTasks")
	public List<Task> fetchAllIncompleteTasks(@RequestBody Integer userId){
		return taskService.fetchAllIncompleteTasks(userId);
	}
	
	@PostMapping("/saveTask")
	public boolean saveTask(@RequestBody Task task){
		return taskService.saveTask(task);
	}
	
	@PostMapping("/changeStatus")
	public boolean saveTask(@RequestBody Integer taskId){
		return taskService.changeStatus(taskId);
	}
}
