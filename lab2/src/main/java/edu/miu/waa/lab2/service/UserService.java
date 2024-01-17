package edu.miu.waa.lab2.service;

import edu.miu.waa.lab2.dto.PostDTO;
import edu.miu.waa.lab2.dto.UserDTO;
import edu.miu.waa.lab2.dto.UserDetailDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> findAll();

    UserDetailDTO findById(Long userId);

    UserDetailDTO addPost(UserDetailDTO userDTO);

    List<PostDTO> findPostByUserId(Long userId);

    List<UserDTO> findAllUsersMoreThanOnePost();
}
