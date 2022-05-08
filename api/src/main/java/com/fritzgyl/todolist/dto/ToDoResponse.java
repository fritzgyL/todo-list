package com.fritzgyl.todolist.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ToDoResponse {

    private Long id;

    private String title;

    private String description;

    private boolean completed;

}
