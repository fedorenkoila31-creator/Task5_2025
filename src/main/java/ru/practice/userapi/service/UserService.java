package ru.practice.userapi.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.practice.userapi.model.User;
import ru.practice.userapi.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<User> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<User> findById(Long id) {
        return repository.findById(id);
    }

    public User create(User user) {
        user.setId(null);
        user.setCreatedAt(LocalDateTime.now());
        return repository.save(user);
    }

    public Optional<User> update(Long id, User data) {
        return repository.findById(id).map(user -> {
            user.setName(data.getName());
            user.setEmail(data.getEmail());
            return repository.save(user);
        });
    }

    public boolean delete(Long id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }
}
