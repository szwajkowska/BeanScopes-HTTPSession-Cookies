package pl.ania.notes.program;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserList {

    @Autowired
    private UserRepositoryMongo userRepositoryMongo;


//    private final List<User> usersList = new ArrayList<>();


    public void addUser(String username, String password) {
        userRepositoryMongo.save(new User(username, password));
    }

    public Optional<User> getUser(String username) {
        return Optional.ofNullable(userRepositoryMongo.findByUsername(username));

//        stream()
//                .filter(u -> u.getUsername().equals(username))
//                .findAny();
    }
}


