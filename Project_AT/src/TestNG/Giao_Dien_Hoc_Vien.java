package TestNG;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.event.InputEvent;

import org.testng.annotations.Test;
import pages.LoginPageUser;
import pages.LearningPage;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.List;

public class Giao_Dien_Hoc_Vien {
    WebDriver driver;
    LoginPageUser loginPageUser;
    LearningPage learningPage;

    @BeforeTest
    public void beforeTest() {
    	System.setProperty("webdriver.chrome.driver", "D:\\Project_AT\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://elearning.plt.pro.vn/trang-chu");
        driver.manage().window().maximize();
        loginPageUser = new LoginPageUser(driver);
        learningPage = new LearningPage(driver);
    }

    @Test (priority = 1)
    public void TC1() throws InterruptedException {
        loginPageUser.login("test1.pltsolutions@gmail.com", "plt@intern_051224");
        Thread.sleep(3000);
        learningPage.selectCourse();
        Thread.sleep(3000);

        int[] lessons = {9, 8, 8, 4, 3, 4};
        for (int i = 1; i <= 6; i++) {
            learningPage.clickChapter(i);
            Thread.sleep(1000);
            for (int j = 1; j <= lessons[i-1]; j++) {
                learningPage.clickLesson(i, j);
                Thread.sleep(1000);
            }
        }
    }

    @Test (priority = 2)
    public void TC2() {
        List<String> expectedList = Arrays.asList(
            "Chương 1: HTML cơ bản", "Chương 2: CSS và thiết kế giao diện",
            "Chương 3: JavaScript căn bản", "Chương 4: JavaScript nâng cao",
            "Chương 5: Responsive Website", "Chương 6: Dự án mini Website cá nhân"
        );
        System.out.println("======= SO SÁNH KẾT QUẢ CHƯƠNG =======");
        for (int i = 1; i <= 6; i++) {
            String actual = learningPage.getChapterTitle(i);
            String expected = expectedList.get(i - 1);
            System.out.println((actual.equals(expected) ? "KHỚP" : "KHÔNG KHỚP") + " | Chương " + i + " | KQTT: " + actual);
        }
    }

    @Test (priority = 3)
    public void TC3() {
        List<String> expectedList = Arrays.asList(
            "Học cách xây dựng cấu trúc trang web bằng HTML: thẻ tiêu đề, đoạn văn, hình ảnh, liên kết, danh sách và form nhập liệu.",
            "Tìm hiểu cách định dạng giao diện với CSS: màu sắc, font chữ, bố cục, responsive và hiệu ứng cơ bản",
            "Làm quen với biến, hàm, sự kiện và thao tác DOM để tạo website có tính tương tác.",
            "Mở rộng kiến thức JavaScript để xây dựng ứng dụng web động.",
            "Thiết kế giao diện tương thích trên mobile, tablet và desktop.",
            "Xây dựng website cá nhân hoàn chỉnh áp dụng HTML, CSS và JavaScript."
        );
        System.out.println("======= SO SÁNH KẾT QUẢ MÔ TẢ CỦA CHƯƠNG =======");
        for (int i = 1; i <= 6; i++) {
            String actual = learningPage.getChapterDescription(i);
            String expected = expectedList.get(i - 1);
            System.out.println((actual.equals(expected) ? "KHỚP" : "KHÔNG KHỚP") + " | KQTT: " + actual);
        }
    }

    @Test(priority = 4)
    public void TC4() {
        // Giữ nguyên toàn bộ List dữ liệu của Hải
        List<String> e1 = Arrays.asList("Bài số 1: Giới thiệu về HTML","Bài số 2: Các thẻ cơ bản trong HTML","Bài số 3: Làm việc với hình ảnh và liên kết","Bài số 4: Tạo danh sách và bảng trong HTML","Bài số 5: Biểu mẫu và các yếu tố nhập liệu","Bài số 6: Semantic HTML","Bài số 7: Thực hành xây dựng trang web đơn giản","Bài số 8: Tổng kết chương 1","Bài số 9: Kiểm tra chương 1");
        List<String> e2 = Arrays.asList("Bài số 1: Giới thiệu về HTML","Bài số 2: Các thẻ cơ bản trong HTML","Bài số 3: Làm việc với hình ảnh và liên kết","Bài số 4: Tạo danh sách và bảng trong HTML","Bài số 5: Biểu mẫu và các yếu tố nhập liệu","Bài số 6: Semantic HTML","Bài số 7: Thực hành xây dựng trang web đơn giản","Bài số 8: Tổng kết chương 1");
        
        System.out.println("======= SO SÁNH TÊN BÀI =======");
        // Chương 1
        System.out.println("= Chương 1 =");
        for (int i = 1; i <= 9; i++) {
            String actual = learningPage.getLessonTitle(1, i);
            System.out.println((actual.equals(e1.get(i-1)) ? "KHỚP" : "KHÔNG KHỚP") + " | Bài " + i + " | KQTT: " + actual);
        }
        // Chương 2 đến 6 (Giữ đúng logic dùng e2.get(i-1) của bạn)
        int[] counts = {8, 8, 4, 3, 4};
        for (int ch = 2; ch <= 6; ch++) {
            System.out.println("= Chương " + ch + " =");
            for (int i = 1; i <= counts[ch-2]; i++) {
                String actual = learningPage.getLessonTitle(ch, i);
                System.out.println((actual.equals(e2.get(i-1)) ? "KHỚP" : "KHÔNG KHỚP") + " | Bài " + i + " | KQTT: " + actual);
            }
        }
    }

    @Test(priority = 5)
    public void TC5() throws InterruptedException, AWTException {
        List<String> expectedList = Arrays.asList(
            "Định nghĩa kiểm thử phần mềm (Software Testing) Mục đích của kiểm thử Kiểm thử và đảm bảo chất lượng (Testing vs QA vs QC)",
            "Tầm quan trọng của kiểm thử Hậu quả khi không kiểm thử Lợi ích kinh tế của kiểm thử sớm",
            "Testing chỉ là tìm bug Tester không cần biết kỹ thuật Không cần test khi phần mềm nhỏ"
        );

        learningPage.clickNavMenu();
        Thread.sleep(3000);
        learningPage.clickSubMenu();
        Thread.sleep(3000);
        learningPage.clickChapter(1);
        Thread.sleep(3000);
        for (int i = 1; i <= 3; i++) { learningPage.clickLesson(1, i); Thread.sleep(1000); }
        
        learningPage.clickChapter(2);
        for (int i = 1; i <= 2; i++) { learningPage.clickLesson(2, i); Thread.sleep(1000); }

        System.out.println("======= SO SÁNH KẾT QUẢ MÔ TẢ CỦA BÀI HỌC =======");
        for (int i = 1; i <= 3; i++) {
            String actual = learningPage.getLessonDescription(1, i);
            System.out.println((actual.equals(expectedList.get(i-1)) ? "KHỚP" : "KHÔNG KHỚP") + " | KQTT: " + actual);
        }

        learningPage.closeVideoIcon(1, 3);
        learningPage.closeVideoIcon(2, 1);
        Thread.sleep(3000);
       
        
        

        WebDriverWait wait = new WebDriverWait(driver, 10);
        // Tìm iframe YouTube bằng thuộc tính src (tránh lỗi cross-origin khi switch)
        driver.switchTo().defaultContent();
        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        boolean foundYoutubeFrame = false;
        for (WebElement frame : iframes) {
            String src = frame.getAttribute("src");
            if (src != null && src.contains("youtube.com/embed")) {
                driver.switchTo().frame(frame);
                System.out.println("ĐÃ VÀO ĐÚNG IFRAME VIDEO: " + src);
                foundYoutubeFrame = true;
                break;
            }
        }

        if (foundYoutubeFrame) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            try {
                // Gọi trực tiếp YouTube Player API — không cần tìm button
                Thread.sleep(2000); // đợi player load xong
                js.executeScript("document.getElementById('movie_player').playVideo();");
                System.out.println("ĐÃ GỌI playVideo() QUA JAVASCRIPT");
            } catch (Exception e1) {
                System.out.println("JS playVideo() thất bại, thử click nút: " + e1.getMessage());
                try {
                    WebElement playBtn = wait.until(ExpectedConditions.elementToBeClickable(
                        By.cssSelector(".ytp-large-play-button")
                    ));
                    playBtn.click();
                    System.out.println("ĐÃ CLICK NÚT PLAY LỚN");
                } catch (Exception e2) {
                    System.out.println("KHÔNG THỂ CLICK NÚT PLAY: " + e2.getMessage());
                }
            }
            driver.switchTo().defaultContent();
        } else {
            System.out.println("KHÔNG TÌM THẤY IFRAME YOUTUBE");
        }
           
           Thread.sleep(5000);
    }

    @AfterTest
    public void afterTest() { driver.quit(); }
}