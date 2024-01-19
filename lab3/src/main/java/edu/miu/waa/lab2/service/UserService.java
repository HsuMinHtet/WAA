package edu.miu.waa.lab2.service;

import edu.miu.waa.lab2.dto.PostDTO;
import edu.miu.waa.lab2.dto.UserDTO;
import edu.miu.waa.lab2.dto.UserDetailDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> findAll();

    UserDetailDTO findById(Long userId);

    UserDetailDTO addUser(UserDetailDTO userDTO);

    List<PostDTO> findPostByUserId(Long userId);

    List<UserDTO> findAllUsersMoreThanOnePost();

    boolean deleteUser(Long userId);

    List<UserDTO> findAllUsersMoreThanNPost(Integer nPosts);

    List<UserDetailDTO> findAllUserByTitle(String title);

    UserDetailDTO findUserByCriteria(Long userId, Long postId, Long commentId);
}
