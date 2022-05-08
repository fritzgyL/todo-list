package com.fritzgyl.todolist.mapper;

import com.fritzgyl.todolist.dto.ToDoRequest;
import com.fritzgyl.todolist.dto.ToDoResponse;
import com.fritzgyl.todolist.model.ToDo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ToDoMapper {

    ToDoResponse toDto(ToDo toDo);

    ToDo toEntity(ToDoRequest toDoRequest);

}
