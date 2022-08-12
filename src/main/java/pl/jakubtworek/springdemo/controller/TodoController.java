package pl.jakubtworek.springdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.jakubtworek.springdemo.entity.Todo;
import pl.jakubtworek.springdemo.service.TodoService;

import java.util.List;

@Controller
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/list")
    public String listTodos(Model theModel){
        List<Todo> theTodos = todoService.getTodos();

        theModel.addAttribute("todos", theTodos);

        return "list-todos";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){
        Todo theTodo= new Todo();
        theModel.addAttribute("todo", theTodo);
        return "todo-form";
    }

    @PostMapping("/saveTodo")
    public String saveTodo(@ModelAttribute("todo") Todo theTodo){
        todoService.saveTodo(theTodo);
        return "redirect:/todo/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("todoId") int theId, Model theModel){
        Todo theTodo = todoService.getTodo(theId);
        theModel.addAttribute("todo", theTodo);
        return "todo-form";
    }

    @GetMapping("/delete")
    public String deleteTodo(@RequestParam("todoId") int theId) {
        todoService.deleteTodo(theId);
        return "redirect:/todo/list";
    }
}
