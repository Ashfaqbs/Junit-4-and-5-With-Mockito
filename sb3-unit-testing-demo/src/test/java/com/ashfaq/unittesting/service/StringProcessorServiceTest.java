package com.ashfaq.unittesting.service;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
// by adding this annotation this will enable the configuration for testing class in backend.
public class StringProcessorServiceTest {

    @Autowired
    private StringProcessorService stringProcessorService;

    /**
     * Verifies that a valid palindrome will return true.
     */
    @Test
    public void testIsPalindrome_ValidPalindrome()
    {
        // we will provide a string which is a palindrome
       var result= stringProcessorService.isPalindrome("racecar");

        Assertions.assertTrue(result);
// we are telling like we will get true but the result from the function will be true  so this test will pass



//        checking asserFalse
//        Assertions.assertFalse(result);
// we are telling like we will get false but the result will be true so this test will fail

    }

    @Test
    public void testIsPalindrome_InValidPalindrome()
    {
        // we will provide a string which is not a palindrome eg: hello
       var result= stringProcessorService.isPalindrome("hello");
//       we are telling like we will get false but the result will be false so this test will pass
       Assertions.assertFalse(result);
    }


    /*
    now there are two ways for handling the null case for our logic

 1. we will update the logic telling like if input is null return false (This way of testing is called Test driven development)


 2. we will throw exception if input is null in test case it self

     */
    @Test
    public void testIsPalindrome_NullString()
    {
        // we will provide a string which is null
       var result= stringProcessorService.isPalindrome(null);
//       we are telling like we will get false but the result will be false so this test will pass
       Assertions.assertFalse(result);
    }


//    @Test
//    public void testIsPalindrome_NullStringV2()
//    {


//        we will provide a string which is null
//        var result= stringProcessorService.isPalindrome(null);
//        we are telling like we will get false but the result will be false so this test will pass
//        Assertions.assertFalse(result);

//      Assuming we have not written any logic to handle null case in our service code

//        Assertions.assertThrows(NullPointerException.class,()->
//        {
//            stringProcessorService.isPalindrome(null);
//        });
//  above test case will be successful as we are throwing exception if input is null and even the code is not written to handle null case
// suppose tomorrow we write the logic to handle null case then this test case will fail
//        commenting out the whole logic as the null is handled in service code to return false
//    }


}
