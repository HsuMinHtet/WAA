package edu.miu.waa.lab1.repo.impl;

import edu.miu.waa.lab1.domain.Post;
import edu.miu.waa.lab1.repo.PostRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepositoryImpl implements PostRepository {
    private static List<Post> fakeDatabase;
    private long postIdCounter = 3;

    static{
        fakeDatabase = new ArrayList<>();
        Post p1 = new Post (1L, "exercise_1", "exercise_1", "Hsu" );
        Post p2 = new Post (2L, "exercise_2", "exercise_2", "Rob" );
        fakeDatabase.add(p1);
        fakeDatabase.add(p2);
    }

    @Override
    public List<Post> findAll() {
        return new ArrayList<>(fakeDatabase);
    }

    @Override
    public Post findById(Long postId) {
        return fakeDatabase.stream()
                .filter(post -> post.getId()== postId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Post addPost(Post p) {
        p.setId(postIdCounter++);
        fakeDatabase.add(p);
        return p;
    }

    @Override
    public boolean delete(Long id) {
        return fakeDatabase.removeIf(post -> post.getId() == id);
    }

    @Override
    public Post updatePost(Post p) {
       if(fakeDatabase.removeIf(post -> post.getId()== (p.getId()))){
           fakeDatabase.add(p);
           return p;
       }
        else {
            return null;
       }
    }

    @Override
    public List<Post> getPostsByAuthor(String author) {
        return new ArrayList<Post>( fakeDatabase.stream()
                .filter(post -> post.getAuthor().equals(author)).toList());
    }

    @Override
    public List<Post> getPostByAuthorContain(String text) {
        return new ArrayList<Post>( fakeDatabase.stream()
                .filter(post -> post.getAuthor().contains(text)).toList());
    }

    @Override
    public boolean findId(Long id) {
        if(fakeDatabase.stream()
                .anyMatch(post -> post.getId()== id))
            return true;
        else
            return false;
    }


}
