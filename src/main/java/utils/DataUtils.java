package utils;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
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

    public static String converterDataIos(String dataCrua) {

        String aux = dataCrua;//Oct 6, 2019
        aux = aux.replace(",","");//Oct 6 2019 remover a virgura

        String [] dateParts = aux.split(" ");
        String mes = dateParts[0];//Oct
        String dia = dateParts[1];//6
        String ano = dateParts[2];//2019

        dia = StringUtils.leftPad(dia, 2, "0");//06

        //int mesInt = Integer.parseInt(mes.trim());
        String mesString[];
        mesString = new String[ 13 ];
        mesString[ 0 ] = "null";
        mesString[ 1 ] = "Jan";
        mesString[ 2 ] = "Feb";
        mesString[ 3 ] = "Mar";
        mesString[ 4 ] = "Apr";
        mesString[ 5 ] = "May";
        mesString[ 6 ] = "Jun";
        mesString[ 7 ] = "Jul";
        mesString[ 8 ] = "Aug";
        mesString[ 9 ] = "Sep";
        mesString[ 10 ] = "Oct";
        mesString[ 11 ] = "Nov";
        mesString[ 12 ] = "Dec";

        int mesProcurado=0;
        for (int i =0; i < mesString.length;i++)
        {
            if (mesString[i].equals(mes))
            {
                mesProcurado = i;
            }
        }

        String mesAuxString = Integer.toString(mesProcurado);
        mesAuxString = StringUtils.leftPad(mesAuxString, 2, "0");//06


        String texto = dia+"/"+mesAuxString+"/"+ano;
        return texto;
    }

    public static String converterDataAndroid(String dataCrua) {
        String aux = dataCrua;

        String [] dateParts = aux.split("/");
        String mes = dateParts[0];
        String dia = dateParts[1];
        String ano = dateParts[2];
        dia = StringUtils.leftPad(dia, 2, "0");
        mes = StringUtils.leftPad(mes, 2, "0");

        String texto = dia+"/"+mes+"/"+ano;
        return texto;
    }
}

