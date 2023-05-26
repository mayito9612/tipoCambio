package org.bedu.java.backend.retoSesion4.model.response;

public class ErrorRespons {
    private String message;

    public ErrorRespons(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
