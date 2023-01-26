package internQ1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDr                                                                                                                                                                                                    iver;
import java.util.Calendar;
import java.util.List;

public class GoogleSearch {
    public static void main(String[] args) {
    	
        Calendar calendar = Calendar.getInstance();
        int currentDay = calendar.get(Calendar.DAY_OF_WEEK);
  
        String[][] keywords = {
                {"Monday", "Dhaka"},
                {"Tuesday", "Morning"},
                {"Wednesday", "Baby"},
                {"Thursday", "School"},
                {"Friday", "Cricket"},
                {"Saturday", "money"},
                {"Sunday", "Int"}
        };

    
        String[] dayKeywords = keywords[currentDay - 1];


        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        
        List<String> options = new ArrayList<>();
        for (String keyword : dayKeywords) {
            driver.get("https://www.google.com");
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys(keyword);
            searchBox.submit();

            List<WebElement> searchResults = driver.findElements(By.cssSelector(".r"));
            for (WebElement result : searchResults) {
                options.add(result.getText());
            }
        }
        driver.quit();

     
        String longestOption = "";
        String shortestOption = options.get(0);
        for (String option : options) {
            if (option.length() > longestOption.length()) {
                longestOption = option;
            }
            if (option.length() < shortestOption.length()) {
                shortestOption = option;
            }
        }
        System.out.println("Longest option: " + longestOption);
        System.out.println("Shortest option: " + shortestOption);
    }
}
