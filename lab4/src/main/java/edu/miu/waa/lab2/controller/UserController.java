package edu.miu.waa.lab2.controller;

import edu.miu.waa.lab2.aop.annotation.ExecutionTime;
import edu.miu.waa.lab2.aop.annotation.LogMe;
import edu.miu.waa.lab2.dto.PostDTO;
import edu.miu.waa.lab2.dto.UserDTO;
import edu.miu.waa.lab2.dto.UserDetailDTO;
import edu.miu.waa.lab2.service.PostService;
import edu.miu.waa.lab2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @LogMe
    @GetMapping
    public ResponseEntity<List<UserDTO>> findAllUsers() {
        List<UserDTO> userDTOList=userService.findAll();
        return userDTOList!=null ?
                ResponseEntity.ok(userDTOList):
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @ExecutionTime
    @LogMe
    @GetMapping("/{userId}")
    public ResponseEntity<UserDetailDTO> findUserById(@PathVariable Long userId) {
        UserDetailDTO userDTO= userService.findById(userId);
        return userDTO!=null ?
                ResponseEntity.ok(userDTO):
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

   // 6-	Cascade all the operations from the User to the Posts and Posts to the comments.
   // for save
    @LogMe
    @PostMapping
    public ResponseEntity<UserDetailDTO> addUser(@RequestBody UserDetailDTO userDTO) {
        UserDetailDTO user=userService.addUser(userDTO);
        return user!=null ?
                ResponseEntity.ok(user):
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    //6-	Cascade all the operations from the User to the Posts and Posts to the comments.
    // for delete
    @LogMe
    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
        boolean isDeleted=userService.deleteUser(userId);
        return isDeleted ?
                ResponseEntity.ok().body("Congratulations, Successfully deleted!") :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body("Please try again!!!!  Unsuccessfully deleted!");
    }

    @LogMe
    @GetMapping("/{userId}/posts")
    public ResponseEntity<List<PostDTO>> findPostByUserId(@PathVariable Long userId) {
        List<PostDTO> postDtos= userService.findPostByUserId(userId);
        return postDtos!=null ?
                ResponseEntity.ok(postDtos):
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


    @LogMe
    @GetMapping("/more-than-one-post")
    public ResponseEntity<List<UserDTO>> findAllUsersMoreThanOnePost() {
        List<UserDTO> userDTOList=userService.findAllUsersMoreThanOnePost();
        return userDTOList!=null ?
                ResponseEntity.ok(userDTOList):
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


    //7-	Make a query that will retrieve all the users that have more than (n) posts.
    @LogMe
    @GetMapping("/postsCount/{nPosts}")
    public ResponseEntity<List<UserDTO>> findAllUsersMoreThanNPost(@PathVariable Integer nPosts) {
        List<UserDTO> userDTOList=userService.findAllUsersMoreThanNPost(nPosts);
        return userDTOList!=null ?
                ResponseEntity.ok(userDTOList):
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    //9-	Make a query that will find the users that made posts within a given title
    @LogMe
    @GetMapping("/postTitle")
    public ResponseEntity<List<UserDetailDTO>> findAllUserByTitle(@RequestParam(name = "postTitle", required = false) String title) {
        List<UserDetailDTO> userDTOList=userService.findAllUserByTitle(title);
        return userDTOList!=null ?
                ResponseEntity.ok(userDTOList):
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


}
