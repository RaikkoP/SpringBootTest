package com.mycompany.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired private UserRepository repo;

    public List<User> listAll() {
        return (List<User>) repo.findAll();
    }

    public void save(User user) {
        repo.save(user);
    }

    public User get(Integer id) throws UserNotFoundExpection {
        Optional<User> result = repo.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new UserNotFoundExpection("Could not find any users with ID " + id);
    }

    public void delete(Integer id) throws UserNotFoundExpection {
        Optional<User> user = repo.findById(id);
        User foundUser = user.get();
        repo.delete(foundUser);
    }
}