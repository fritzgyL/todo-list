package com.fritzgyl.todolist.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ToDoRequest {

    @NotBlank
    private String title;

    private String description;

    private boolean completed;
}
