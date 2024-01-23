package edu.miu.waa.lab2.repo;

import edu.miu.waa.lab2.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Long> {

    @Query(value = "select p from Post p where p.title = :title")
    List<Post> findAllPostByTitle(@Param("title") String title);

    @Query(value = "select p from Post p where p.author= :author")
    List<Post> getPostsByAuthor(String author);

    @Query(value = "select p from Post p where p.author like :text")
    List<Post> getPostByAuthorContain(String text);
}
