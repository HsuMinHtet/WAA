package edu.miu.waa.lab1.repo;

import edu.miu.waa.lab1.domain.Post;
import edu.miu.waa.lab1.dto.PostDto;

import java.util.List;

public interface PostRepo {
    List<Post> findAll();

    Post findById(Long postId);

    Post addPost(Post p);

    boolean delete (Long p);

    Post updatePost(Post p);

    List<Post> getPostsByAuthor(String author);

    List<Post> getPostByAuthorContain(String text);

    boolean findId(Long id);
}
