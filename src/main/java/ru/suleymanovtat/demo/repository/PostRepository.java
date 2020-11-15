package ru.suleymanovtat.demo.repository;

import org.springframework.data.repository.CrudRepository;
import ru.suleymanovtat.demo.models.Post;

//CrudRepository модель и тип идентификатор
public interface PostRepository extends CrudRepository<Post, Long> {
}
