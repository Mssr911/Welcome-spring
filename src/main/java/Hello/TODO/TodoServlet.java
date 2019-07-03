package Hello.TODO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
class TodoServlet {

    private final Logger logger = LoggerFactory.getLogger(TodoServlet.class);

    private TodoService service;
    private TodoRepository repository;

    TodoServlet(TodoService service, TodoRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    @GetMapping
    ResponseEntity<List<Todo>> findAllTodos() {
        logger.info("Got request.");
        return ResponseEntity.ok(repository.findAll());

    }

    @PutMapping("/{id}")
    ResponseEntity<Todo> toggleTodo(@PathVariable Integer id) {
        return service.toggle(id);
    }

    @PostMapping
    ResponseEntity<Todo> addTodo(@RequestBody Todo todo) {
        return ResponseEntity.ok(repository.save(todo));
    }
}
