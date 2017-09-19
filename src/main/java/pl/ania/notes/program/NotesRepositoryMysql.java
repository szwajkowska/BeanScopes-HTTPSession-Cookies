package pl.ania.notes.program;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NotesRepositoryMysql extends CrudRepository<Note, String> {

    List<Note> findByUsername(String username);
}
