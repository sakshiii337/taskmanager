package com.example.taskmanager.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {
    private Integer id;

    private String title;

    private String description;

    private String status;
@JsonManagedReference
private UserDto user;

}
