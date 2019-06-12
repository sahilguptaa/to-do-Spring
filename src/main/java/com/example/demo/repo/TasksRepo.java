package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Task;


@Repository
public interface TasksRepo extends JpaRepository<Task, Integer>{

	List<Task> findByUserId(int userId);

	List<Task> findByUserIdAndStatus(int userId, String status);
	
	List<Task> findByContent(String content);

}
