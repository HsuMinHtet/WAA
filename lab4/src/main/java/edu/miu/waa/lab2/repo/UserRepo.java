package edu.miu.waa.lab2.repo;

import edu.miu.waa.lab2.domain.Post;
import edu.miu.waa.lab2.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepo extends JpaRepository<Users, Long> {
    @Query(value = "select u.posts from Users u where u.id=:userId")
    List<Post> findPostByUserId(Long userId);
    @Query(value = "select u from Users u where size(u.posts) > 1")
    List<Users> findAllUsersMoreThanOnePost();
    @Query(value = "select u from Users u where size(u.posts) >= :nPosts")
    List<Users> findAllUsersMoreThanNPost(Integer nPosts);
    @Query(value = "SELECT DISTINCT u FROM Users u JOIN u.posts p WHERE p.title = :postTitle")
    List<Users> findAllUserByTitle(String postTitle);


}
