package todo.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

/**
 * TODO item
 * @author lbalint
 * @since 2016.07.17.
 */
@Entity
@Table
public class Todo {

    public static enum Priority {
        LOW("LOW"), MEDIUM("MEDIUM"), HIGH("HIGH"), UNDEFINED("UNDEFINED");

        private String name;

        Priority(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String title;

    @Lob
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date created;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Priority priority;

    @ManyToMany
    private Set<Tag> tags;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public boolean hasTag(Tag tag) {
        for(Tag t : tags) {
            if(t.getTitle().equals(tag.getTitle())) {
                return true;
            }
        }
        return false;
    }
}
