package com.example.demo.Service;

import com.example.demo.DTO.TodoCreateRequest;
import com.example.demo.DTO.TodoResponse;
import com.example.demo.DTO.TodoUpdateRequest;
import com.example.demo.Repository.TodoRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.ArrayList;

@Service
public class TodoService {
    private final TodoRepository repo;

    public TodoService(TodoRepository repo) {
        this.repo = repo;
    }

    private TodoResponse toResponse(Todo todo) {
        return new TodoResponse(todo.getId(), todo.getText(), todo.isDone());
    }

    public List<TodoResponse> getAll() {
        return repo.findAll().stream()
                .map(this::toResponse)
                .toList();
    }

    public TodoResponse add(TodoCreateRequest req) {
        Todo saved = new Todo(req.getText(), req.isDone());
        repo.save(saved);
        return toResponse(saved);
    }

    public TodoResponse getOne(Long id) {
        return toResponse(findOneOrThrow(id));
    }

    public Todo findOneOrThrow(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Transactional
    public TodoResponse update(Long id, TodoUpdateRequest req) {
        Todo todo = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Not Found"));

        String text = req.getText() != null ? req.getText() : todo.getText();
        boolean done = req.isDone() != null ? req.isDone() : todo.isDone();

        todo.update(text, done);

        return toResponse(todo);
        }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
