package com.example.taskmanager.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserWithTaskDto {
    private Integer id;
    @NotBlank
    private String name;
    @NotBlank
    @Email
    private String email;
 //add this on this dto
    private List<TaskDto> tasks;
}
