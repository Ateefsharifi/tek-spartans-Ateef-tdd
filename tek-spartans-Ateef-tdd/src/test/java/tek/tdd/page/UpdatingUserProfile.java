package tek.tdd.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tek.tdd.utility.SeleniumUtility;

public class UpdatingUserProfile extends SeleniumUtility {

    @FindBy(name = "email")
    public WebElement email;

    @FindBy(name = "phoneNumber")
    public WebElement phoneNumber;

    @FindBy(name = "name")
    public WebElement name;

    @FindBy(id = "personalUpdateBtn")
    public WebElement personalUpdateBtn;


    @FindBy(className = "Toastify__toast")
    public WebElement Toastify__toast;



    public void replaceEmailAndPhoneNumber(String Name,String PhoneNumber){
        String ActualName=getElementText(name);
        String ActualPhoneNumber=getElementText(phoneNumber);
        name.clear();
        phoneNumber.clear();
        sendText(name,Name);
        sendText(phoneNumber,PhoneNumber);
        clickOnElement(personalUpdateBtn);

    }

}
