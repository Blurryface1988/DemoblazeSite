package Demoblaze;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Cart {

    public WebDriver  driver;

    public Cart (WebDriver driver){
        this.driver = driver;
    }

    public WebElement Cart_Button(){
        return driver.findElement(By.xpath("//*[@id=\"navbarExample\"]/ul/li[4]/a"));
    }

    public void ClickOnCart(){
        Cart_Button().click();
    }

    public WebElement Cart_Product(){
        return driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/tr/td[2]"));
    }

    public WebElement Cart_Price(){
        return driver.findElement(By.id("totalp"));
    }

    public void Product(){
        Cart_Product().isDisplayed();
    }


    public void clickPlaceOrder() { // PlaceOrder
        WebElement signUpLink = driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/button"));
        signUpLink.click();
    }

    public String getPlaceOrderText() {
        WebElement popupTextElement = driver.findElement(By.id("orderModalLabel"));
        return popupTextElement.getText();
    }

    public boolean isPlceOrderPopupDisplayed() {
        WebElement popupTextElement = driver.findElement(By.id("orderModalLabel"));
        return popupTextElement.isDisplayed();
    }

    public void enterNameOrder(String name) {
        WebElement nameField = driver.findElement(By.xpath("//*[@id=\"name\"]"));
        nameField.sendKeys(name);
    }
    public void enterCountryOrder(String country) {
        WebElement countryField = driver.findElement(By.xpath("//*[@id=\"country\"]"));
        countryField.sendKeys(country);
    }
    public void enterCityOrder(String city) {
        WebElement cityField = driver.findElement(By.xpath("//*[@id=\"city\"]"));
        cityField.sendKeys(city);
    }
    public void enterCreditCardOrder(String Credit_Card) {
        WebElement Credit_Card_Field = driver.findElement(By.xpath("//*[@id=\"card\"]"));
        Credit_Card_Field.sendKeys(Credit_Card);
    }
    public void enterMonthOrder(String Month) {
        WebElement MonthField = driver.findElement(By.xpath("//*[@id=\"month\"]"));
        MonthField.sendKeys(Month);
    }
    public void enterYearOrder(String Year) {
        WebElement YearField = driver.findElement(By.xpath("//*[@id=\"year\"]"));
        YearField.sendKeys(Year);
    }
    public void clickPurchase() { // PlaceOrder
        WebElement Purchase = driver.findElement(By.xpath("//*[@id=\"orderModal\"]/div/div/div[3]/button[2]"));
        Purchase.click();
    }

    public void clickOk() { // Ok
        WebElement Ok = driver.findElement(By.xpath("/html/body/div[10]/div[7]/div/button"));
        Ok.click();
    }





}
