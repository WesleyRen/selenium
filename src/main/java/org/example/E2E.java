package org.example;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;



public class E2E {



   public static void main(String[] args) throws InterruptedException {

// TODO Auto-generated method stub
      WebDriver driver =new ChromeDriver();
      driver.get("http://spicejet.com"); //URL in the browser

      driver.findElement(By.xpath("//div[contains(text(),'one way')]")).click();

      driver.findElement(By.cssSelector("div[data-testid='to-testID-origin']")).click();

      driver.findElement(By.xpath("//div[contains(text(),'Indira Gandhi International Airport')]")).click();

      Thread.sleep(2000);

      driver.findElement(By.xpath("//div[contains(text(),'Chennai International Airport')]")).click();
      driver.findElement(By.cssSelector("div[data-testid='undefined-calendar-day-10']")).click();

      if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"))

      {

         System.out.println("its disabled");

         Assert.assertTrue(true);

      }

      else

      {

         Assert.assertTrue(false);

      }

      driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();

      driver.findElement(By.id("divpaxinfo")).click();

      Thread.sleep(2000L);

      for(int i=1;i<5;i++)

      {

         driver.findElement(By.id("hrefIncAdt")).click();

      }

      driver.findElement(By.id("btnclosepaxoption")).click();

      Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");

      System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

// driver.findElement(By.cssSelector("#ctl00_mainContent_btn_FindFlights")).click();

      driver.findElement(By.cssSelector("input[value='Search']")).click();

// driver.findElement(By.xpath("//input[@value='Search']")).click();

// driver.findElement(By.name("ctl00$mainContent$btn_FindFlights")).click();

      checkbox(driver);


   }

   private static void checkbox(WebDriver driver) {
      driver.findElement(By.id("checkBoxOption1")).click();
      System.out.println(driver.findElement(By.id("checkBoxOption1")).isSelected()); //Should Print True
      driver.findElement(By.id("checkBoxOption1")).click();
      System.out.println(driver.findElement(By.id("checkBoxOption1")).isSelected()); //Should Print false
   }


}

