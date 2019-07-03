package Hello.TODO;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private TodoRepository repository;

    TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    ResponseEntity<Todo> toggle(Integer id) {
        var todo = repository.findById(id);
        todo.ifPresent(t -> {
            t.setDone(!t.isDone());
            repository.save(t);
        });
        return todo.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
