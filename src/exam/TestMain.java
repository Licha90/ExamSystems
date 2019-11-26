package exam;

import java.util.ArrayList;
import java.util.Scanner;

public class TestMain {
    public static void main(String[] args) {
        //创建考试机器
        ExamMachine machine = new ExamMachine();//调用构造方法时 有一个块默认执行
        //创建学生对象 类考试
        Scanner input = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = input.nextLine();
        System.out.println("请输入密码：");
        String password = input.nextLine();
        Student student = new Student(username,password);
        String result = machine.login(student.getUserName(),student.getPassword());
        if (result.equals("登录成功")){
            System.out.println("登录成功\n" + student.getUserName() + "开始考试了 加油");
            ArrayList<Question> paper = machine.getPaper();//考试机随机抽取一张试卷
            String[] answers = student.exam(paper);
            Teacher teacher = new Teacher();
            int score = teacher.checkPaper(paper,answers);
            System.out.println(student.getUserName() +"最终的得分为"+score);
        }






//        Question question = new Question("1.如下那个选项不是Java基本数据类型?\n\tA. String\n\tB. char\n\tC. int\n\tD. double","A");
//        System.out.println(question.getTitle());
        //题干 答案 两个字符串 需要存储在一起 变成一个完整的题目
        //String[2] {"title", "answer"}
        //String "title-answer"
        //ArrayList<String[]>
        //HashMap<title, answer>
        //面向对象的编程思想--- 一道题目当作一个对象？title属性 answer属性
    }
}
