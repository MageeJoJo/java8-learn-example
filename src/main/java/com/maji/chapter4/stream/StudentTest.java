package com.maji.chapter4.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

/**
 * Stream Api 把函数式编程风格引入到Java，简化集合框架的处理
 * 核心思想是用流的方式遍历
 * 一个流的生命周期分为三个阶段：1、生成；2、操作、变换（可以多次）；3、消耗（只有一次）
 *
 */
public class StudentTest {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
             new Student("Fndroid", 22, Student.Sax.MALE, 180),
             new Student("Jack", 20, Student.Sax.MALE, 170),
              new Student("Liliy", 18, Student.Sax.FEMALE, 160)
         );

        System.out.println("输出所有性别为MALE的学生");
        students.stream() // 打开流
         .filter(student -> student.getSax() == Student.Sax.MALE) // 进行过滤
         .forEach(System.out::println); // 输出

        System.out.println("求出所有学生的平均年龄");
        OptionalDouble average = students.stream().mapToInt(Student::getAge) //将对象映射为整形
                .average();
        System.out.println(average.orElse(0));

        System.out.println("输出每个学生姓名的大写形式");
        List<String> names = students.stream().map(Student::getName).map(String::toUpperCase).collect(Collectors.toList());//生成列表
        System.out.println("所有学生姓名的大写为：" + names);

        System.out.println("按照年龄从小到大排序");
        List<Student> sortedAges = students.stream().sorted(((o1, o2) -> o1.getAge() - o2.getAge())).collect(Collectors.toList());
        System.out.println("按年龄排序后列表为：" +sortedAges);

        System.out.println("判断是否存在名为Fndroid的学生");
        students.stream().filter(student -> student.getName().equals("Fndroid")).forEach(System.out::println);
        boolean fndroid = students.stream().anyMatch(student -> student.getName().equals("Fndroid"));
        System.out.println(fndroid);

        System.out.println("将所有学生按照性别分组");
        Map<Student.Sax, List<Student>> groupBySax = students.stream().collect(Collectors.groupingBy(Student::getSax));
        System.out.println(groupBySax.get(Student.Sax.MALE));
        groupBySax.forEach((sax, studentList) -> {
            System.out.print(sax+":");
            System.out.println(studentList);
        });

        System.out.println("求出每个学生身高比例");
        double sumHeight = students.stream().mapToDouble(Student::getHeight).sum();
        List<String> collect = students.stream().mapToInt(Student::getHeight).mapToDouble(value -> value / sumHeight).mapToObj(value -> String.valueOf(value)).collect(Collectors.toList());
        System.out.println(collect);

        //更多Stream的用法 https://www.ibm.com/developerworks/cn/java/j-lo-java8streamapi/
    }
}
