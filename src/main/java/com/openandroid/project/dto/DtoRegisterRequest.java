package com.openandroid.project.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoRegisterRequest {
    private String name;
    private String email;
    private String password;
}
