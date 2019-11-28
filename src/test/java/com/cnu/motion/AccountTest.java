package com.cnu.motion;

import com.cnu.motion.Account.AccountController;
import com.cnu.motion.Account.AccountService;
import com.cnu.motion.DTO.UserDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(AccountController.class)
public class AccountTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    AccountController accountController;

    @InjectMocks
    AccountService accountService;

    protected MockHttpSession session;

    @Before
    public void setSession() {
        session = new MockHttpSession();
    }

    @Test
    public void login() throws Exception{
        UserDTO user = new UserDTO();
        user.setUserId("222222222");
        user.setUserPwd("2222");
        user.setUserRoll("USER");

        ObjectMapper mapper = new ObjectMapper();
        String userJson = mapper.writeValueAsString(user);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("user", userJson);

        MvcResult result = mockMvc.perform(post("/user/login").contentType(MediaType.APPLICATION_JSON_UTF8).content(userJson))
                .andExpect(status().isOk())
                .andReturn();
    }

    @After
//    @Ignore
    public void checkSessionValueAfterSuccessInLogin() throws Exception{
            mockMvc.perform(post("/user/state"))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
