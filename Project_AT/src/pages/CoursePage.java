package pages;

import org.openqa.selenium.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class CoursePage {
    WebDriver driver;

    // Locators cho TC2 (Tạo khóa học)
    By btnMenuCourse = By.xpath("//*[@id=\"app\"]/div/nav/div[1]/div[2]/a[3]");
    By btnAddNew = By.xpath("//*[@id=\"v-main-app\"]/div/div/div/div[1]/header/div/a/span");
    By btnUploadImg = By.xpath("//*[@id=\"formUpdateAddNewOrUpdate\"]/form/div/div[2]/div/div[2]/div[1]/div[1]/div/button");
    By txtTenKhoaHoc = By.xpath("/html/body/div/div/div/main/div/div/div/div/form/div/div[2]/div/div[2]/div[2]/div/div[1]/div[1]/input");
    By txtMoTaKhoaHoc = By.xpath("/html/body/div/div/div/main/div/div/div/div/form/div/div[2]/div/div[2]/div[3]/div/div[1]/div[1]/textarea");
    By btnSaveCourse = By.xpath("//*[@id=\"formUpdateAddNewOrUpdate\"]/form/header/div/button/span/span");
    By btnConfirmSave = By.xpath("/html/body/div[2]/div/div[6]/button[1]");

    // Locators cho TC1 (Cập nhật nội dung)
    By linkDatabaseCourse = By.linkText("Database_nhom3");
    By tabNoiDung = By.xpath("//*[@id=\"v-main-app\"]/div/div/div/div[1]/div/div[2]/div/div[3]");
    By btnSuaNoiDung = By.xpath("//*[@id=\"v-main-app\"]/div/div/div/div[2]/div/div[2]/div/div[1]/div/button");
    By txtTieuDeChuong = By.xpath("/html/body/div/div/div/main/div/div/div/div[2]/div/div[2]/div/div[1]/div/div/div/div[1]/div/div[1]/div[1]/input");
    By txtMoTaChuong = By.xpath("/html/body/div/div/div/main/div/div/div/div[2]/div/div[2]/div/div[1]/div/div/div/div[2]/div/div[1]/div/textarea");
    By btnBaiHoc = By.xpath("//*[@id=\"v-main-app\"]/div/div/div/div[2]/div/div[2]/div/div[1]/div/div/div/div[3]/div/button/div[1]");
    By txtTieuDeBai = By.xpath("/html/body/div/div/div/main/div/div/div/div[2]/div/div[2]/div/div[1]/div/div/div/div[3]/div/div/div/div[1]/div/div[1]/div[1]/input");
    By txtMoTaBai = By.xpath("/html/body/div/div/div/main/div/div/div/div[2]/div/div[2]/div/div[1]/div/div/div/div[3]/div/div/div/div[2]/div/div[1]/div/textarea");
    By btnLuuCapNhat = By.xpath("//*[@id=\"v-main-app\"]/div/div/div/div[2]/div/div[2]/div/button[3]/span");
    By btnConfirmUpdate = By.xpath("/html/body/div[2]/div/div[6]");

    public CoursePage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToCourseMenu() { driver.findElement(btnMenuCourse).click(); }
    public void clickAddNew() { driver.findElement(btnAddNew).click(); }
    
    public void uploadImage(String path) throws AWTException, InterruptedException {
        driver.findElement(btnUploadImg).click();
        Thread.sleep(3000);
        driver.switchTo().activeElement();
        StringSelection select = new StringSelection(path);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(select, null);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    public void fillNewCourse(String ten, String mota) {
        driver.findElement(txtTenKhoaHoc).sendKeys(ten);
        driver.findElement(txtMoTaKhoaHoc).sendKeys(mota);
        driver.findElement(btnSaveCourse).click();
    }

    public void clickConfirm() { driver.findElement(btnConfirmSave).click(); }

    // Các hàm cho TC1
    public void selectDatabaseCourse() { driver.findElement(linkDatabaseCourse).click(); }
    public void openNoiDungTab() { driver.findElement(tabNoiDung).click(); }
    public void clickSuaNoiDung() { driver.findElement(btnSuaNoiDung).click(); }
    
    public void updateContent(String tdc, String mtc, String tdb, String mtb) throws InterruptedException {
        WebElement input = driver.findElement(txtTieuDeChuong);
        input.click();
        input.sendKeys(Keys.CONTROL + "a");
        input.sendKeys(Keys.DELETE);
        input.sendKeys(tdc);
        
        WebElement input1 = driver.findElement(txtMoTaChuong);
        input1.click();
        input1.sendKeys(Keys.CONTROL + "a");
        input1.sendKeys(Keys.DELETE);
        input1.sendKeys(mtc);
        
        driver.findElement(btnBaiHoc).click();
        
        WebElement input2 = driver.findElement(txtTieuDeBai);
        input2.click();
        input2.sendKeys(Keys.CONTROL + "a");
        input2.sendKeys(Keys.DELETE);
        input2.sendKeys(tdb);
        
        WebElement input3 = driver.findElement(txtMoTaBai);
        input3.click();
        input3.sendKeys(Keys.CONTROL + "a");
        input3.sendKeys(Keys.DELETE);
        input3.sendKeys(mtb);
        
        driver.findElement(btnLuuCapNhat).click();
        Thread.sleep(2000);
        driver.findElement(btnConfirmUpdate).click();
    }
}