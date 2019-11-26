package exam;

import java.util.ArrayList;
import java.util.Scanner;

public class Student {
    //属性
    private String userName;
    private String password;

    public Student(String userName,String password){
        this.userName = userName;
        this.password = password;
    }

    public String getUserName(){
        return this.userName;
    }

    public String getPassword(){
        return this.password;
    }

    //学生考试的方法
    //参数--是一套试卷 返回值--学生作答的所有选项String[]"A" "B" "C" "D"
    public String[] exam(ArrayList<Question> paper){
        String[] answers = new String [paper.size()];
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < paper.size(); i++){
            Question question = paper.get(i);//题干 真实的答案
            System.out.println((i + 1) + " " + question.getTitle());
            System.out.println("请输入正确答案");
            answers[i] = input.nextLine();//获取学生的答题
        }
        return answers;
    }
}
