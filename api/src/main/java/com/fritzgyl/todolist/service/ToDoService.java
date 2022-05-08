package com.fritzgyl.todolist.service;

import com.fritzgyl.todolist.model.ToDo;
import com.fritzgyl.todolist.dto.PagedResponse;
import com.fritzgyl.todolist.dto.ToDoRequest;
import com.fritzgyl.todolist.dto.ToDoResponse;

public interface ToDoService {

    ToDoResponse saveToDo(ToDoRequest toDoRequest);

    PagedResponse<ToDoResponse> getTodos(int page, int size);

    ToDoResponse getToDo(Long toDoId);

    ToDoResponse updateToDo(Long toDoId, ToDoRequest toDoRequest);

    void deleteToDo(Long toDoId);

}
