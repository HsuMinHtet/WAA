package edu.miu.waa.lab1.service;

import edu.miu.waa.lab1.dto.PostDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PostService {

    List<PostDto> findAll();

    PostDto findById(Long id);

    PostDto addPost(PostDto p);

    boolean deletePost(Long id);

    PostDto updatePost(PostDto p);

    List<PostDto> getPostsByAuthor(String author);

    List<PostDto> getPostByAuthorContain(String text);
}
