package ru.mirea.cursework.repo;

import org.springframework.data.repository.CrudRepository;
import ru.mirea.cursework.entity.User;

public interface UserRepo extends CrudRepository<User,Long> {
    User findByUsername(String username);
}
