package edu.miu.waa.lab1.service.impl;

import edu.miu.waa.lab1.domain.Post;
import edu.miu.waa.lab1.dto.PostDto;
import edu.miu.waa.lab1.exception.PostException;
import edu.miu.waa.lab1.repo.PostRepository;
import edu.miu.waa.lab1.service.PostService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final ModelMapper modelMapper;
    private final PostRepository postRepo;

    @Override
    public List<PostDto> findAll() {
        List<PostDto> postDtoList = new ArrayList<>();
        for (Post p : postRepo.findAll()) {
            postDtoList.add(modelMapper.map(p, PostDto.class));
        }
        return postDtoList;
    }

    @Override
    public PostDto findById(Long id) {
        idValidation(id);
        return modelMapper.map(postRepo.findById(id), PostDto.class);
    }

    @Override
    public PostDto addPost(PostDto p) {
        postDataValidation(p);
        Post post = postRepo.addPost(modelMapper.map(p, Post.class));
        return modelMapper.map(post, PostDto.class);
    }

    @Override
    public boolean deletePost(Long id) {
        idValidation(id);
        return postRepo.delete(id);
    }

    @Override
    public PostDto updatePost(PostDto p) {
        idValidation(p.getId());
        postDataValidation(p);
        Post post = postRepo.updatePost(modelMapper.map(p, Post.class));
        return modelMapper.map(post, PostDto.class);
    }

    @Override
    public List<PostDto> getPostsByAuthor(String author) {
        if (author == null || author.isEmpty())
            throw new PostException("Author should not be null!!");
        List<PostDto> postDtoList = new ArrayList<>();
        for (Post p : postRepo.getPostsByAuthor(author)) {
            postDtoList.add(modelMapper.map(p, PostDto.class));
        }
        return postDtoList;
    }

    @Override
    public List<PostDto> getPostByAuthorContain(String text) {
        if (text == null || text.isEmpty())
            throw new PostException("Text should not be null!!");
        List<PostDto> postDtoList = new ArrayList<>();
        for (Post p : postRepo.getPostByAuthorContain(text)) {
            postDtoList.add(modelMapper.map(p, PostDto.class));
        }
        return postDtoList;
    }

    private void postDataValidation(PostDto p) {
        if (p.getAuthor().isEmpty() || p.getAuthor().isBlank()) {
            throw new PostException("Author should not be null!!");
        }
        if (p.getContent().isEmpty() || p.getContent().isBlank()) {
            throw new PostException("Content should not be null!!");
        }
        if (p.getTitle().isEmpty() || p.getTitle().isBlank()) {
            throw new PostException("Title should not be null!!");
        }
    }

    private void idValidation(Long id) {
        if (id == null || id == 0) {
            throw new PostException("Id should not be null!!");
        }
        if (!postRepo.findId(id)) {
            throw new PostException("There has no this id!!");
        }
    }

}
