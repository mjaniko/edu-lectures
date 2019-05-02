package com.digitaledu.data.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ResponseDTO<T> {
    private boolean success;
    private T content;
}
