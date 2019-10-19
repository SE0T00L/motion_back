package com.cnu.motion.mapper;

import com.cnu.motion.DTO.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AccountMapper {
    void addNewUser(UserDTO user);
    UserDTO getUserByUserId(UserDTO user);
}
