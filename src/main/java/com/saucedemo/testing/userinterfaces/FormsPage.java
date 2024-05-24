package com.saucedemo.testing.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class FormsPage {
    public  static Target INPUT_FIRST_NAME = Target.the("Input first name").located(By.xpath("//input[@id='firstName']"));
    public  static  Target INPUT_LAST_NAME = Target.the("Input last name").located(By.xpath("//input[@id='lastName']"));
    public static final Target INPUT_EMAIL = Target.the("Input email").located(By.xpath("//input[@id='userEmail']"));
    public static final Target CHB_GENDER_FEMALE = Target.the("Check box female").located(By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[2]/label"));
    public static final Target INPUT_NUMBER = Target.the("Input number").located(By.xpath("//input[@id='userNumber']"));
    public static final Target INPUT_DATE_BIRTH = Target.the("Input date").located(By.xpath("//input[@id='dateOfBirthInput']"));
    public static final Target INPUT_SUBJECTS = Target.the("Input subjects").located(By.xpath("//div[@id='subjectsContainer']"));
    public static final Target CHB_HOBBIES_MUSIC = Target.the("Check box music").located(By.xpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div[3]/label"));
    public static final Target TXA_ADRESS = Target.the("Text area adress").located(By.xpath("//textarea[@id='currentAddress']"));
    public static final Target INPUT_STATE = Target.the("Input state").located(By.xpath("//*[@id=\"state\"]/div/div[1]/div[1]"));
    public static final Target INPUT_CITY = Target.the("Input city").located(By.xpath("//*[@id=\"city\"]/div/div[1]/div[1]"));
    public static final Target BTN_SUBMIT = Target.the("btn submmit").located(By.xpath("//button[@id='submit']"));
    public static final Target BTN_UPLOAD_IMAGE = Target.the("btn upload image").located(By.xpath("//input[@id='uploadPicture']"));
    public static final Target BTN_CLOSE = Target.the("btn close").located(By.xpath("//button[@id='closeLargeModal']"));









}
