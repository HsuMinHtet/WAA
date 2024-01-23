package edu.miu.waa.lab2.service;

import edu.miu.waa.lab2.dto.PostDTO;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PostService {

    List<PostDTO> findAll();

    PostDTO findById(Long id);

    PostDTO addPost(PostDTO p);

    boolean deletePost(Long id);

    PostDTO updatePost(PostDTO p);

    List<PostDTO> getPostsByAuthor(String author);

    List<PostDTO> getPostByAuthorContain(String text);

    List<PostDTO> findAllPostByTitle(String title);
}
