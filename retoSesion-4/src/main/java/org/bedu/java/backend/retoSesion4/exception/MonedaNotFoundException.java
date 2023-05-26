package org.bedu.java.backend.retoSesion4.exception;

public class MonedaNotFoundException extends RuntimeException {

  private String name;

  public MonedaNotFoundException(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
