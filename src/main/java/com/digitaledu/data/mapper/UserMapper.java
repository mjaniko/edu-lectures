package com.digitaledu.data.mapper;

import com.digitaledu.data.dto.UserDTO;
import com.digitaledu.model.Users;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    UserDTO mapSingle(Users users);
    List<UserDTO> mapList(List<Users> usersList);
}