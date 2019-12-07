package com.cnu.motion.mapper;

import com.cnu.motion.DTO.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AccountMapper {
    void addNewUser(UserDTO user);
    List<UserDTO> getAllUser();
    UserDTO getUserByUserId(UserDTO user);
    void deleteUserByUserId(UserDTO user);
}
