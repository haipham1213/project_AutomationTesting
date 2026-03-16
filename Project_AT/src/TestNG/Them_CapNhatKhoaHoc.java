package TestNG;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.CoursePage;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import org.testng.asserts.SoftAssert;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;



public class Them_CapNhatKhoaHoc {
    WebDriver driver;
    LoginPage loginPage;
    CoursePage coursePage;

    @BeforeTest
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "D:\\Project_AT\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://elearning.plt.pro.vn/trang-chu");
        driver.manage().window().maximize();
        
        loginPage = new LoginPage(driver);
        coursePage = new CoursePage(driver);
    }
    // TC1: Tạo khóa học mới 
    @Test(priority = 1)
    public void TC1() throws Exception {
        loginPage.login("test.pltsolutions@gmail.com", "plt@intern_051224");
        Thread.sleep(2000);
        coursePage.goToCourseMenu();
        Thread.sleep(2000);

        // 1. Khai báo đường dẫn đến thư mục chứa ảnh 
        String imageFolder = "C:\\Users\\hh\\git\\repository\\Project_AT\\Json_img\\";
        JSONParser jsonparser = new JSONParser();
        JSONArray listChuong = (JSONArray) jsonparser.parse(new FileReader(imageFolder + "taokhoahoc.json"));
        
        
        for (int i = 0; i < listChuong.size(); i++) {
            System.out.println("Đang tạo khóa học thứ: " + (i + 1));
            JSONObject data = (JSONObject) listChuong.get(i);
            
            // 2. Lấy tên hình ảnh từ JSON và kết hợp với folderPath
            String fileName = (String) data.get("hinh_anh");
            String fullPath = imageFolder + fileName; 

            // 3. Thực hiện các bước tạo khóa học
            coursePage.clickAddNew(); // Nhấn nút thêm mới cho mỗi khóa học
            Thread.sleep(2000);
            
            coursePage.uploadImage(fullPath); // Truyền đường dẫn ảnh động vào đây
            Thread.sleep(2000);

            coursePage.fillNewCourse(
                (String) data.get("ten_khoahoc"), 
                (String) data.get("mota_khoahoc")
            );
            
            coursePage.clickSaveCourse(); // Hoặc nút "Lưu" cuối cùng của form khóa học
            Thread.sleep(1000);
            coursePage.clickConfirm();
            Thread.sleep(1000);
            coursePage.goToCourseMenu();
            Thread.sleep(1000);
            
            
        }
    }
    
    @Test(priority = 2)
    public void TC1_1() throws Exception {
        // 1. Quản lý đường dẫn
        String projectPath = "C:\\Users\\hh\\git\\repository\\Project_AT\\Json_img\\";
        JSONParser jsonparser = new JSONParser();
        
        // 2. Đọc file JSON (Đảm bảo key trong file là "sinhvien")
        JSONArray listStudent = (JSONArray) jsonparser.parse(new FileReader(projectPath + "themsinhvien.json"));

        // 3. Vào khóa học
        coursePage.linkCourse();
        Thread.sleep(2000);

        
        for (int i = 0; i < listStudent.size(); i++) {
            JSONObject data = (JSONObject) listStudent.get(i);
            
            // Lấy đúng key "sinhvien" từ file JSON của bạn
            String email = (String) data.get("sinhvien"); 
            
            System.out.println("Đang thêm học viên: " + email);

            coursePage.clickAddStudent(); // Đã sửa chính tả
            Thread.sleep(1500);
            
            coursePage.txtEmailStudent(email);
            Thread.sleep(1000);
            
            coursePage.btnSaveStudent();
            Thread.sleep(1500);
            
            // Nhấn xác nhận (OK) sau khi lưu thành công
            coursePage.clickConfirm();
            Thread.sleep(1000); 
        }
    }
    
    @Test(priority = 3)
    public void TC1_2() throws Exception {
        
        // 1. Vào tab Nội dung
        coursePage.goToContentTab();
        Thread.sleep(2000);
        coursePage.clickAddNewContent();
        Thread.sleep(2000);
        
        // 2. Thao tác Chương 1
        coursePage.fillChapter1("Chương 1: Tổng quan E-Learning", "Giới thiệu về hệ thống.");
        Thread.sleep(1000);
        coursePage.addLessonToChapter1("Bài 1: Đăng nhập", "Hướng dẫn truy cập.");
        Thread.sleep(1000);
        
        // 3. Thao tác Chương 2
        coursePage.clickAddNewContent();
        coursePage.fillChapter2("Chương 2: Quản lý học tập", "Chi tiết các tính năng.");
        Thread.sleep(1000);
        
        // 4. Thao tác Chương 3 (2 bài học)
        coursePage.clickAddNewContent();
        coursePage.fillChapter3("Chương 3: Kiểm tra & Đánh giá", "Hướng dẫn làm bài kiểm tra.");
        Thread.sleep(1000);
      
        coursePage.addLesson1ToChapter3("Bài 1: Làm bài trắc nghiệm", "Quy tắc làm bài.");
        Thread.sleep(1000);
        coursePage.addLesson2ToChapter3("Bài 2: Xem kết quả", "Cách tra cứu điểm số.");
        Thread.sleep(2000);
        
        // 5. Lưu toàn bộ
        coursePage.saveAndConfirm();
        Thread.sleep(2000);
        coursePage.clickConfirmDialog();
        Thread.sleep(1000);
        
    }
    
    
    
    
    
    // TC3: Tìm kiếm khóa học
    @Test(priority = 5)
    public void TC3() throws Exception {
    	Thread.sleep(1000);
    	coursePage.txtSearchCourse("Database_nhom3");
    	Thread.sleep(3000);
    }
    
    // TC4: Cập nhật nội dung khóa học
    @Test(priority = 6)
    public void TC4() throws Exception {
        coursePage.selectDatabaseCourse();
        Thread.sleep(1000);
        coursePage.openNoiDungTab();
        Thread.sleep(1000);
        coursePage.clickSuaNoiDung();
        Thread.sleep(1000);

        JSONParser jsonparser = new JSONParser();
        JSONArray listChuong = (JSONArray) jsonparser.parse(new FileReader("C:\\Users\\hh\\git\\repository\\Project_AT\\Json_img\\thembaihoc.json"));
        for (int i = 0; i < listChuong.size(); i++) {
            JSONObject data = (JSONObject) listChuong.get(i);
            coursePage.updateContent(
                (String) data.get("tieude_chuong"),
                (String) data.get("mota_chuong"),
                (String) data.get("tieude_bai"),
                (String) data.get("mota_bai")
            );
            Thread.sleep(1000);
        }
    }
    
    @Test(priority = 4)
    public void TC2() throws Exception {
        coursePage.goToCourseMenu();
        Thread.sleep(1000);
        coursePage.clickConfirmGo();
        Thread.sleep(1000);
    	coursePage.deleteCourse();
    	Thread.sleep(1000);
    	coursePage.btnConfirmDelete();
    	Thread.sleep(1000);
    	coursePage.clickConfirm();
    }
    // TC5: so sánh
    @Test(priority = 7 )
    public void TC5() throws Exception {
    	// --- Điều hướng và chuẩn bị ---
        coursePage.goToCourseMenu();
        Thread.sleep(1000);
        coursePage.clickConfirm();
        Thread.sleep(2000);

        // --- 1. Dữ liệu mong đợi (Expected) ---
        String expPageTitle = "Quản lý khoá học";
        String expTitle     = "Tiêu đề";
        String expDesc      = "Mô tả";
        String expDate      = "Ngày cập nhật"; 

        System.out.println("======= SO SÁNH TÊN TRANG VÀ TIÊU ĐỀ CỘT =======");
        
        // So sánh Tiêu đề trang
        String actPage = coursePage.getQuanLyKhoaHocText();
        System.out.println((actPage.equals(expPageTitle) ? "KHỚP" : "KHÔNG KHỚP") + " | Trang: " + actPage);

        // So sánh Tiêu đề khóa học
        String actTitle = coursePage.getTieuDeText();
        System.out.println((actTitle.equals(expTitle) ? "KHỚP" : "KHÔNG KHỚP") + " | Tiêu đề: " + actTitle);

        // So sánh Mô tả
        String actDesc = coursePage.getMoTaText();
        System.out.println((actDesc.equals(expDesc) ? "KHỚP" : "KHÔNG KHỚP") + " | Mô tả: " + actDesc);

        // So sánh Ngày cập nhật
        String actDate = coursePage.getNgayCapNhatText();
        System.out.println((actDate.equals(expDate) ? "KHỚP" : "KHÔNG KHỚP") + " | Ngày: " + actDate);		
    }
    
    @Test(priority = 8)
    public void TC_6() throws Exception {
        SoftAssert softAssert = new SoftAssert();
        String projectPath = "C:\\Users\\hh\\git\\repository\\Project_AT\\Json_img\\";
        
        // 1. Lấy danh sách thực tế từ giao diện Web
        List<String> webTitles = coursePage.getAllWebCourseTitles();
        
        // 2. Đọc dữ liệu mong đợi từ file JSON
        JSONParser jsonparser = new JSONParser();
        JSONArray jsonArray = (JSONArray) jsonparser.parse(new FileReader(projectPath + "danhsach_khoahoc.json"));
        
        System.out.println("======= ĐANG SO SÁNH " + jsonArray.size() + " KHÓA HỌC =======");

        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            String expected = (String) jsonObject.get("ten_khoahoc");
            String actual = (i < webTitles.size()) ? webTitles.get(i) : "THIẾU TRÊN WEB";

            // So sánh mềm để TestNG ghi nhận kết quả vào báo cáo
            softAssert.assertEquals(actual, expected, "Lỗi dòng " + (i + 1) + ": ");

            // In kết quả rút gọn bằng toán tử ba ngôi
            String status = actual.equals(expected) ? "KHỚP" : "KHÔNG KHỚP";
            System.out.println("Dòng " + (i + 1) + ": " + status + " | KQTT: " + actual + " | KQMD: " + expected);
        }
        
        
    }
    
    
   
    
    
    

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}