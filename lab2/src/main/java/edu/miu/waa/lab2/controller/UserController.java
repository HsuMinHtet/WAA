package edu.miu.waa.lab2.controller;

import edu.miu.waa.lab2.dto.PostDTO;
import edu.miu.waa.lab2.dto.UserDTO;
import edu.miu.waa.lab2.dto.UserDetailDTO;
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

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAllUsers() {
        List<UserDTO> userDTOList=userService.findAll();
        return userDTOList!=null ?
                ResponseEntity.ok(userDTOList):
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDetailDTO> findUserById(@PathVariable Long userId) {
        UserDetailDTO userDTO= userService.findById(userId);
        return userDTO!=null ?
                ResponseEntity.ok(userDTO):
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping
    public ResponseEntity<UserDetailDTO> addUser(@RequestBody UserDetailDTO userDTO) {
        UserDetailDTO user=userService.addPost(userDTO);
        return user!=null ?
                ResponseEntity.ok(user):
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/{userId}/posts")
    public ResponseEntity<List<PostDTO>> findPostByUserId(@PathVariable Long userId) {
        List<PostDTO> postDtos= userService.findPostByUserId(userId);
        return postDtos!=null ?
                ResponseEntity.ok(postDtos):
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/posts")
    public ResponseEntity<List<UserDTO>> findAllUsersMoreThanOnePost() {
        List<UserDTO> userDTOList=userService.findAllUsersMoreThanOnePost();
        return userDTOList!=null ?
                ResponseEntity.ok(userDTOList):
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
