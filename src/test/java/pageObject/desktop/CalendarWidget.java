package pageObject.desktop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import webDriver.Driver;

public class CalendarWidget {
    static WebDriver driver = Driver.getCurrentDriver();

    public static class Popup {
        public static WebElement selectedDate() {
            return driver.findElement(By.xpath("//div[@class='calendar-widget']//div[@class='gwt-Label selected']"));
        }

        public static WebElement afterSelectedDate(int incrementDays) {
            return driver.findElement(By.xpath("//td[div/@class='gwt-Label selected' or div/@class='gwt-Label current-date selected']/following::td[" + incrementDays + "]"));
        }

        public static WebElement beforeSelectedDate(int decrementDays) {
            return driver.findElement(By.xpath("//td[div/@class='gwt-Label selected' or div/@class='gwt-Label current-date selected']/preceding::td[" + decrementDays + "]"));
        }

        public static WebElement todayDate() {
            return driver.findElement(By.xpath("//div[@class='calendar-widget']//div[@class='gwt-Label current-date' or div/@class='gwt-Label current-date selected']"));
        }

        public static WebElement afterTodayDate(int incrementDays) {
            return driver.findElement(By.xpath("//td[div/@class='gwt-Label current-date] or div/@class='gwt-Label current-date selected']/following::td[" + incrementDays + "]"));
        }

        public static WebElement beforeTodayDate(int decrementDays) {
            return driver.findElement(By.xpath("//td[div/@class='gwt-Label current-date] or div/@class='gwt-Label current-date selected']/preceding::td[" + decrementDays + "]"));
        }

        public static WebElement leftArrow() {
            return driver.findElement(By.xpath("//div[@class='calendar-widget']//div[@class='left-arrow']"));
        }

        public static WebElement rightArrow() {
            return driver.findElement(By.xpath("//div[@class='calendar-widget']//div[@class='left-arrow']"));
        }
    }
}
