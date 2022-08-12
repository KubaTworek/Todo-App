package pl.jakubtworek.springdemo.dao;

import pl.jakubtworek.springdemo.entity.Todo;

import java.util.List;

public interface TodoDAO {
    public List<Todo> getTodos();
    public Todo getTodo(int id);
    void saveTodo(Todo theTodo);
    public void deleteTodo(int theId);
}
