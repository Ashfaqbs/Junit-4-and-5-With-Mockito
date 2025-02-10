package com.ashfaq.unittesting.service;


import org.springframework.stereotype.Service;

@Service
public class StringProcessorService {

    public boolean isPalindrome(String string)
    {
        if(string == null) return false;
        return  new StringBuilder(string).reverse().toString().equals(string);
    }
}
