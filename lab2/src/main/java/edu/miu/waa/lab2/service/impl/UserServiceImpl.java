package edu.miu.waa.lab2.service.impl;

import edu.miu.waa.lab2.domain.User;
import edu.miu.waa.lab2.dto.PostDTO;
import edu.miu.waa.lab2.dto.UserDTO;
import edu.miu.waa.lab2.dto.UserDetailDTO;
import edu.miu.waa.lab2.repo.UserRepo;
import edu.miu.waa.lab2.service.UserService;
import exception.UserException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<UserDTO> findAll() {
        List<User> userList = userRepo.findAll();
        return userList.stream().map(user -> modelMapper.map(user, UserDTO.class)).toList();
    }

    @Override
    public UserDetailDTO findById(Long userId) {
        checkUserId(userId);
        return modelMapper.map(userRepo.findById(userId).get(), UserDetailDTO.class);
    }

    @Override
    public UserDetailDTO addPost(UserDetailDTO userDTO) {
        validationUserData(userDTO);
        return modelMapper.map(userRepo.save(modelMapper.map(userDTO, User.class)), UserDetailDTO.class);
    }

    @Override
    public List<PostDTO> findPostByUserId(Long userId) {
        checkUserId(userId);
        return userRepo.findPostByUserId(userId).stream().map(post -> modelMapper.map(post,PostDTO.class)).toList();
    }

    @Override
    public List<UserDTO> findAllUsersMoreThanOnePost() {
       return userRepo.findAllUsersMoreThanOnePost().stream().map(user->modelMapper.map(user,UserDTO.class)).toList();
    }

    private void validationUserData(UserDetailDTO userDTO) {
        if (userDTO.getName().isEmpty()) {
            throw new UserException("User Name should not be empty.");
        }
        if (userDTO.getPosts().isEmpty()) {
            throw new UserException("Post data should not be empty.");
        }
    }

    private void checkUserId(Long userId) {
        if (userId.equals(0L)) {
            throw new UserException("User Id should not be 0");
        }
        if (userRepo.findById(userId).isEmpty()) {
            throw new UserException("There is no this user!!");
        }
    }
}
