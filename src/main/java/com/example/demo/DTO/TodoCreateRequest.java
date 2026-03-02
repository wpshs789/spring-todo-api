package com.example.demo.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TodoCreateRequest {
    @NotBlank(message = "내용은 비어있을 수 없습니다.")
    @Size(max = 100, message = "내용은 100자 이하입니다.")
    private String text;
    private boolean done;

    public TodoCreateRequest() {
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public boolean isDone() {
        return done;
    }
}
