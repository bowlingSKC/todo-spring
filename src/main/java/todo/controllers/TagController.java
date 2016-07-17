package todo.controllers;

import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import todo.domain.Tag;
import todo.exceptions.AlreadyExistsException;
import todo.repositories.TagRepository;
import todo.services.TagService;

import java.util.Set;

/**
 * Created by dev on 2016.07.17..
 */
@Controller
public class TagController {

    @Autowired
    private TagService tagService;

    @Autowired
    private TagRepository tagRepository;

    @RequestMapping(value = "/tag/add", method = RequestMethod.PUT, produces = "application/json")
    public @ResponseBody Tag createTag(@RequestParam String name)  {
        try {
            return tagService.addNewTag(name);
        } catch (AlreadyExistsException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/tag/all", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Set<Tag> getAllTag() {
        return Sets.newHashSet(tagRepository.findAll());
    }

}
