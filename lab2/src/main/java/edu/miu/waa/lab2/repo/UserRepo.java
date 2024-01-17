package edu.miu.waa.lab2.repo;

import edu.miu.waa.lab2.domain.Post;
import edu.miu.waa.lab2.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {
    @Query(value = "select u.posts from User u where u.id=:userId")
    List<Post> findPostByUserId(Long userId);
    @Query(value = "select u from User u where size(u.posts) > 1")
    List<User> findAllUsersMoreThanOnePost();
}
