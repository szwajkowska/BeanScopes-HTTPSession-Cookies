package pl.ania.notes.program;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;
import java.util.UUID;

@Service
@SessionScope//skąd się wzięłą ta adnotacja?
public class NoteService {

    private NotesRepository notesRepository;
    private NotesRepositoryMongo notesRepositoryMongo;
    private NotesRepositoryMysql notesRepositoryMysql;

    public NoteService(NotesRepository notesRepository, NotesRepositoryMongo notesRepositoryMongo,
                       NotesRepositoryMysql notesRepositoryMysql) {
        this.notesRepository = notesRepository;
        this.notesRepositoryMongo = notesRepositoryMongo;
        this.notesRepositoryMysql = notesRepositoryMysql;
    }

    public String save(NoteRequest noteRequest, String user) {
        String id = notesRepository.addNote(new Note(UUID.randomUUID().toString(), noteRequest.getBody(), user));
        return id;
    }

    public void delete(String id) { //czy muszą tu być te metody: delete i replace?
        notesRepository.delete(id);
    }


    public List<Note> getAll(String user) {
//        return notesRepositoryMongo.findAll().stream()
//                .filter(u -> u.getUsername().equals(user))
//                .collect(Collectors.toList());
//        return StreamSupport.stream(notesRepositoryMysql.findAll().spliterator(), false)
//                .filter(u -> u.getUsername().equals(user))
//                .collect(Collectors.toList());

        return notesRepositoryMysql.findByUsername(user);
//        return new ArrayList<>(userRepository.getNotesMap(user).values());
    }

    public Note findNoteById(String id) {
//        Note note = notesRepositoryMongo.findOne(id);
        Note note = notesRepositoryMysql.findOne(id);
        return note;
    }

    void update(NoteRequest noteRequest, String id, String user){
        notesRepository.replaceNote(new Note(id, noteRequest.getBody(), user));
    }

}
