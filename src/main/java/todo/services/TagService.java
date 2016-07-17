package todo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import todo.domain.Tag;
import todo.exceptions.AlreadyExistsException;
import todo.repositories.TagRepository;

/**
 * Created by dev on 2016.07.17..
 */
@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    public Tag addNewTag(String name) throws AlreadyExistsException {
        Tag tag = tagRepository.findByTitle(name);
        if( tag != null ) {
            throw new AlreadyExistsException("Tag with given name has already exists!");
        }
        tag = new Tag();
        tag.setTitle(name);
        return tagRepository.save(tag);
    }

}
