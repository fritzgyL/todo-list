package com.fritzgyl.todolist.controller;

import com.fritzgyl.todolist.dto.PagedResponse;
import com.fritzgyl.todolist.dto.ToDoRequest;
import com.fritzgyl.todolist.dto.ToDoResponse;
import com.fritzgyl.todolist.service.ToDoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/api/todos")
public class ToDoController {

    private final ToDoService toDoService;

    @PostMapping
    public ResponseEntity<ToDoResponse> saveToDo(@Valid @RequestBody ToDoRequest toDoRequest) {
        return new ResponseEntity<>(toDoService.saveToDo(toDoRequest), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<PagedResponse<ToDoResponse>> getTodos(int page, int size) {
        PagedResponse<ToDoResponse> response = toDoService.getToDos(page, size);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ToDoResponse> getToDo(@PathVariable(value = "id") Long toDoId) {
        return new ResponseEntity<>(toDoService.getToDo(toDoId), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ToDoResponse> updateToDo(@PathVariable(value = "id") Long toDoId, @Valid @RequestBody ToDoRequest toDoRequest) {
        return new ResponseEntity<>(toDoService.updateToDo(toDoId, toDoRequest), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteToDo(@PathVariable(value = "id") Long toDoId) {
        toDoService.deleteToDo(toDoId);
    }
}
