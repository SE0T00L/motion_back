package com.cnu.motion.Account;

import com.cnu.motion.DTO.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/users")
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping()
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

    @GetMapping
    public List<UserDTO> getAllUser() {
        return accountService.getAllUser();
    }

    @PostMapping("/logout")
    public boolean logout(HttpServletRequest request) {
        //Terminate session
        HttpSession session = request.getSession(false);
        session.invalidate();

        return true;
    }

    @PostMapping("/login")
    public UserDTO login(@RequestBody UserDTO user, HttpServletRequest request) {
        UserDTO storedUserInfo = accountService.getUserByUserId(user);
        if (storedUserInfo != null) {
                HttpSession session = request.getSession(true);
                session.setAttribute("userId", storedUserInfo.getUserId());
                session.setAttribute("userRoll", storedUserInfo.getUserRoll());

                storedUserInfo.setUserPwd(""); // hide user password;
                return storedUserInfo;
        }

        return null;
    }

    @GetMapping("/state")
    public UserDTO getLoginState(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        UserDTO user = new UserDTO();

        if (session != null) {
            user.setUserId((String)session.getAttribute("userId"));
            user.setUserRoll((String)session.getAttribute("userRoll"));
        }

        return user;
    }

    @DeleteMapping("/{userId}")
    public boolean deleteUser(@PathVariable("userId") String userId) {
        UserDTO user = new UserDTO();
        user.setUserId(userId);

        try {
            accountService.deleteUserByUserId(user);
        }
        catch (Exception e) {
            return false;
        }

        return true;
    }
}




