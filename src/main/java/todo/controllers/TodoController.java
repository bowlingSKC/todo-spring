package todo.controllers;

import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import todo.domain.Todo;
import todo.repositories.TodoRepository;

import java.util.Set;

@Controller
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @RequestMapping(value = "/todo/all", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Set<Todo> getAllTodoItems() {
        return Sets.newHashSet(todoRepository.findAll());
    }

}
