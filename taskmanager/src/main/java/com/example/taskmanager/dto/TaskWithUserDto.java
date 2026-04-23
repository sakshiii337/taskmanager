package com.example.taskmanager.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskWithUserDto {
    private Integer id;

    private String title;

    private String description;

    private String status;
  //  @JsonManagedReference
    private UserDto user;
}
