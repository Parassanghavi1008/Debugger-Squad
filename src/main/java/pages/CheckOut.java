package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOut extends  BasePage{

    public CheckOut(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[text()=\"Place Order\"]")
    WebElement place;

    @FindBy(xpath = "//input[@id=\"name\"]")
    WebElement name;

    @FindBy(xpath = "//input[@id=\"country\"]")
    WebElement country;

    @FindBy(xpath = "//input[@id=\"city\"]")
    WebElement city;

    @FindBy(xpath = "//input[@id=\"card\"]")
    WebElement card;

    @FindBy(xpath = "//input[@id=\"month\"]")
    WebElement month;

    @FindBy(xpath = "//input[@id=\"year\"]")
    WebElement year;

    @FindBy(xpath = "//button[text()=\"Purchase\"]")
    WebElement purchase;

    @FindBy(xpath = "(//div[@tabindex=\"-1\"])[11]")
    WebElement msg;

    @FindBy(xpath = "//button[text()=\"OK\"]")
    WebElement ok;

    public void Place(){
        click(place);
    }

    public void Name(String uname){
        name.sendKeys(uname);
    }

    public void Country(String count){
        country.sendKeys(count);
    }

    public void City(String ncity){
        city.sendKeys(ncity);
    }

    public  void Card(String num){
        card.sendKeys(num);
    }

    public void Month(String mon){
        month.sendKeys(mon);
    }

    public void Year(String nyear){
        year.sendKeys(nyear);
    }

    public void buy(){
        click(purchase);
    }

    public boolean Msg(){
       return msg.isDisplayed();
    }

    public void Ok(){
        click(ok);
    }

}
