package com.fritzgyl.todolist.service.impl;

import com.fritzgyl.todolist.dto.PagedResponse;
import com.fritzgyl.todolist.dto.ToDoRequest;
import com.fritzgyl.todolist.dto.ToDoResponse;
import com.fritzgyl.todolist.mapper.ToDoMapper;
import com.fritzgyl.todolist.model.ToDo;
import com.fritzgyl.todolist.repository.ToDoRepository;
import com.fritzgyl.todolist.service.ToDoService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.fritzgyl.todolist.utils.AppConstants.CREATED_AT;

@Service
@AllArgsConstructor
public class ToDoServiceImpl implements ToDoService {

    private final ToDoRepository toDoRepository;

    private final ToDoMapper toDoMapper;

    @Override
    public ToDoResponse saveToDo(ToDoRequest toDoRequest) {
        ToDo todo = toDoMapper.toEntity(toDoRequest);
        return toDoMapper.toDto(toDoRepository.save(todo));
    }

    @Override
    public PagedResponse<ToDoResponse> getToDos(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, CREATED_AT);

        Page<ToDo> toDos = toDoRepository.findAll(pageable);

        List<ToDo> listOfToDos = toDos.getContent();

        List<ToDoResponse> content = listOfToDos.stream().map(toDoMapper::toDto).collect(Collectors.toList());

        return new PagedResponse<>(content, toDos.getNumber(), toDos.getSize(), toDos.getTotalElements(), toDos.getTotalPages(), toDos.isLast());
    }

    @Override
    public ToDoResponse getToDo(Long toDoId) {
        return toDoRepository.findById(toDoId).map(toDoMapper::toDto).orElseThrow(() -> new RuntimeException("To-do not found."));
    }

    @Override
    public ToDoResponse updateToDo(Long toDoId, ToDoRequest toDoRequest) {
        ToDo toDo = toDoRepository.findById(toDoId).orElseThrow(() -> new RuntimeException("To-do not found."));
        toDo.setCompleted(toDoRequest.isCompleted());
        toDo.setDescription(toDoRequest.getDescription());
        toDo.setTitle(toDoRequest.getTitle());
        return toDoMapper.toDto(toDoRepository.save(toDo));
    }

    @Override
    public void deleteToDo(Long toDoId) {
        ToDo toDo = toDoRepository.findById(toDoId).orElseThrow(() -> new RuntimeException("To-do not found."));
        toDoRepository.delete(toDo);
    }
}
