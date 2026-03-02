package com.example.demo.DTO;

import jakarta.validation.constraints.Size;

public class TodoUpdateRequest {
    @Size(max = 100, message = "내용은 100자 이하입니다.")
    private String text;
    private Boolean done;

    public TodoUpdateRequest() {

    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean isDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }
}
