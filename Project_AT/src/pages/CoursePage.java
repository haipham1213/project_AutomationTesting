package pages;

import org.openqa.selenium.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;

public class CoursePage {
    WebDriver driver;

    // Locators cho TC1 (Tạo khóa học)
    By btnMenuCourse = By.xpath("//*[@id=\"app\"]/div/nav/div[1]/div[2]/a[3]");
    By btnAddNew = By.xpath("//*[@id=\"v-main-app\"]/div/div/div/div[1]/header/div/a/span");
    By btnUploadImg = By.xpath("//*[@id=\"formUpdateAddNewOrUpdate\"]/form/div/div[2]/div/div[2]/div[1]/div[1]/div/button");
    By txtTenKhoaHoc = By.xpath("/html/body/div/div/div/main/div/div/div/div/form/div/div[2]/div/div[2]/div[2]/div/div[1]/div[1]/input");
    By txtMoTaKhoaHoc = By.xpath("/html/body/div/div/div/main/div/div/div/div/form/div/div[2]/div/div[2]/div[3]/div/div[1]/div[1]/textarea");
    By btnSaveCourse = By.xpath("//*[@id=\"formUpdateAddNewOrUpdate\"]/form/header/div/button");
    By btnConfirmSave = By.xpath("/html/body/div[2]/div/div[6]/button[1]");

    // Locators cho TC4 (Cập nhật nội dung)
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
   
    
    // Locators cho TC2 (Xóa khóa học)
    By btnDeleteCourse = By.xpath("/html/body/div/div/div/main/div/div/div/div[1]/div[1]/table/tbody/tr[1]/td[5]/button/span/i");
    
    By btnConfirmDelete = By.xpath("//*[@id=\"app\"]/div[3]/div/div/div[3]/button[2]/span");
    By btnConfirmGo = By.xpath("/html/body/div[2]/div/div[6]/button[1]");
    By btnDeleteStudent = By.xpath("//*[@id=\"v-main-app\"]/div/div/div/div[2]/div/div/div/div[1]/div[1]/table/tbody/tr[1]/td[8]");
    By btnConfirmDeleteStudent = By.xpath("//*[@id=\"app\"]/div[3]/div/div/div[3]/button[2]");
    
    
    By linkCourse = By.linkText("Kỹ thuật phần mềm");
    By btnAddStudent = By.xpath("//*[@id=\"v-main-app\"]/div/div/div/div[2]/div/div/div/div[1]/header/div/button[1]");
    By txtEmailStudent = By.xpath("/html/body/div/div/div[3]/div/div/form/div[1]/div/div/div/div[1]/div/input");
    By btnSaveStudent = By.xpath("//*[@id=\"app\"]/div[3]/div/div/form/div[2]/button[2]/span");
    
    // TC5: Tìm kiếm khóa học
    By txtSearchCourse = By.xpath("/html/body/div/div/div/main/div/div/div/div[1]/header/div/div[3]/div/div/div[1]/input");
    
    
    
    // Các hàm lấy getText so sánh
    By txtQuanLyKhoaHoc = By.xpath("//*[@id=\"v-main-app\"]/div/div/div/div[1]/header/div/div[1]");
    By txtTieuDe = By.xpath("//*[@id=\"v-main-app\"]/div/div/div/div[1]/div[1]/table/thead/tr/th[2]/span");
    By txtMoTa = By.xpath("//*[@id=\"v-main-app\"]/div/div/div/div[1]/div[1]/table/thead/tr/th[3]/span");
    By txtNgayCapNhat = By.xpath("//*[@id=\"v-main-app\"]/div/div/div/div[1]/div[1]/table/thead/tr/th[4]/span");
    
 // --- Locators cho phần Nội dung (TC1_2) ---
    By clickNoiDung = By.xpath("//*[@id=\"v-main-app\"]/div/div/div/div[1]/div/div[2]/div/div[3]");
    By btnAddContent = By.xpath("//*[@id=\"v-main-app\"]/div/div/div/div[2]/div/div[2]/div/button[2]/span");
    
    // Chương 1
    By clickChuong1 = By.xpath("//*[@id=\"v-main-app\"]/div/div/div/div[2]/div/div[2]/div/div[1]");
    By txtTieuDeChuong1 = By.xpath("/html/body/div/div/div/main/div/div/div/div[2]/div/div[2]/div/div[1]/div/div/div/div[1]/div/div[1]/div[1]/input");
    By txtMoTaChuong1 = By.xpath("/html/body/div/div/div/main/div/div/div/div[2]/div/div[2]/div/div[1]/div/div/div/div[2]/div/div[1]/div/textarea");
    By btnAddBaiHoc1_C1 = By.xpath("//*[@id=\"v-main-app\"]/div/div/div/div[2]/div/div[2]/div/div[1]/div/div/div/button[2]/span");
    By clickBaiHoc1_C1 = By.xpath("//*[@id=\"v-main-app\"]/div/div/div/div[2]/div/div[2]/div/div[1]/div/div/div/div[3]/div/button/div[1]");
    By txtTieuDeBai1_C1 = By.xpath("/html/body/div/div/div/main/div/div/div/div[2]/div/div[2]/div/div[1]/div/div/div/div[3]/div/div/div/div[1]/div/div[1]/div[1]/input");
    By txtMoTaBai1_C1 = By.xpath("/html/body/div/div/div/main/div/div/div/div[2]/div/div[2]/div/div[1]/div/div/div/div[3]/div/div/div/div[2]/div/div[1]/div/textarea");
    
    // Chương 2
    By clickChuong2 = By.xpath("//*[@id=\"v-main-app\"]/div/div/div/div[2]/div/div[2]/div/div[1]/div[2]");
    By txtTieuDeChuong2 = By.xpath("/html/body/div/div/div/main/div/div/div/div[2]/div/div[2]/div/div[1]/div[2]/div/div/div[1]/div/div[1]/div[1]/input");
    By txtMoTaChuong2 = By.xpath("/html/body/div/div/div/main/div/div/div/div[2]/div/div[2]/div/div[1]/div[2]/div/div/div[2]/div/div[1]/div/textarea");
    
    // Chương 3
    By clickChuong3 = By.xpath("//*[@id=\"v-main-app\"]/div/div/div/div[2]/div/div[2]/div/div[1]/div[3]");
    By txtTieuDeChuong3 = By.xpath("/html/body/div/div/div/main/div/div/div/div[2]/div/div[2]/div/div[1]/div[3]/div/div/div[1]/div/div[1]/div[1]/input");
    By txtMoTaChuong3 = By.xpath("/html/body/div/div/div/main/div/div/div/div[2]/div/div[2]/div/div[1]/div[3]/div/div/div[2]/div/div[1]/div/textarea");
    By btnAddBaiHoc1_C3 = By.xpath("//*[@id=\"v-main-app\"]/div/div/div/div[2]/div/div[2]/div/div[1]/div[3]/div/div/button[2]/span");
    By clickBaiHoc1_C3 = By.xpath("//*[@id=\"v-main-app\"]/div/div/div/div[2]/div/div[2]/div/div[1]/div[3]/div/div/div[3]");
    By txtTieuDeBai1_C3 = By.xpath("/html/body/div/div/div/main/div/div/div/div[2]/div/div[2]/div/div[1]/div[3]/div/div/div[3]/div/div/div/div[1]/div/div[1]/div[1]/input");
    By txtMoTaBai1_C3 = By.xpath("/html/body/div/div/div/main/div/div/div/div[2]/div/div[2]/div/div[1]/div[3]/div/div/div[3]/div/div/div/div[2]/div/div[1]/div/textarea");
    By clickBaiHoc2_C3 = By.xpath("//*[@id=\"v-main-app\"]/div/div/div/div[2]/div/div[2]/div/div[1]/div[3]/div/div/div[3]/div[2]");
    By txtTieuDeBai2_C3 = By.xpath("/html/body/div/div/div/main/div/div/div/div[2]/div/div[2]/div/div[1]/div[3]/div/div/div[3]/div[2]/div/div/div[1]/div/div[1]/div[1]/input");
    By txtMoTaBai2_C3 = By.xpath("/html/body/div/div/div/main/div/div/div/div[2]/div/div[2]/div/div[1]/div[3]/div/div/div[3]/div[2]/div/div/div[2]/div/div[1]/div/textarea");
    // Nút Lưu cuối cùng
    By btnSaveContent = By.xpath("//*[@id=\"v-main-app\"]/div/div/div/div[2]/div/div[2]/div/button[3]");
    By btnConfirmSaveContent = By.xpath("/html/body/div[2]/div/div[6]/button[1]");
    
    
    
    
    
    // XPath chung cho toàn bộ các link tiêu đề trong bảng
    By listCourseLinks = By.xpath("//*[@id='v-main-app']//table/tbody/tr/td[2]/p/a");
    public List<String> getAllWebCourseTitles() {
        List<WebElement> elements = driver.findElements(listCourseLinks);
        List<String> titles = new ArrayList<>();
        for (WebElement element : elements) {
            titles.add(element.getText().trim());
        }
        return titles;
    }
    
    
    
    
    
  
    
    
    
    
    
    
    

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
    }
    public void clickSaveCourse() { driver.findElement(btnSaveCourse).click(); }

    public void clickConfirm() { driver.findElement(btnConfirmSave).click(); }

    
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
    
    
    
   
     public void deleteCourse() {
    	 driver.findElement(btnDeleteCourse).click();
    }
     public void btnConfirmDelete() {
		 driver.findElement(btnConfirmDelete).click();
	 }
     public void clickConfirmGo() {
    	 		 driver.findElement(btnConfirmGo).click();
     }
     public void deleteStudent() {
		 driver.findElement(btnDeleteStudent).click();
	 }
     public void btnConfirmDeleteStudent() {
		 driver.findElement(btnConfirmDeleteStudent).click();
	 }
	 
     
 	
  // Sửa tên hàm cho đúng chính tả: Student thay vì Sutdent
     public void clickAddStudent() {
         driver.findElement(btnAddStudent).click();
     }

     public void txtEmailStudent(String email) {
         WebElement element = driver.findElement(txtEmailStudent);
         element.clear(); // Xóa trắng ô nhập trước khi điền email mới
         element.sendKeys(email);
     }

     public void linkCourse() {
         driver.findElement(linkCourse).click();
     }

     public void btnSaveStudent() {
         driver.findElement(btnSaveStudent).click();
     }
	 

	 // Các hàm cho TC5 tìm kiếm khóa học
	 public void txtSearchCourse(String courseName)  {
		 driver.findElement(txtSearchCourse).sendKeys(courseName);
	 }
	 
	// Thêm .trim() vào cuối mỗi hàm lấy text
	 public String getQuanLyKhoaHocText() {
	     return driver.findElement(txtQuanLyKhoaHoc).getText().trim(); 
	 }

	 public String getTieuDeText() {
	     return driver.findElement(txtTieuDe).getText().trim(); 
	 }

	 public String getMoTaText() {
	     return driver.findElement(txtMoTa).getText().trim(); 
	 }
	 public String getNgayCapNhatText() {
		 return driver.findElement(txtNgayCapNhat).getText(); 
	 }
	 
	 

	// --- Các phương thức hành động ---
	    public void goToContentTab() { driver.findElement(tabNoiDung).click(); }
	    public void clickAddNewContent() { driver.findElement(btnAddContent).click(); }
	    
	    public void fillChapter1(String title, String desc) {
	        driver.findElement(clickChuong1).click();
	        driver.findElement(txtTieuDeChuong1).sendKeys(title);
	        driver.findElement(txtMoTaChuong1).sendKeys(desc);
	    }

	    public void addLessonToChapter1(String title, String desc) {
	        driver.findElement(btnAddBaiHoc1_C1).click();
	        driver.findElement(clickBaiHoc1_C1).click();
	        driver.findElement(txtTieuDeBai1_C1).sendKeys(title);
	        driver.findElement(txtMoTaBai1_C1).sendKeys(desc);
	    }

	    public void fillChapter2(String title, String desc) {
	        driver.findElement(clickChuong2).click();
	        driver.findElement(txtTieuDeChuong2).sendKeys(title);
	        driver.findElement(txtMoTaChuong2).sendKeys(desc);
	    }

	    public void fillChapter3(String title,String desc) {
	        driver.findElement(clickChuong3).click();
	        driver.findElement(txtTieuDeChuong3).sendKeys(title);
	        driver.findElement(txtMoTaChuong3).sendKeys(desc);
	    }

	    public void addLesson1ToChapter3(String title, String desc) {
	        driver.findElement(btnAddBaiHoc1_C3).click();
	        driver.findElement(clickBaiHoc1_C3).click();
	        driver.findElement(txtTieuDeBai1_C3).sendKeys(title);
	        driver.findElement(txtMoTaBai1_C3).sendKeys(desc);
	    }

	    public void addLesson2ToChapter3(String title, String desc) {
	    	driver.findElement(btnAddBaiHoc1_C3).click();
	        driver.findElement(clickBaiHoc2_C3).click();
	        driver.findElement(txtTieuDeBai2_C3).sendKeys(title);
	        driver.findElement(txtMoTaBai2_C3).sendKeys(desc);
	    }

	    public void saveAndConfirm() {
	        driver.findElement(btnSaveContent).click();
	    }
	    
	    public void clickConfirmDialog() {
	        driver.findElement(btnConfirmSave).click();
	    }
	
	 
	 
     
     

	
    	 
    
    
}