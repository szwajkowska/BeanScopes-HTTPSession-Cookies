package pl.ania.notes.program;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotesRepositoryMongo extends MongoRepository<Note, String> {//czemu tu jest String?


}
