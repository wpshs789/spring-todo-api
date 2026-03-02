package com.example.demo.Service;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
            private Long id;
    private String text;
    private boolean done;

    private Todo() {

    }

    public Todo(String text, boolean done) {
        this.text = text;
        this.done = done;
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public boolean isDone() {
        return done;
    }

    public void update(String text, boolean done) {
        this.text = text;
        this.done = done;
    }
}
