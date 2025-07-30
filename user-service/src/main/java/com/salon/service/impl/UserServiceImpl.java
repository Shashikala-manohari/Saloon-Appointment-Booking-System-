package com.salon.service.impl;

import com.salon.exception.UserException;
import com.salon.modal.User;
import com.salon.repository.UserRepository;
import com.salon.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(long id) throws UserException {
        Optional<User> otp = userRepository.findById(id);
        if(otp.isPresent()){
            return otp.get();
        }
        throw new UserException("User not found");
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(Long id) throws UserException {
        Optional<User> otp = userRepository.findById(id);
        if(otp.isEmpty()){
            throw new UserException("User not exist with Id: "+id);
        }
        userRepository.deleteById(otp.get().getId());
    }

    @Override
    public User updateUser(Long id, User user) throws UserException {
        Optional<User> otp = userRepository.findById(id);
        if(otp.isEmpty()){
            throw new UserException("User not found with Id: "+id);
        }
        User existinguser = otp.get();

        existinguser.setFullName(user.getFullName());
        existinguser.setPhone(user.getPhone());
        existinguser.setEmail(user.getEmail());
        existinguser.setRole(user.getRole());
        existinguser.setPassword(user.getPassword());
        existinguser.setUsername(user.getUsername());

        return userRepository.save(existinguser);
    }
}
