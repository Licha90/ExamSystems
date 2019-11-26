package exam;
import java.util.ArrayList;

public class Teacher {

    //老师负责改卷子
    //参数 学生作答所以选项  真实的试卷  跟学生随机的那套一致
    //返回值int
    public int checkPaper(ArrayList<Question> paper,String[] answers){
        System.out.println("老师正在批改卷子 请耐心等待。。。");
        try{
            Thread.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
        }
        int score = 0;
        for (int i = 0; i < paper.size(); i++){
            //循环获取paper的题目
            Question question = paper.get(i);
            //获取与题目相对应的答案 对比学生的答案
            question.getAnswer().equalsIgnoreCase(answers[i]);
            //正确就加分
            score += (100/paper.size());
        }
        return score;
    }
}
