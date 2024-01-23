package edu.miu.waa.lab2.service;

import edu.miu.waa.lab2.dto.PostDTO;
import edu.miu.waa.lab2.dto.UserDTO;
import edu.miu.waa.lab2.dto.UserDetailDTO;
import edu.miu.waa.lab2.exception.MyException;

import java.util.List;

public interface UserService {
    List<UserDTO> findAll();

    UserDetailDTO findById(Long userId) throws MyException;

    UserDetailDTO addUser(UserDetailDTO userDTO) throws MyException;

    List<PostDTO> findPostByUserId(Long userId) throws MyException;

    List<UserDTO> findAllUsersMoreThanOnePost();

    boolean deleteUser(Long userId) throws MyException;

    List<UserDTO> findAllUsersMoreThanNPost(Integer nPosts);

    List<UserDetailDTO> findAllUserByTitle(String title);

    UserDetailDTO findUserByCriteria(Long userId, Long postId, Long commentId);
}
