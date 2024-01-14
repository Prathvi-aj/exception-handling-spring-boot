package com.springexception.exceptionhandling.services;

import com.springexception.exceptionhandling.dto.UserDto;
import com.springexception.exceptionhandling.exception.ResourceNotFoundException;
import com.springexception.exceptionhandling.models.User;
import org.springframework.stereotype.Service;
import com.springexception.exceptionhandling.repos.UserRepo;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class UserService {
    private final UserRepo userRepo;
    private final  MapperService mapperService;
    UserService(UserRepo userRepo,MapperService mapperService)
    {
        this.userRepo=userRepo;
        this.mapperService=mapperService;
    }
    public List<UserDto> getUserDetails(){
        List<User> users=userRepo.findAll();
        List<UserDto> dtos = users
                .stream()
                .map(user -> mapperService.map(user, UserDto.class))
                .collect(Collectors.toList());
        return dtos;
    }
    public void saveUser(UserDto userDto){
        User user=mapperService.map(userDto, User.class);
        userRepo.save(user);
    }

    public UserDto getUserById(String userId) {
        User user=userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","Id",userId));
       return mapperService.map(user,UserDto.class);
    }
}
