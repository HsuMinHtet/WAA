package edu.miu.waa.lab2.controller;

import edu.miu.waa.lab2.dto.PostDTO;
import edu.miu.waa.lab2.service.PostService;
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
    public ResponseEntity<List<PostDTO>> findAllPosts() {
        List<PostDTO> postDtoList = postService.findAll();
        return postDtoList != null ?
                ResponseEntity.ok(postDtoList) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostDTO> findPostById(@PathVariable Long postId) {
        PostDTO postDto = postService.findById(postId);
        return postDto != null ?
                ResponseEntity.ok(postDto) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping("/")
    public ResponseEntity<PostDTO> addPost(@RequestBody PostDTO post) {
        PostDTO postDto = postService.addPost(post);
        return postDto != null ?
                ResponseEntity.ok(postDto) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("/{postId}")
    public ResponseEntity<PostDTO> updatePost(@PathVariable Long postId, @RequestBody PostDTO updatedPost) {
        updatedPost.setId(postId);
        PostDTO postDto = postService.updatePost(updatedPost);
        return postDto != null ?
                ResponseEntity.ok(postDto) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable Long postId) {
        boolean isDeleted = postService.deletePost(postId);
        return isDeleted ?
                ResponseEntity.ok().body("Congratulations, Successfully deleted!") :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body("Please try again!!!!  Unsuccessfully deleted!");
    }

    @GetMapping("/author/")
    public ResponseEntity<List<PostDTO>> getAllPostsByAuthor(@RequestParam(name = "author", required = false) String author) {
        List<PostDTO> postDtoList = postService.getPostsByAuthor(author);
        return postDtoList != null ?
                ResponseEntity.ok(postDtoList) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/author/name/")
    public ResponseEntity<List<PostDTO>> getAllPostsByAuthorContain(@RequestParam(name = "text", required = true) String text) {
        List<PostDTO> postDtoList = postService.getPostByAuthorContain(text);
        return postDtoList != null ?
                ResponseEntity.ok(postDtoList) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    //8-	Make a query that will find all the posts that match a given title.
    @GetMapping("/title")
    public ResponseEntity<List<PostDTO>> findAllPostByTitle(@RequestParam(name = "title", required = false) String title) {
        List<PostDTO> postDTOList = postService.findAllPostByTitle(title);
        return postDTOList != null ?
                ResponseEntity.ok(postDTOList) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
