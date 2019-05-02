package com.digitaledu.data.dto;

import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
public class LecturerDTO {

    @NotEmpty
    private String name;
}
