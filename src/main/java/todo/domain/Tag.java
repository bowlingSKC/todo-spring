package todo.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Tag for some entity
 * @author lbalint
 * @since 2016.07.17.
 */
@Entity
@Table
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String title;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
