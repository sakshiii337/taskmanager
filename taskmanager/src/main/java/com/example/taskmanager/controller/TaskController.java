package com.example.taskmanager.controller;

import com.example.taskmanager.dto.TaskDto;
import com.example.taskmanager.dto.TaskWithUserDto;
import com.example.taskmanager.exception.InvalidFileFormatException;
import com.example.taskmanager.service.TaskService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Valid;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;
    private final ObjectMapper objectMapper ;
    private final Validator validator;
    @PostMapping
    public ResponseEntity<TaskDto> createTask(@RequestBody  TaskDto taskDto){
        return new ResponseEntity<>(taskService.createTask(taskDto), HttpStatus.CREATED);
    }
    // integrating file
    @PostMapping(value = "/upload" , consumes = "multipart/form-data")
    public ResponseEntity<String> uploadTask(@RequestParam("file") MultipartFile file){
        try{
            String json = new String(file.getBytes());
            List<TaskDto> tasks = Arrays.asList(objectMapper.readValue(json,TaskDto[].class));
            List<String> violationMessages = tasks.stream()
                    .flatMap( dto -> validator.validate(dto).stream())
                    .map(ConstraintViolation:: getMessage )
                    .toList();
            if(!violationMessages.isEmpty()){
                return ResponseEntity.badRequest().body(String.join("\n" , violationMessages));
            }
            taskService.createMultipleTasks(tasks);
            return ResponseEntity.ok( "uploaded" + tasks.size() + "tasks");

        }
        catch (Exception e){
            throw new InvalidFileFormatException("Invalid file format");

        }
    }
    @GetMapping
    public ResponseEntity<Page<TaskDto>> getAllTask(
@PageableDefault(page = 0  ,size = 10, sort = "title") Pageable pageable){
        return ResponseEntity.ok(taskService.getAllTasks(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskWithUserDto> getTaskByIdTask(@PathVariable Integer id){
        return ResponseEntity.ok(taskService.getTaskById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskDto> updateTask(
            @PathVariable Integer id,
            @Valid @RequestBody TaskDto taskDto
    ){
        return ResponseEntity.ok(taskService.updateTask(id,taskDto));
    }
    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> deleteTask(@PathVariable Integer id){
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
    
}
