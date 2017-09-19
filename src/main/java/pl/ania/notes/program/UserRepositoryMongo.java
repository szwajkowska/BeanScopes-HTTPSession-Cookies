package pl.ania.notes.program;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepositoryMongo extends MongoRepository<User, String> {

 User findByUsername(String usermane);

}