package todo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import todo.domain.Tag;

/**
 * Created by dev on 2016.07.17..
 */
@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {
    Tag findByTitle(String title);
}
