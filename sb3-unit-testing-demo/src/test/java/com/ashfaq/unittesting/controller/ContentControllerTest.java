package com.ashfaq.unittesting.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class ContentControllerTest {

    /*
    Note : when testing the spring security we need to make sure we have also added the lib spring-security-test which automatically comes along the spring security lib
     */
    @Autowired
    private MockMvc mockMvc;


    @Test
    void testWelcome_withoutLogin() {
        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/home")).andExpect(MockMvcResultMatchers.status().isOk());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }





    /*
    this will fail as we are accessing the api without providing the credentials.
     */
    @Test
    void testUserWelcome_withoutLogin() {
        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/user/home")).andExpect(MockMvcResultMatchers.status().is(302));
            /*
            302 because we are redirecting to the login page

            flow when we have not authenticated and call the url /user/home spring security will redirect us to the login page
            so the redirect status will be 302
             */
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }


    @Test
    @WithMockUser(username = "tester", roles = "USER")
//here we can define the username , role , password and authorities.
    void testUserWelcome_WithLogin() {
        try {

            /*
            in browser, we can provide creds and go to /user/home
            here we have to here we can stimulate the same flow using  @WithMockUser
            make sure we have added the lib spring-security-test


            eg     @WithMockUser(username = "tester", roles = "USER" )//here we can define the username , role , password and authorities.
              this will stimulate the logged-in user

            */
            mockMvc.perform(MockMvcRequestBuilders.get("/user/home")).andExpect(MockMvcResultMatchers.status().is(200));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }






    @Test
    void testAdminWelcome_withoutLogin() {
        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/admin/home")).andExpect(MockMvcResultMatchers.status().is(302));
            /*
            302 because we are redirecting to the login page

            flow when we have not authenticated and call the url /user/home spring security will redirect us to the login page
            so the redirect status will be 302
             */
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }






    @Test
    @WithMockUser(username = "tester", roles = "ADMIN")
//here we can define the username , role , password and authorities.
    void testAdminWelcome_WithLogin() {
        try {

            /*
            in browser, we can provide creds and go to /user/home
            here we have to here we can stimulate the same flow using  @WithMockUser
            make sure we have added the lib spring-security-test


            eg     @WithMockUser(username = "tester", roles = "USER" )//here we can define the username , role , password and authorities.
              this will stimulate the logged-in user

            */
            mockMvc.perform(MockMvcRequestBuilders.get("/admin/home")).andExpect(MockMvcResultMatchers.status().is(200));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }






/*
Normal user calling admin/home
 */


    @Test
    @WithMockUser(username = "tester", roles = "USER")
//here we can define the username , role , password and authorities.
    void testAdminWelcome_WithUserLogin() {
        try {

            /*
            in browser, we can provide creds and go to /user/home
            here we have to here we can stimulate the same flow using  @WithMockUser
            make sure we have added the lib spring-security-test


            eg     @WithMockUser(username = "tester", roles = "USER" )//here we can define the username , role , password and authorities.
              this will stimulate the logged-in user

            */
            mockMvc.perform(MockMvcRequestBuilders.get("/admin/home")).andExpect(MockMvcResultMatchers.status().is(403));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



    /*
    Admin user calling user/home

     */
    @Test
    @WithMockUser(username = "tester", roles = "ADMIN")
//here we can define the username , role , password and authorities.
    void testUserWelcome_WithAdminLogin() {
        try {

            /*
            in browser, we can provide creds and go to /user/home
            here we have to here we can stimulate the same flow using  @WithMockUser
            make sure we have added the lib spring-security-test


            eg     @WithMockUser(username = "tester", roles = "USER" )//here we can define the username , role , password and authorities.
              this will stimulate the logged-in user

            */
            mockMvc.perform(MockMvcRequestBuilders.get("/user/home")).andExpect(MockMvcResultMatchers.status().is(403));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
