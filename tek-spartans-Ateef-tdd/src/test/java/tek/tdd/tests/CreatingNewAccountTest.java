package tek.tdd.tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import tek.tdd.base.UIBaseClass;
import tek.tdd.page.UpdatingUserProfile;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CreatingNewAccountTest extends UIBaseClass {

    @Test
    public void fillCreateNewAccount(){
        clickOnElement(homePage.signInLink);
        Assert.assertEquals(getElementText(By.xpath("//*/div[1]/div/h1")),
                getElementText(createNewAccountpage.login__title));
        clickOnElement(createNewAccountpage.newAccountBtn);
        Assert.assertEquals(getElementText(By.xpath("//*[@id='signUpForm']/h1")),
                getElementText(createNewAccountpage.signup__subtitle));
        sendText(createNewAccountpage.name,"Ahmad");
        sendText(createNewAccountpage.email,generateRandomEmail());
        sendText(createNewAccountpage.password,"Test@12345");
        sendText(createNewAccountpage.confirmPassword,"Test@12345");
        clickOnElement(createNewAccountpage.signupBtn);

    }
    @Test
    public void createAccountWithExistingEmail(){
        clickOnElement(homePage.signInLink);
        Assert.assertEquals(getElementText(By.xpath("//*/div[1]/div/h1")),
                getElementText(createNewAccountpage.login__title));
        clickOnElement(createNewAccountpage.newAccountBtn);
        Assert.assertEquals(getElementText(By.xpath("//*[@id='signUpForm']/h1")),
                getElementText(createNewAccountpage.signup__subtitle));
        sendText(createNewAccountpage.name,"Ahmad");
        sendText(createNewAccountpage.email,"Example@gmail.com");
        sendText(createNewAccountpage.password,"Test@12345");
        sendText(createNewAccountpage.confirmPassword,"Test@12345");
        clickOnElement(createNewAccountpage.signupBtn);
        String ActualError=getElementText(By.xpath("//*[@id='signUpForm']/div[6]"));
        Assert.assertEquals(ActualError,"this email is already exist, please use another email address");


    }
    @Test
    public void updateNameAndPhoneNumber() {
        clickOnElement(homePage.signInLink);
        Assert.assertEquals(getElementText(By.xpath("//*/div[1]/div/h1")),
                getElementText(createNewAccountpage.login__title));
        sendText(signInPage.emailInput,"Example@gmail.com");
        sendText(signInPage.passwordInput,"Test@12345" );
        clickOnElement(signInPage.loginButton);
        Assert.assertEquals(getElementText(homePage.accountLink),"Account");
        clickOnElement(homePage.accountLink);
        updatingUserProfile.replaceEmailAndPhoneNumber("Ahmad","7038557896");
        Assert.assertEquals(getElementText(updatingUserProfile.Toastify__toast),"Toastify__toast");



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

}

