package com.maji.chapter5.localDate;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Date;


public class DateTest {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate); //日期
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime); //时间
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime); //日期和时间


        System.out.println(LocalDate.of(2017, 1, 1).equals(localDate));
        System.out.println(LocalDate.of(2017, 1, 1).isBefore(localDate));

        //生日送上祝福
        LocalDate dateOfBirth = LocalDate.of(2017, 1, 1);
        MonthDay birthday = MonthDay.of(dateOfBirth.getMonth(), dateOfBirth.getDayOfMonth());
        MonthDay currentMonthDay = MonthDay.now();
        if(currentMonthDay.equals(birthday)){
            System.out.println("Many Many happy returns of the day !!");
        }else{
            System.out.println("Sorry, today is not your birthday");
        }

        System.out.println("=========时间增减========");
        LocalDateTime newDateTime = localDateTime.plusHours(2);
        System.out.println(newDateTime); //增加两小时
        System.out.println(localDateTime.plus(-3, ChronoUnit.MINUTES)); //减三分钟

        System.out.println("========时间格式化=======");
        String oneDay = "2017-10-01T10:15:30";
        LocalDateTime parseOne = LocalDateTime.parse(oneDay); //格式必需匹配
        System.out.println("方法一："+parseOne);
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd\'T\'HH:mm:ss"); //线程安全
            LocalDateTime pareseTwo = LocalDateTime.parse(oneDay, formatter);
            System.out.println("方法二："+ pareseTwo);
        } catch (DateTimeParseException ex) {
            ex.printStackTrace();
        }

        Duration duration = Duration.between(parseOne,localDateTime);
        System.out.println("和今天间隔："+duration.toDays()+"天");


        System.out.println("=====与Date转换=======");
        Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        System.out.println(instant); //UTC+0
        Date date = Date.from(instant);
        System.out.println(date);

        Instant instant1 = new Date().toInstant();
        System.out.println(instant1);
        System.out.println(LocalDateTime.ofInstant(instant1,ZoneId.systemDefault()));

    }
}
