package com.ashfaq.unittesting.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.time.Year;

@SpringBootTest
public class DiscountServiceTest {


//@Autowired with autowire we cannot use @SpyBean concept so  comment the @Autowired and use @SpyBean
@SpyBean
private DiscountService discountService;

@Test
    public void testCalculateDiscount_ValidInput() {
    var result= discountService.calculateDiscount(10,"THANKSGIVING");
    Assertions.assertEquals(1f, result);

    }


    @Test
    public void testCalculateDiscount_ValidInputNull() {
        var result= discountService.calculateDiscount(10,null);
        Assertions.assertEquals(0, result);

    }


    /*

    Introduction to Spybean and Mockito
      for the function calculateDiscount the promocode  XMAS and as the year is hardcoded i.e 2029 so when we provide the promo code as XMAS  and year is as 2029 then the logic will work.
 if we see the year is 2025(current year) someother year which is not 2029 will fail, so we have to mock the method to return the year 2029 all the time, even though current can be any year.
     if we dont mock the method  getCurrentYear() will give us the current year i.e 2025 which will fail
     so we have to mock the method to return the year 2029 so the test will pass
     */

    @Test
    public void testCalculateDiscount_ValidPromoCodeForYear2025() {
        Mockito.when(discountService.getCurrentYear()).thenReturn(Year.of(2029));
        var result= discountService.calculateDiscount(20,"XMAS");
        Assertions.assertEquals(5f, result);

    }

/*
Test case is passed even the year is not 2029, so we have to mock the method to return the year 2029 using the Mockito.when(discountService.getCurrentYear()).thenReturn(Year.of(2029)) and @SpyBean;
 */
/*
Testing for diff year and expecting 0 as result

for year 2024 the result will be 0 as there is no discount
 */


    @Test
    public void testCalculateDiscount_ValidPromoCodeForYear2024() {
        Mockito.when(discountService.getCurrentYear()).thenReturn(Year.of(2024));// here the yar will be 2024 and the logic is XMAS and 2029 so function will return 0
        var result= discountService.calculateDiscount(20,"XMAS");

        Assertions.assertEquals(0f, result);

    }

/*
Note we can access the getCurrentYear() function even thought its a package private function
i,e accessed only in the package, we are able to access in test is because we are following the same package structure

if we make the util function private then we cannot access it in test

so make the function in default access so that it can be accessed in test, so we can access the function in test if we follow the same package structure
or make the function accessible with getters.

 */




}


