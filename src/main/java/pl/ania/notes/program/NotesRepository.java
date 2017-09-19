package pl.ania.notes.program;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NotesRepository {

//    @Autowired
//    private NotesRepositoryMongo notesRepositoryMongo;

    private NotesRepositoryMysql notesRepositoryMysql;

//    public NotesRepository(NotesRepositoryMongo notesRepositoryMongo, NotesRepositoryMysql notesRepositoryMysql) {
    public NotesRepository(NotesRepositoryMysql notesRepositoryMysql) {
//        this.notesRepositoryMongo = notesRepositoryMongo;
        this.notesRepositoryMysql = notesRepositoryMysql;
    }


//    private final Map<Long, Note> notesMap = new HashMap<>();
//    private final AtomicLong counter = new AtomicLong();
//
//    public Map<Long, Note> getNotesMap() {
//        return notesMap;
//    }

    public String addNote(Note note) {
//       return notesRepositoryMongo.save(note).getId();
        return notesRepositoryMysql.save(note).getId();

    }
//        if (note.getId() != null) {
//            throw new IllegalArgumentException("notes id must be null");
//        }
//        long id = counter.incrementAndGet();
//        notesMap.put(id, new Note(id, note.getBody()));
//        return id;
//    }

    public void delete(String id) { //czy nie lepiej zrobic id jako parametr?   zmieniłam na void
//        notesRepositoryMongo.delete(id);
//        notesMap.remove(id);
        notesRepositoryMysql.delete(id);

    }


    public Note replaceNote(Note note) {
//        return notesRepositoryMongo.save(note);
        return notesRepositoryMysql.save(note);

//        notesMap.put(note.getId(), note);
//        return note;
    }
}
