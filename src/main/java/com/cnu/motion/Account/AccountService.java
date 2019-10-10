package com.cnu.motion.Account;

import com.cnu.motion.DTO.UserDTO;
import com.cnu.motion.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service
public class AccountService {

    @Autowired
    AccountMapper accountMapper;

    @Transactional(rollbackFor = SQLException.class)
    public void addNewUser(UserDTO user) throws DuplicateKeyException, Exception {
        try {
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            user.setUserPwd(passwordEncoder.encode(user.getUserPwd()));
            accountMapper.addeNewUser(user);
        } catch (DuplicateKeyException e) {
            throw new DuplicateKeyException("Duplicated userId : User is already exist");
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new Exception();
        }
    }
}
