package todo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import todo.domain.Todo;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {
}
