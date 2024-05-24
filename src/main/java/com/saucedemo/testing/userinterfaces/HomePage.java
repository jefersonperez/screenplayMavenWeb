package com.saucedemo.testing.userinterfaces;


import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;

import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;
import java.util.Random;




public class HomePage {


    public static final Target CHILD_IFRAME = Target.the("Child Iframe").locatedBy("//iframe[@id='frame1']");  // Actualizado para apuntar al iframe correcto



    public  static  Target LBL_FORMS = Target.the("Btn forms").located(By.xpath("//div[@class='header-text' and contains(text(),'Forms')]"));
    public  static  Target LBL_PRACTICE_FORM = Target.the("Btn practice forms").located(By.xpath("//span[contains(text(),'Practice Form')]"));
    public static final Target BTN_SEARCH = Target.the("INPUT SEARCH").located(By.id("searchBox"));
    public  static  Target LBL_FRAMES_ALERTS_WINDOWS = Target.the("Btn alerts frames windows").located(By.xpath("//div[@class='header-text' and contains(text(),'Alerts, Frame & Windows')]"));
    public  static  Target LBL_NESTED_FRAMES = Target.the("Btn nested frames").located(By.xpath("//span[contains(text(),'Nested Frames')]"));
    public  static  Target LBL_CHILD_IFRAME = Target.the("LBL child iframe").located(By.xpath("//p[contains(text(),'Child Iframe')]"));
    public  static  Target LBL_PARENT_IFRAME = Target.the("LBL parent iframe").located(By.xpath("//body[normalize-space()='Parent frame']"));
    public  static  Target BOOK_LIST = Target.the("Book List").located(By.className("mr-2"));
    public  static  Target BOOK_STORE = Target.the("Book Store").located(By.xpath("(//span[contains(text(),'Book Store')])[1]"));
    public static final Target BTN_ADD = Target.the("INPUT ADD").located(By.id("addNewRecordButton"));
    public  static final Target BNT_OK = Target.the("BTN OK").located(By.id("Aceptar"));
    public static final Target BTN_PROFILE = Target.the("BTN PROFILE").located(By.xpath("//span[contains(text(),'Profile')]"));
    public static final Target BTN_DELETE = Target.the("BTN DELETE").located(By.id("delete-record-undefined"));
    public static final Target BTN_DELETE_OK = Target.the("BTN DELETE OK").located(By.id("closeSmallModal-ok"));
    public static final Target TXT_SHARE_BOOK = Target.the("TXT SHARE BOOK").located(By.xpath("//input[@id='searchBox']"));
    public static final Target LBL_BOOK_PROGRAMMING_JAVA = Target.the("Lbl Programming java").located(By.xpath("//a[contains(text(),'Programming JavaScript Applications')]"));



    public static void selectRandomBookAndSaveName (Actor actor){

        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userName-value")));



        List<WebElementFacade> bookElements = BOOK_LIST.resolveAllFor(actor);
        if(!bookElements.isEmpty()){
            int randomIndex = new Random().nextInt(bookElements.size());
            WebElementFacade selectedBook = bookElements.get(randomIndex);
            String bookname = selectedBook.getText();
            actor.remember("selected book name", bookname);
            selectedBook.click();
        }
    }
    }





