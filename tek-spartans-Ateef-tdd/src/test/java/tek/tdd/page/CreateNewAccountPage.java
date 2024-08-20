package tek.tdd.page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek.tdd.utility.SeleniumUtility;

public class CreateNewAccountPage extends SeleniumUtility {
    public CreateNewAccountPage() {
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy(id = "newAccountBtn")
    public  WebElement newAccountBtn;

    @FindBy(name = "name")
    public  WebElement name;

    @FindBy(name="email")
    public WebElement email;

    @FindBy(name="password")
    public WebElement password;


    @FindBy(name = "confirmPassword")
    public  WebElement confirmPassword;

    @FindBy(id = "signupBtn")
    public  WebElement signupBtn;

}
