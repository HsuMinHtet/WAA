package edu.miu.waa.lab2.service.impl;

import edu.miu.waa.lab2.domain.Post;
import edu.miu.waa.lab2.dto.PostDTO;
import edu.miu.waa.lab2.repo.PostRepo;
import edu.miu.waa.lab2.service.PostService;
import edu.miu.waa.lab2.exception.UserException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepo postRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<PostDTO> findAll() {
        List<PostDTO> postDtoList = new ArrayList<>();
        for (Post p : postRepo.findAll()) {
            postDtoList.add(modelMapper.map(p, PostDTO.class));
        }
        return postDtoList;
    }

    @Override
    public PostDTO findById(Long id) {
        idValidation(id);
        return modelMapper.map(postRepo.findById(id), PostDTO.class);
    }

    @Override
    public PostDTO addPost(PostDTO p) {
        postDataValidation(p);
        Post post = postRepo.save(modelMapper.map(p, Post.class));
        return modelMapper.map(post, PostDTO.class);
    }

    @Override
    public boolean deletePost(Long id) {
        idValidation(id);
        postRepo.deleteById(id);
        return true;
    }

    @Override
    public PostDTO updatePost(PostDTO p) {
        idValidation(p.getId());
        postDataValidation(p);
        Post post = postRepo.save(modelMapper.map(p, Post.class));
        return modelMapper.map(post, PostDTO.class);
    }

    @Override
    public List<PostDTO> getPostsByAuthor(String author) {
        if (author == null || author.isEmpty())
            throw new UserException("Author should not be null!!");
        List<PostDTO> postDtoList = new ArrayList<>();
        for (Post p : postRepo.getPostsByAuthor(author)) {
            postDtoList.add(modelMapper.map(p, PostDTO.class));
        }
        return postDtoList;
    }

    @Override
    public List<PostDTO> getPostByAuthorContain(String text) {
        if (text == null || text.isEmpty())
            throw new UserException("Text should not be null!!");
        List<PostDTO> postDtoList = new ArrayList<>();
        for (Post p : postRepo.getPostByAuthorContain(text)) {
            postDtoList.add(modelMapper.map(p, PostDTO.class));
        }
        return postDtoList;
    }

    private void postDataValidation(PostDTO p) {
        if (p.getAuthor().isEmpty() || p.getAuthor().isBlank()) {
            throw new UserException("Author should not be null!!");
        }
        if (p.getContent().isEmpty() || p.getContent().isBlank()) {
            throw new UserException("Content should not be null!!");
        }
        if (p.getTitle().isEmpty() || p.getTitle().isBlank()) {
            throw new UserException("Title should not be null!!");
        }
    }

    private void idValidation(Long id) {
        if (id == null || id == 0) {
            throw new UserException("Id should not be null!!");
        }
        if (!postRepo.existsById(id)) {
            throw new UserException("There has no this id!!");
        }
    }
    @Override
    public List<PostDTO> findAllPostByTitle(String title) {
        if(title.isEmpty()){
            throw new UserException("Post Title should not be null.");
        }
        List<Post>postList= postRepo.findAllPostByTitle(title);
        return postList.stream().map(post -> modelMapper.map(post,PostDTO.class)).toList();
    }

}
