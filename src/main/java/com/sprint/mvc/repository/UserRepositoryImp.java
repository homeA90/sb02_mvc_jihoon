package com.sprint.mvc.repository;

import com.sprint.mvc.entity.User;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

@Repository
public class UserRepositoryImp implements UserRepository {

    private static final Path DIRECTORY = Paths.get(System.getProperty("user.dir"), "data", "user");;


    public UserRepositoryImp() {
        if (!Files.exists(DIRECTORY)) {
            try {
                Files.createDirectories(DIRECTORY);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    @Override
    public User save(User user) {
        Path path = DIRECTORY.resolve(user.getUserUuid() + ".ser");
        try (
                FileOutputStream fos = new FileOutputStream(path.toFile());
                ObjectOutputStream oos = new ObjectOutputStream(fos)
        ) {
            oos.writeObject(user);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public User findByUserId(String userId) {
        return findAll().stream()
                .filter(user -> userId.equals(user.getUserId()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<User> findAll() {
        try (Stream<Path> path = Files.list(DIRECTORY)) {
            return path
                    .map(p -> {
                        try (FileInputStream fis = new FileInputStream(p.toFile());
                             ObjectInputStream ois = new ObjectInputStream(fis)) {
                            return (User) ois.readObject();
                        } catch (IOException | ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                    })
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public void delete(User user) {

    }
}
