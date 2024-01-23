package edu.miu.waa.lab2.service.impl;

import edu.miu.waa.lab2.domain.User;
import edu.miu.waa.lab2.dto.PostDTO;
import edu.miu.waa.lab2.dto.UserCriteriaRequest;
import edu.miu.waa.lab2.dto.UserDTO;
import edu.miu.waa.lab2.dto.UserDetailDTO;
import edu.miu.waa.lab2.exception.MyException;
import edu.miu.waa.lab2.repo.UserRepo;
import edu.miu.waa.lab2.repo.UserSearchDao;
import edu.miu.waa.lab2.service.UserService;
import edu.miu.waa.lab2.exception.UserException;
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
    public UserDetailDTO findById(Long userId) throws MyException {
        checkUserId(userId);
        return modelMapper.map(userRepo.findById(userId).get(), UserDetailDTO.class);
    }

    @Override
    public UserDetailDTO addUser(UserDetailDTO userDTO) throws MyException {
        validationUserData(userDTO);
        return modelMapper.map(userRepo.save(modelMapper.map(userDTO, User.class)), UserDetailDTO.class);
    }

    @Override
    public List<PostDTO> findPostByUserId(Long userId) throws MyException {
        checkUserId(userId);
        return userRepo.findPostByUserId(userId).stream().map(post -> modelMapper.map(post, PostDTO.class)).toList();
    }

    @Override
    public List<UserDTO> findAllUsersMoreThanOnePost() {
        return userRepo.findAllUsersMoreThanOnePost().stream().map(user -> modelMapper.map(user, UserDTO.class)).toList();
    }

    @Override
    public boolean deleteUser(Long userId) throws MyException {
        checkUserId(userId);
        userRepo.deleteById(userId);
        return true;
    }

    @Override
    public List<UserDTO> findAllUsersMoreThanNPost(Integer nPosts) {
        return userRepo.findAllUsersMoreThanNPost(nPosts).stream().map(user -> modelMapper.map(user, UserDTO.class)).toList();
    }

    @Override
    public List<UserDetailDTO> findAllUserByTitle(String postTitle) {
        if (postTitle.isEmpty()) {
            throw new UserException("Post Title should not be null.");
        }
        List<User> userList = userRepo.findAllUserByTitle(postTitle);
        System.out.print("Title" + postTitle + "<<<<user list count>>>" + userList.size());
        return userList.stream().map(user -> modelMapper.map(user, UserDetailDTO.class)).toList();
    }

    private final UserSearchDao userSearchDao;

    @Override
    public UserDetailDTO findUserByCriteria(Long userId, Long postId, Long commentId) {
        UserCriteriaRequest userCriteriaRequest = new UserCriteriaRequest();
        userCriteriaRequest.setUserId(userId);
        userCriteriaRequest.setPostId(postId);
        userCriteriaRequest.setCommentId(commentId);
        return modelMapper.map(userSearchDao.findUserByCriteria(userCriteriaRequest), UserDetailDTO.class);
    }

    private void validationUserData(UserDetailDTO userDTO) throws MyException {
        if (userDTO.getName().isEmpty()) {
            throw new MyException("My Exception");
            // throw new UserException("User Name should not be empty.");
        }
        if (userDTO.getPosts().isEmpty()) {
            throw new MyException("My Exception");
            // throw new UserException("Post data should not be empty.");
        }
    }

    private void checkUserId(Long userId) throws MyException {
        if (userId.equals(0L)) {
            throw new MyException("My Exception");
            //  throw new UserException("User Id should not be 0");
        }
        if (userRepo.findById(userId).isEmpty()) {
            throw new MyException("My Exception");
            // throw new UserException("There is no this user!!");
        }
    }
}
