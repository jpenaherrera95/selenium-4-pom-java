package UI.PageObjects;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class TestUtils {

    private static final ObjectMapper objectMapper = new ObjectMapper();
    public static void typeOnElement(WebElement element, String text){
        element.isDisplayed();
        element.sendKeys(text);
    }

    public static void clickOnButton(WebElement element){
        element.isDisplayed();
        element.isEnabled();
        element.click();
    }

    public static JsonNode getTestData(String filePath) throws IOException {
        try (InputStream inputStream = TestUtils.class.getClassLoader().getResourceAsStream(filePath)){
            if (inputStream == null) {
                throw new IOException("File not found: " + filePath);
            }
            return objectMapper.readTree(inputStream);
        }
    }
}
