package com.cnu.motion.Account;

import com.cnu.motion.DTO.UserDTO;
import com.cnu.motion.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
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
            accountMapper.addNewUser(user);
        } catch (DuplicateKeyException e) {
            throw new DuplicateKeyException("Duplicated userId : User is already exist");
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new Exception();
        }
    }

    public UserDTO getUserByUserId(UserDTO user) {
        return accountMapper.getUserByUserId(user);
    }

    public void deleteUserByUserId(UserDTO user) {
        accountMapper.deleteUserByUserId(user);
    }
}
