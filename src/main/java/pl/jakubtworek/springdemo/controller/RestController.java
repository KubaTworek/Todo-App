package pl.jakubtworek.springdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.jakubtworek.springdemo.entity.Todo;
import pl.jakubtworek.springdemo.rest.TodoNotFoundException;
import pl.jakubtworek.springdemo.service.TodoService;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {
    @Autowired
    private TodoService todoService;

    @GetMapping("/todos")
    public List<Todo> getTodos(){
        return todoService.getTodos();
    }

    @GetMapping("/todos/{todoId}")
    public Todo getTodo(@PathVariable int todoId){
        if(todoService.getTodo(todoId) == null) throw new TodoNotFoundException("Todo id not found - " + todoId);

        return todoService.getTodo(todoId);
    }

    @PostMapping("/todos")
    public Todo saveTodo(@RequestBody Todo theTodo){
        theTodo.setId(0);
        todoService.saveTodo(theTodo);

        return theTodo;
    }

    @PutMapping("/todos")
    public Todo updateTodo(@RequestBody Todo theTodo){
        todoService.saveTodo(theTodo);

        return theTodo;
    }

    @DeleteMapping("/todos/{todoId}")
    public String deleteTodo(@PathVariable int todoId){
        if(todoService.getTodo(todoId) == null) throw new TodoNotFoundException("Todo id not found - " + todoId);
        todoService.deleteTodo(todoId);

        return "Deleted todo id - " + todoId;
    }
}
