package edu.miu.waa.lab2.controller;

import edu.miu.waa.lab2.aop.annotation.ExecutionTime;
import edu.miu.waa.lab2.aop.annotation.LogMe;
import edu.miu.waa.lab2.dto.UserDTO;
import edu.miu.waa.lab2.dto.UserDetailDTO;
import edu.miu.waa.lab2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class MainController {

    private final UserService userService;

    @LogMe
    @GetMapping("/{userId}/filter")
    public ResponseEntity<UserDetailDTO> findAllUsers(
            @PathVariable("userId") Long userId,
            @RequestParam(value = "posts", required = false) Long postId,
            @RequestParam(value = "comments", required = false) Long  commentId)
    {
        UserDetailDTO userDetailDTO=userService.findUserByCriteria(userId,postId,commentId);
        return userDetailDTO!=null ?
                ResponseEntity.ok(userDetailDTO):
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
