package Demoblaze;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class Home_Page {
    public WebDriver driver;



    ///// Bunners Links /////

    public Home_Page(WebDriver driver) {
        this.driver = driver;
    }

    public void clickHomeLink() { // Home
        WebElement HomeLink = driver.findElement(By.xpath("/html/body/nav/div[1]/ul/li[1]/a"));
        HomeLink.click();
    }

    public String gethomeURL(){
        return driver.getCurrentUrl();
    }

    public void clickContactLink() { // Contact
        WebElement contactLink = driver.findElement(By.linkText("Contact"));
        contactLink.click();
    }

    public String getContactPopupText() {
        WebElement popupTextElement = driver.findElement(By.id("exampleModalLabel"));
        return popupTextElement.getText();
    }

    public boolean isContactPopupDisplayed() {
        WebElement popupTextElement = driver.findElement(By.id("exampleModalLabel"));
        return popupTextElement.isDisplayed();
    }


    public void clickAboutUsLink() {   // About us
        WebElement aboutUsLink = driver.findElement(By.linkText("About us"));
        aboutUsLink.click();
    }

    public String getAboutUsPopupText() {
        WebElement popupTextElement = driver.findElement(By.id("videoModalLabel"));
        return popupTextElement.getText();
    }

    public boolean isAboutUsPopupDisplayed() {
        WebElement popupTextElement = driver.findElement(By.id("videoModalLabel"));
        return popupTextElement.isDisplayed();
    }
    public void clickcloseaboutus() { // Cart
        WebElement aboutusclosebutton = driver.findElement(By.xpath("//*[@id=\"videoModal\"]/div/div/div[3]/button"));
        aboutusclosebutton.click();
    }

    public void clickCartLink() { // Cart
        WebElement CartLink = driver.findElement(By.xpath("/html/body/nav/div[1]/ul/li[4]/a"));
        CartLink.click();
    }

    public String getCartURL(){
        return driver.getCurrentUrl();
    }



    public void clickLoginLink() { /// login
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();
    }

    public String getLoginPopupText() {
        WebElement popupTextElement = driver.findElement(By.id("logInModalLabel"));
        return popupTextElement.getText();
    }

    public boolean isLoginPopupDisplayed() {
        WebElement popupTextElement = driver.findElement(By.id("logInModalLabel"));
        return popupTextElement.isDisplayed();
    }
    public void clickcloselogin() { // Cart
        WebElement loginclosebutton = driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[1]"));
        loginclosebutton.click();
    }



    public void clickSignUpLink() { // sing up
        WebElement signUpLink = driver.findElement(By.linkText("Sign up"));
        signUpLink.click();
    }

    public String getSignUpPopupText() {
        WebElement popupTextElement = driver.findElement(By.id("signInModalLabel"));
        return popupTextElement.getText();
    }

    public boolean isSignUpPopupDisplayed() {
        WebElement popupTextElement = driver.findElement(By.id("signInModalLabel"));
        return popupTextElement.isDisplayed();
    }
    public void clickclosesignup() { // Cart
        WebElement signupclosebutton = driver.findElement(By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[1]"));
        signupclosebutton.click();
    }


    public void enterContactEmail(String email) {
        WebElement emailField = driver.findElement(By.id("recipient-email"));
        emailField.sendKeys(email);
    }

    public void enterContactName(String name) {
        WebElement nameField = driver.findElement(By.id("recipient-name"));
        nameField.sendKeys(name);
    }

    public void enterMessage(String message) {
        WebElement messageField = driver.findElement(By.id("message-text"));
        messageField.sendKeys(message);
    }

    public void clickSendMessageButton() {
        WebElement sendMessageButton = driver.findElement(By.xpath("//button[contains(text(),'Send message')]"));
        sendMessageButton.click();
    }
    public void clickCloseButton() {
        WebElement CloseMessageButton = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/button[1]"));
        CloseMessageButton.click();
    }





    ///// Phones /////

    public WebElement Phones_Button(){
        return driver.findElement(By.xpath("(/html/body/div[5]/div/div[1]/div/a[2])")); // מציאת כפתור מכשירי סלולר
    }
    public void ClickPhonesFilter(){
        Phones_Button().click(); // פעולת הלחיצה על הקטגוריה
    }
    public boolean Messagephone (String phonebuttonname){
        WebElement sucssesmessagephone = Phones_Button();
        return sucssesmessagephone.isDisplayed();

    }

    public boolean ArePhoneProductsDisplayed(List<String> ExpectedPhoneProducts) {
        WebElement phoneFilter = driver.findElement(By.xpath("(/html/body/div[5]/div/div[1]/div/a[2])"));
        phoneFilter.click();

        List<WebElement> phoneProducts = driver.findElements(By.xpath("//table[@class='table table-bordered']//tbody//tr"));
        List<String> actualPhoneProducts = Arrays.asList("Samsung galaxy s6", "Nokia lumia 1520", "Nexus 6", "Samsung galaxy s7", "Iphone 6 32gb", "Sony xperia z5", "HTC One M9");

        for (WebElement product : phoneProducts) {
            actualPhoneProducts.add(product.getText());
        }

        return actualPhoneProducts.containsAll(ExpectedPhoneProducts);
    }


    ///// Laptops /////

    public WebElement Laptops_Button(){
        return driver.findElement(By.xpath("(/html/body/div[5]/div/div[1]/div/a[3])")); // מציאת כפתור לפטופים
    }

    public void ClickLaptopsFilter(){
        Laptops_Button().click(); // פעולת הלחיצה על הקטגוריה
    }

    public boolean Messagelaptops (String laptopbuttonname){
        WebElement sucssesmessagelaptop = Laptops_Button();
        return sucssesmessagelaptop.isDisplayed();


    }

    public boolean AreLaptopProductsDisplayed(List<String> ExpectedLaptopProducts) {
        WebElement laptopFilter = driver.findElement(By.xpath("(/html/body/div[5]/div/div[1]/div/a[3])"));
        laptopFilter.click();

        List<WebElement> latopProducts = driver.findElements(By.xpath("//table[@class='table table-bordered']//tbody//tr"));
        List<String> actualaptopProducts = Arrays.asList("Sony vaio i7", "Sony vaio i5", "Dell i7 8gb", "MacBook air", "MacBook Pro", "2017 Dell 15.6 Inch", "MacBook Pro");

        for (WebElement product : latopProducts) {
            actualaptopProducts.add(product.getText());
        }

        return actualaptopProducts.containsAll(ExpectedLaptopProducts);
    }

    ///// Monitors /////

    public WebElement Monitors_Button() {
        return driver.findElement(By.xpath("(/html/body/div[5]/div/div[1]/div/a[4])")); // מציאת כפתור מסכים
    }

    public void ClickMonitorsFilter() {
        Monitors_Button().click(); // פעולת הלחיצה על הקטגוריה
    }

    public boolean Messagemonitors(String laptopbuttonname) {
        WebElement sucssesmessagemonitors = Monitors_Button();
        return sucssesmessagemonitors.isDisplayed();
    }

    public boolean AreMonitorProductsDisplayed(List<String> ExpectedLaptopProducts) {
        WebElement monitorFilter = driver.findElement(By.xpath("(/html/body/div[5]/div/div[1]/div/a[4])"));
        monitorFilter.click();

        List<WebElement> monitorProducts = driver.findElements(By.xpath("//table[@class='table table-bordered']//tbody//tr"));
        List<String> actualmonitorProducts = Arrays.asList("Apple monitor 24", "ASUS Full HD");

        for (WebElement product : monitorProducts) {
            actualmonitorProducts.add(product.getText());
        }

        return actualmonitorProducts.containsAll(ExpectedLaptopProducts);
    }






    //// Products /////

    public WebElement findProductElement1() {
        return driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[1]/div/div/h4/a"));
    }
    public void ClickselectionProduct1() {
        findProductElement1().click();
    }

    public WebElement findProductElement2() {
        return   driver.findElement(By.xpath("//a[contains(text(),'Iphone 6 32gb')]"));
    }
    public void ClickselectionProduct2() {
        findProductElement2().click();
    }


    public WebElement findAddToCartButton() {
        return   driver.findElement(By.linkText("Add to cart"));
    }
    public void Clickaddtocart(){
        findAddToCartButton().click();
    }



}


