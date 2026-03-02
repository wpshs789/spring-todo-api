package com.example.demo.Controller;

import com.example.demo.Service.TodoService;
import com.example.demo.DTO.TodoCreateRequest;
import com.example.demo.DTO.TodoResponse;
import com.example.demo.DTO.TodoUpdateRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {
    private final TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) //201
    public TodoResponse add(@Valid @RequestBody TodoCreateRequest req) {
        return service.add(req);
    }

    @GetMapping
    public List<TodoResponse> getTodos() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public TodoResponse getOne(@PathVariable Long id) {
        return service.getOne(id);
    }

    @PutMapping("/{id}")
    public TodoResponse update(@PathVariable Long id, @Valid @RequestBody TodoUpdateRequest req) {
        return service.update(id, req);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
