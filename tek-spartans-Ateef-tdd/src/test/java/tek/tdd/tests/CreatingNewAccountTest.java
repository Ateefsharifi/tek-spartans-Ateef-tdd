package tek.tdd.tests;
import jdk.jfr.Name;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import tek.tdd.base.UIBaseClass;

import java.util.Random;

public class CreatingNewAccountTest extends UIBaseClass {

    @Test
    public void fillCreateNewAccount(){
        clickOnElement(homePage.signInLink);
        Assert.assertEquals(getElementText(By.xpath("//*/div[1]/div/h1")),"TEKSCHOOL");
        clickOnElement(createNewAccountpage.newAccountBtn);
        Assert.assertEquals(getElementText(By.xpath("//*[@id='signUpForm']/h1")),"Sign Up");
        fillCreateNewAccountForm();
        clickOnElement(createNewAccountpage.signupBtn);
    }


    public String generateRandomEmail(){
        String characters="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuilder randomString=new StringBuilder(10);
        for (int i=0; i<10; i++){
            int index=random.nextInt(characters.length());
            randomString.append(characters.charAt(index));
        }
        return randomString.toString()+ "@gmail.com";
    }
    private void fillCreateNewAccountForm(){
        sendText(createNewAccountpage.name,"Ahmad");
        sendText(createNewAccountpage.email,generateRandomEmail());
        sendText(createNewAccountpage.password,"Test@12345");
        sendText(createNewAccountpage.confirmPassword,"Test@12345");
    }

}

