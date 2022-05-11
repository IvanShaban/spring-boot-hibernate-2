package com.example.servingwebcontent.service;

import com.example.servingwebcontent.repository.criteria.UserRepository;
import com.example.servingwebcontent.repository.entity.User;
import com.example.servingwebcontent.service.dto.UserCreateDto;
import com.example.servingwebcontent.service.dto.UserDto;
import com.example.servingwebcontent.service.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void create(UserCreateDto userCreateDto) {
        userRepository.save(UserMapper.INSTANCE.userCreateDtoToUser(userCreateDto));
    }

    public List<UserDto> getAll() {
        return userRepository.findAll().stream()
                .map(UserMapper.INSTANCE::userToUserDto)
                .collect(Collectors.toList());
    }

    public UserDto getById(Long id) {
        User user = userRepository.findById(id);
        return UserMapper.INSTANCE.userToUserDto(user);
    }

    public void update(UserDto userDto) {
        userRepository.save(UserMapper.INSTANCE.userDtoToUser(userDto));
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
