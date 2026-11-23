package com.project.taskmanager.controller;

import java.util.List;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.taskmanager.model.Task;
import com.project.taskmanager.repository.TaskRepository;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
	
	@Autowired
	private TaskRepository repository;
	//get all tasks
	@GetMapping
	public ResponseEntity<List<Task>> findAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	//post(create ) a new task
	@PostMapping
	public ResponseEntity<Task> createTask(@RequestBody Task task){
		return ResponseEntity.ok(repository.save(task));
	}
	
	//put(update) an existing task
	@PutMapping("/{id}")
	public ResponseEntity<Task> updateTask(@PathVariable Long id,@RequestBody Task updatedTask){
		return repository.findById(id)
				.map(task -> {
					task.setTitle(updatedTask.getTitle());
					task.setDescription(updatedTask.getDescription());
					task.setCompleted(updatedTask.isCompleted());
					return ResponseEntity.ok(repository.save(task));
				})
				.orElse(ResponseEntity.notFound().build());
		
	}
	
	//Delete a task
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTask(@PathVariable Long id){
		if(!repository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		repository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
	
