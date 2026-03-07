package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LearningPage {
    WebDriver driver;

    public LearningPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectCourse() {
        driver.findElement(By.linkText("Lập trình Web cơ bản")).click();
    }

    // Các hàm tương tác cho TC1, TC2, TC3, TC4
    public void clickChapter(int i) {
        driver.findElement(By.xpath("//*[@id=\"v-main-app\"]/div/div/div[3]/div/div[1]/div/div[1]/div[" + i + "]")).click();
    }

    public void clickLesson(int chapterIdx, int lessonIdx) {
        String xpath = "//*[@id=\"v-main-app\"]/div/div/div[3]/div/div[1]/div/div[1]/div[" + chapterIdx + "]/div/div/div/div[" + lessonIdx + "]";
        driver.findElement(By.xpath(xpath)).click();
    }

    public String getChapterTitle(int i) {
        return driver.findElement(By.xpath("//*[@id=\"v-main-app\"]/div/div/div[3]/div/div/div/div[1]/div[" + i + "]/button/div[1]")).getText();
    }

    public String getChapterDescription(int i) {
        return driver.findElement(By.xpath("//*[@id=\"v-main-app\"]/div/div/div[3]/div/div/div/div[1]/div[" + i + "]/div/div/p")).getText();
    }

    public String getLessonTitle(int chapterIdx, int lessonIdx) {
        return driver.findElement(By.xpath("//*[@id=\"v-main-app\"]/div/div/div[3]/div/div/div/div[1]/div[" + chapterIdx + "]/div/div/div/div[" + lessonIdx + "]/button/div[1]")).getText();
    }
    
    public String getLessonDescription(int chapterIdx, int lessonIdx) {
        return driver.findElement(By.xpath("//*[@id=\"v-main-app\"]/div/div/div[3]/div/div/div/div[1]/div[" + chapterIdx + "]/div/div/div/div[" + lessonIdx + "]/div/div/p")).getText();
    }

    // Navigation cho TC5
    public void clickNavMenu() {
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/nav/div[1]/div[2]/a")).click();
    }

    public void clickSubMenu() {
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/nav/div[1]/div[2]/div[1]/div[2]/a[1]/div")).click();
    }
    
    public void closeVideoIcon(int chapter, int lesson) {
        driver.findElement(By.xpath("//*[@id=\"v-main-app\"]/div/div/div[3]/div/div/div/div[1]/div["+chapter+"]/div/div/div/div["+lesson+"]/div/div/div/div/div/div[3]/button/span/i")).click();
    }
}