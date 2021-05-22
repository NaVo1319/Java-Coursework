package ru.mirea.cursework.repo;

import org.springframework.data.repository.CrudRepository;
import ru.mirea.cursework.entity.Post;

import java.util.Optional;

public interface PostRepo extends CrudRepository<Post,Long> {
}
