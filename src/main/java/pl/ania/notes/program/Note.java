package pl.ania.notes.program;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

//@Document(collection = "notes")
@Entity
public class Note {

    private String body;

    private String username;
    @javax.persistence.Id
    private  String id;

    public Note() {
    }

    @JsonCreator
    public Note(@JsonProperty("id") String id, @JsonProperty("body") String body, String username) {
        this.body = body;
        this.id = id;
        this.username = username;
    }

    public String getBody() {
        return body;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

}
