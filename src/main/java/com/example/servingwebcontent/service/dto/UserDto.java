package com.example.servingwebcontent.service.dto;

import com.example.servingwebcontent.repository.entity.Sex;
import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
@Value
public class UserDto {
    @NotNull
    Long id;
    @NotBlank
    String name;
    @NotNull
    String sex;
    String email;
}
