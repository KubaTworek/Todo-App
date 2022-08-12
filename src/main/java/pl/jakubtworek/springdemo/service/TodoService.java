package pl.jakubtworek.springdemo.service;

import pl.jakubtworek.springdemo.entity.Todo;

import java.util.List;

public interface TodoService {
    public List<Todo> getTodos();
    public Todo getTodo(int id);
    void saveTodo(Todo theTodo);
    public void deleteTodo(int theId);
}
