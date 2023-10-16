package Demoblaze;
import com.sun.org.glassfish.gmbal.Description;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;


public class Testing_Class {

    WebDriver driver;


    @BeforeClass
    public void Start_Session() throws InterruptedException
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/");
    }



    @Test
    @Description("Phones category filter Button test")
    public void Test01_Button_Phones()
    {
        Home_Page buttonphones = new Home_Page(driver);
        buttonphones.ClickPhonesFilter();
        boolean sucssesphonebutton = buttonphones.Messagephone("Phones");
        if (sucssesphonebutton) {
            System.out.println("לחיצה על כפתור מכשירים סלולארים עברה בהצלחה!!! ");
        } else {
            System.out.println("לחיצה על כפתור מכשירים סלולארים נכשלה!!!");
        }
    }


    @Test
    @Description("Laptops category filter button test")
    public void Test02_Button_Laptops()
    {
        Home_Page buttonleptops = new Home_Page(driver);
        buttonleptops.ClickLaptopsFilter();
        boolean sucsseslaptopbutton = buttonleptops.Messagelaptops("Laptop");
        if (sucsseslaptopbutton) {
            System.out.println("לחיצה על כפתור מחשבים ניידים עברה בהצלחה!!! ");
        } else {
            System.out.println("לחיצה על כפתור מחשבים ניידים נכשלה!!!");
        }
    }


    @Test
    @Description("Monitors category filter button  test")
    public void Test03_Button_Monitors()
    {
        Home_Page buttonmonitors = new Home_Page(driver);
        buttonmonitors.ClickMonitorsFilter();
        boolean successsmonitorbutton = buttonmonitors.Messagemonitors("Monitors");
        if (successsmonitorbutton) {
            System.out.println("לחיצה על כפתור מסכים עברה בהצלחה!!! ");
        } else {
            System.out.println("לחיצה על כפתור מסכים נכשלה!!!");
        }

    }


    @Test
    @Description("Verify that only Phones products are displayed")
    public void Test04_Phones_Products_Filter()
    {
        Home_Page phonesPage = new Home_Page(driver);
        phonesPage.ClickPhonesFilter();

        boolean arePhonesDisplayed = phonesPage.ArePhoneProductsDisplayed(Arrays.asList("Samsung galaxy s6", "Nokia lumia 1520", "Nexus 6", "Samsung galaxy s7", "Iphone 6 32gb", "Sony xperia z5", "HTC One M9"));

        if (arePhonesDisplayed) {
            System.out.println("Only Phones products are displayed.");
        } else {
            System.out.println("There are non-Phones products displayed.");
        }
    }


    @Test
    @Description("Verify that only Laptops products are displayed")
    public void Test05_Laptop_Products_Filter()
    {
        Home_Page laptopsPage = new Home_Page(driver);
        laptopsPage.ClickLaptopsFilter();

        boolean areLaptopDisplayed = laptopsPage.AreLaptopProductsDisplayed(Arrays.asList("Sony vaio i7", "Sony vaio i5", "Dell i7 8gb", "MacBook air", "MacBook Pro", "2017 Dell 15.6 Inch", "MacBook Pro"));
        if (areLaptopDisplayed) {
            System.out.println("Only Laptops products are displayed.");
        } else {
            System.out.println("There are non-Laptops products displayed.");
        }
    }


    @Test
    @Description("Verify that only Laptops products are displayed")
    public void Test06_Monitor_Products_Filter()
    {
        Home_Page monitorspage = new Home_Page(driver);
        monitorspage.ClickMonitorsFilter();
        boolean areMonitorDisplayed = monitorspage.AreMonitorProductsDisplayed(Arrays.asList("Apple monitor 24", "ASUS Full HD"));
        if (areMonitorDisplayed) {
            System.out.println("Only Monitors products are displayed.");
        } else {
            System.out.println("There are non-Monitors products displayed.");
        }
    }


    @Test
    @Description("Home Button Link Test")
    public void Test07_Home_Button_Test()
    {
        Home_Page Home = new Home_Page(driver);
        Home.clickHomeLink();
        String actualURL = Home.gethomeURL();
        String expectedURL = "https://www.demoblaze.com/index.html";
        assertEquals(actualURL, expectedURL);
        System.out.println("The URL is : " + actualURL);
        driver.switchTo().window(driver.getWindowHandle());
    }

    @Test
    @Description("Contact Button Link Test")
    public void Test08_Contact_Link_Test() throws InterruptedException
    {
        Home_Page Contact = new Home_Page(driver);
        Contact.clickContactLink();
        Thread.sleep(1000);
        String popupText = Contact.getContactPopupText();
        System.out.println(popupText);
        String expectedPopupMessage = "New message";
        assertEquals(popupText, expectedPopupMessage);
        Boolean isPopupDisplayed = Contact.isContactPopupDisplayed();
        if (isPopupDisplayed) {
            System.out.println("Contact us Pop Link Are Correct");
        } else {
            System.out.println("Contact us Popup Not Correct");
        }
        driver.navigate().back();
    }


    @Test
    @Description("About Us Button Link Test")
    public void Test09_Aboutus_Link_Test() throws InterruptedException
    {
        Home_Page About_us = new Home_Page(driver);
        About_us.clickAboutUsLink();
        Thread.sleep(1000);
        String popupText = About_us.getAboutUsPopupText();
        System.out.println(popupText);
        String expectedPopupMessage = "About us";
        assertEquals(popupText, expectedPopupMessage);
        Boolean isPopupDisplayed = About_us.isAboutUsPopupDisplayed();
        if (isPopupDisplayed) {
            System.out.println("About us Pop Link Are Correct");
        } else {
            System.out.println("About us Popup Not Correct");
        }
        About_us.clickcloseaboutus();
    }


    @Test
    @Description("Cart Button Link Test")
    public void Test10_Cart_Link_Test() throws InterruptedException
    {
        Home_Page Cart = new Home_Page(driver);
        Cart.clickCartLink();
        Thread.sleep(1000);
        String actualURL = Cart.getCartURL();
        String expectedURL = "https://www.demoblaze.com/cart.html";
        assertEquals(actualURL, expectedURL);
        System.out.println("The URL is : " + actualURL);
        driver.navigate().back();
    }


    @Test
    @Description("Login Button Link Test")
    public void Test11_Login_Link_Test() throws InterruptedException
    {
        Home_Page loginPage = new Home_Page(driver);
        loginPage.clickLoginLink();
        Thread.sleep(1000);
        String popupText = loginPage.getLoginPopupText();
        System.out.println(popupText);
        String expectedPopupMessage = "Log in";
        assertEquals(popupText, expectedPopupMessage);
        Boolean isPopupDisplayed = loginPage.isLoginPopupDisplayed();
        if (isPopupDisplayed) {
            System.out.println("Log in Pop Link Are Correct");
        } else {
            System.out.println("Log in Popup Not Correct");
        }
        loginPage.clickcloselogin();
    }


    @Test
    @Description("Signup Button Link Test")
    public void Test12_Signup_Link_Test() throws InterruptedException
    {
        Home_Page Sign_up = new Home_Page(driver);
        Sign_up.clickSignUpLink();
        Thread.sleep(1000);
        String popupText = Sign_up.getSignUpPopupText();
        System.out.println(popupText);
        String expectedPopupMessage = "Sign up";
        assertEquals(popupText, expectedPopupMessage);
        Boolean isPopupDisplayed = Sign_up.isSignUpPopupDisplayed();
        if (isPopupDisplayed) {
            System.out.println("Sign up Pop Link Are Correct");
        } else {
            System.out.println("Sign up Popup Not Correct");
        }
        Sign_up.clickclosesignup();
    }


    @Test
    @Description("Contact Us Form Test")
    public void Test13_Contact_Form_Test() throws InterruptedException
    {
        Home_Page Contact = new Home_Page(driver);
        Home_Page contactUs = new Home_Page(driver);
        Contact.clickContactLink();
        Thread.sleep(1000);
        contactUs.enterContactEmail("israel@gmail.com");
        contactUs.enterContactName("Israel Israeli");
        contactUs.enterMessage("Hi, my name is Israel, I am attaching the necessary details to this form, please call me back at the phone number\n\n054-5555555\n\nThank you.");
        contactUs.clickSendMessageButton();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("Alert Text: " + alertText);
        assertEquals(alertText, "Thanks for the message!!");
        Boolean isalertDisplayed = alertText.equals("Thanks for the message!!");
        if (isalertDisplayed) {
            System.out.println("ההודעה נשלחה בהצלחה");
        } else {
            System.out.println("אופס, ההודעה לא נשלחה");
        }
        alert.accept();
    }



    @Test
    @Description("Adding products to shopping cart")
    public void Test14_Add_Products_To_Cart() throws InterruptedException
    {
        Home_Page addcart = new Home_Page(driver);
        Home_Page phonesPage = new Home_Page(driver);
        Cart cart = new Cart(driver);
        phonesPage.ClickPhonesFilter();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        addcart.ClickselectionProduct1();
        Thread.sleep(2500);
        addcart.Clickaddtocart();
        Thread.sleep(2500);
        Alert alert = driver.switchTo().alert();
        String popup = alert.getText();
        System.out.println(popup);
        Assert.assertEquals(popup, "Product added");
        ((Alert) alert).accept();
        cart.Cart_Button().click();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        String expectedProduct = "Samsung galaxy s6";
        Assert.assertEquals(cart.Cart_Product().getText(), expectedProduct);
        System.out.println("The Product Is : " + cart.Cart_Product().getText());
        String expectedPrice = "360";
        Assert.assertEquals(cart.Cart_Price().getText(), expectedPrice);
        System.out.println("The Price is : " + cart.Cart_Price().getText());

    }


    @Test
    @Description("Place Order Button")
    public void Test15_Place_order_button() throws InterruptedException
    {
        Cart cart = new Cart(driver);
        cart.Cart_Button().click();
        Cart PlaceOrder = new Cart(driver);
        PlaceOrder.clickPlaceOrder();
        Thread.sleep(1000);
        String popupText = PlaceOrder.getPlaceOrderText();
        System.out.println(popupText);
        String expectedPopupMessage = "Place order";
        assertEquals(popupText, expectedPopupMessage);
        Boolean isPopupDisplayed = PlaceOrder.isPlceOrderPopupDisplayed();
        if (isPopupDisplayed) {
            System.out.println("Place Order Popup Are Correct");
        } else {
            System.out.println("Place Order Popup Not Correct");
        }
        cart.enterNameOrder("Dmitri Feldman");
        cart.enterCountryOrder("Israel");
        cart.enterCityOrder("Petah Tikva");
        cart.enterCreditCardOrder("45801605248596325");
        cart.enterMonthOrder("06");
        cart.enterYearOrder("23");
        cart.clickPurchase();
        cart.clickOk();

    }

    @AfterClass
        public void Close_Session () throws InterruptedException {
            Thread.sleep(1500);
            driver.quit();

        }
    }




