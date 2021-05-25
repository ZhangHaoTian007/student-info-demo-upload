package com.demo.util;

import lombok.Getter;

/**
 * @author 32050
 */
@Getter
public class JSONResult<T> {

    private final int status;
    private final String message;
    private final T content;

    public JSONResult(int status, String message, T content) {
        this.status = status;
        this.message = message;
        this.content = content;
    }

    @Override
    public String toString() {
        return "JSONResult{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", content=" + content +
                '}';
    }
}
