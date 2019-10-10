package com.cnu.motion.Account;

import com.cnu.motion.DTO.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping("/join")
    public String addNewUser(@RequestBody UserDTO user) {

        try {
            accountService.addNewUser(user);
        } catch (DuplicateKeyException e) {
            return "duplicatedKey";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "error";
        }

        return "success";
    }

}
