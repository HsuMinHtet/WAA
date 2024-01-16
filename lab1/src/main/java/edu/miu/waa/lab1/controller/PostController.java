package edu.miu.waa.lab1.controller;

import edu.miu.waa.lab1.dto.PostDto;
import edu.miu.waa.lab1.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("/")
    public ResponseEntity<List<PostDto>> findAllPosts() {
        List<PostDto> postDtoList=postService.findAll();
        return postDtoList!=null ?
                ResponseEntity.ok(postDtoList):
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostDto> findPostById(@PathVariable Long postId) {
        PostDto postDto= postService.findById(postId);
        return postDto!=null ?
                ResponseEntity.ok(postDto):
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping("/")
    public ResponseEntity<PostDto> addPost(@RequestBody PostDto post) {
        PostDto postDto=postService.addPost(post);
        return postDto!=null ?
                ResponseEntity.ok(postDto):
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("/{postId}")
    public ResponseEntity<PostDto> updatePost(@PathVariable Long postId, @RequestBody PostDto updatedPost) {
        updatedPost.setId(postId);
        PostDto postDto= postService.updatePost(updatedPost);
        return postDto!=null ?
                ResponseEntity.ok(postDto):
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable Long postId) {
        boolean isDeleted=postService.deletePost(postId);
        return isDeleted ?
                ResponseEntity.ok().body("Congratulations, Successfully deleted!") :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body("Please try again!!!!  Unsuccessfully deleted!");
    }

    @GetMapping("/author/")
    public ResponseEntity<List<PostDto>> getAllPostsByAuthor(@RequestParam(name = "author", required = false) String author) {
        List<PostDto> postDtoList=postService.getPostsByAuthor(author);
        return postDtoList!=null ?
                ResponseEntity.ok(postDtoList):
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/author/name/")
    public ResponseEntity<List<PostDto>> getAllPostsByAuthorContain(@RequestParam(name = "text", required = true) String text) {
        List<PostDto> postDtoList=postService.getPostByAuthorContain(text);
        return postDtoList!=null ?
                ResponseEntity.ok(postDtoList):
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
