package com.example.bankcards.service;

import com.example.bankcards.dto.RegisterRequest;
import com.example.bankcards.entity.User;
import com.example.bankcards.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
private final UserRepository userRepository;
@Override
    public List<User> getAllUsers(){
    return userRepository.findAll();
}
@Override
    public User getUserById(Long id){
    return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
}
@Override
    public User saveUser(User user){
    return userRepository.save(user);
}
@Override
    public void deleteUser(Long id){
    userRepository.deleteById(id);
}
@Override
    public User register(RegisterRequest request){
    User user = new User();
    user.setName(request.getUsername());
    user.setPassword(request.getPassword());
    return userRepository.save(user);
}
@Override
    public User findByUsername(String username){
    return userRepository.findByUsername(username);
}
}
