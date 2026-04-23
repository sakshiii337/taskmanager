
package com.example.taskmanager.service;

import com.example.taskmanager.dto.TaskDto;
import com.example.taskmanager.dto.TaskWithUserDto;
import com.example.taskmanager.model.Task;
import com.example.taskmanager.exception.TaskNotFoundException;
import com.example.taskmanager.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public TaskDto createTask(TaskDto taskDto){
        Task task = modelMapper.map(taskDto, Task.class);
        Task savedTask = taskRepository.save(task);
        return modelMapper.map(savedTask, TaskDto.class);
    }
    public void  createMultipleTasks(List<TaskDto> taskDtos){
        List<Task> tasks = taskDtos.stream()
        .map( taskDto -> modelMapper.map(taskDto, Task.class))
        .toList();
        taskRepository.saveAll(tasks);
    }


    public Page<TaskDto> getAllTasks(Pageable pageable) {
        return taskRepository.findAll(pageable)
                .map(task -> modelMapper.map(task, TaskDto.class));
    }
    public TaskWithUserDto getTaskById(Integer id){
        return taskRepository.findById(id)
                .map(task -> modelMapper.map(task, TaskWithUserDto.class))
                .orElseThrow(() -> new TaskNotFoundException("Task not found with id " + id));
    }


    public TaskDto updateTask(Integer id, TaskDto taskDto){
        Task existingTask = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found with id " + id));

        existingTask.setTitle(taskDto.getTitle());
        existingTask.setDescription(taskDto.getDescription());
        existingTask.setStatus(taskDto.getStatus());

        Task updatedTask = taskRepository.save(existingTask);
        return modelMapper.map(updatedTask, TaskDto.class);
    }
    public void deleteTask(Integer id){
        if(!taskRepository.existsById(id)){
            throw new TaskNotFoundException("Task not found with id " + id);
        }
        taskRepository.deleteById(id);
    }
}