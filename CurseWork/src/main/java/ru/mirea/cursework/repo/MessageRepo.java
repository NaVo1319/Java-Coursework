package ru.mirea.cursework.repo;

import org.springframework.data.repository.CrudRepository;
import ru.mirea.cursework.entity.Message;

public interface MessageRepo extends CrudRepository<Message,Long> {
}
