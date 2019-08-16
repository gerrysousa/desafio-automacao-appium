package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static utils.GlobalParameters.PathProject;

public class DataUtils {
    public static String getScreenshot(WebDriver driver)
    {
        TakesScreenshot ts=(TakesScreenshot) driver;
        File src=ts.getScreenshotAs(OutputType.FILE);
        String path=PathProject+"/output/Screenshot/"+System.currentTimeMillis()+".png";
        File destination=new File(path);

        try
        {
            FileUtils.copyFile(src, destination);
        } catch (IOException e)
        {
            System.out.println("Capture Failed "+e.getMessage());
        }
        return path;
    }

    public static String getDatayyyyMMdd()
    {
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        String aux = new SimpleDateFormat("yyyy-MM-dd").format(date);

        return aux;
    }

    public static String getHorahhmm()
    {
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        String aux = new SimpleDateFormat("hhmm").format(date);

        return aux;
    }

    public static String getDataHorayyyyMMddhhmm()
    {
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        String aux = new SimpleDateFormat("yyyyMMddhhmm").format(date);

        return aux;
    }
}

