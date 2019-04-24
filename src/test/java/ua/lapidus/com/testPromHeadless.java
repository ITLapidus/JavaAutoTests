package ua.lapidus.com;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.openqa.selenium.By;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;


public class testPromHeadless extends WebDriverSettingsHeadless {

    @Test
    public void testOne() {
        Random generate = new Random();
        String[] name = {"Agathon", "Alexander", "Avdey", "Averky", "Avksentiy", "Bogdan", "Boris", "Daniel", "Demian", "Dmitriy", "Dobrynya", "Donut",
                "Eugene", "Evdokim", "Evgraf", "Fedor", "Gabriel", "Galaktion", "Gelasius", "Gennady", "George",
                "Gerasim", "Makar", "Maksim", "Mark", "Martin", "Matvey", "Melentiy", "Miroslav", "Mitrofan", "Mitrofan", "Mitrofan",
                "Myron", "Nikifor", "Nikita", "Nikolai", "Nikon", "Oleg", "Onysim", "Thaddeus", "Vadim",
                "Valentine", "Valery", "Yaroslav"};
        String randomName = name[generate.nextInt(44)];

        String[] lastName = {" Vasiliev", "Aba", "Andreev", "Antonov", "Belov", "Belyaev", "Bogdanov", "Bogdanov", "Capra", "Chigirin",
                "Davydov", "Eagles", "Fedorov", "Fedorov", "Golubev", "Hares", "Ilyin", "Isaev", "Ivanov", "Ivanov",
                "Karabanov", "Kazakov", "Kiselev", "Komarov", "Kovalev", "Kozlov",
                "Kozlov", "Kuzmin", "Kuznetsov", "Lebedev", "Makarov", "Makarov", "Mikhailov",
                "Morozov", "Morozov", "Novikov", "Novikov", "Pahmutov", "Pavlov", "Petrov", "Petrov",
                "Ponomarev", "Popov", "Potekhin", "Putin", "Rostopchin", "Rudkin", "Semyonov", "Semyonov",
                "Smirnov", "Smirnov", "Sokolov", "Sokolov", "Solovyov", "Tarasov", "Tarasov", "Udin", "Vasiliev", "Vinogradov", "Wolves", "Wolves"};
        String randomLastName = lastName[generate.nextInt(61)];

        String[] emails = {"@gmail.com", "@ukr.net", "@icloud.com", "@yahoo.com", "@hotmail.com",
                "@mail.ru", "@rambler.ru", "@bigmir.net", "@qip.ru", "@list.ru", "@bk.ru"};


        DateFormat df = new SimpleDateFormat("ddMMyyyyHHmmss");
        Date today = Calendar.getInstance().getTime();
        String todayDate = df.format(today);

        String newMail = randomName.toLowerCase() + randomLastName.toLowerCase() + generate.nextInt(15000) + emails[generate.nextInt(11)];

        String generatePassword = RandomStringUtils.random(32, 0, 20, true, true, "qw32rfHIJk9iQ8Ud7h0X".toCharArray());

        chromeDriver.navigate().to("https://prom.ua/join-customer?source_id=txt.register.customer");
        chromeDriver.findElement(By.name("vertical-name")).sendKeys(
                randomName
                        + " " + randomLastName
        );
        chromeDriver.findElement(By.name("vertical-email")).sendKeys(newMail);
        chromeDriver.findElement(By.name("vertical-password")).sendKeys(generatePassword);
        chromeDriver.findElement(By.className("lp-button_height_50")).click();
        log.info("[" + today + "]" + "[" + "HEADLESS MODE" + "]" + " - USER SUCCESSFUL CREATED");
        log.info("\n----------------------------------------------------------" + "\nNAME: " + randomName + "\nFAMILY: " + randomLastName + "\nEMAIL: " + newMail + "\nPASSWORD: " + generatePassword + "\n" + "----------------------------------------------------------");
    }
}