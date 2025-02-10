package com.ashfaq.unittesting.service;

import org.springframework.stereotype.Component;

import java.time.Year;

@Component
public class DiscountService    {

public float calculateDiscount(float amount,String promoCode){
if(promoCode==null){
    return 0;
}
if(promoCode.equals("THANKSGIVING")) {
return  amount * 0.1f;
}

    if(promoCode.equals("XMAS") && getCurrentYear().getValue() == 2029){
return  amount * 0.25f;
    }

    return 0;
}

 Year getCurrentYear() {
    return Year.now();
}
/*
Here we have a function which checks discount for a user based on promocode
if the promocode is null then we return 0
if the promocode is THANKSGIVING then we return 10% discount
if the promocode is XMAS and year is 2029  CURRENT YEAR .then we return 25% discount


Now we need to test this function
and this function has a helper function which returns current year
so for the unit test we can use @spybean


 */




}
