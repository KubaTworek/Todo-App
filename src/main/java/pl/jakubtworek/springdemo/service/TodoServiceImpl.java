package pl.jakubtworek.springdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.jakubtworek.springdemo.dao.TodoDAO;
import pl.jakubtworek.springdemo.entity.Todo;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService{

    @Autowired
    private TodoDAO todoDAO;

    @Override
    @Transactional
    public List<Todo> getTodos() {
        return todoDAO.getTodos();
    }

    @Override
    @Transactional
    public Todo getTodo(int id) {
        return todoDAO.getTodo(id);
    }

    @Override
    @Transactional
    public void saveTodo(Todo theTodo) {
        todoDAO.saveTodo(theTodo);
    }

    @Override
    @Transactional
    public void deleteTodo(int theId) {
        todoDAO.deleteTodo(theId);
    }
}
