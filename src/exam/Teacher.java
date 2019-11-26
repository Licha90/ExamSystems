package exam;

import java.util.ArrayList;

public class Teacher {
    public int checkPaper(ArrayList<Question> paper,String[] answers){
        System.out.println("老师正在批改卷子 请耐心等待。。。");
        try{
            Thread.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
        }
        int score = 0;
        for (int i = 0; i < paper.size(); i++){
            Question question = paper.get(i);
            question.getAnswer().equalsIgnoreCase(answers[i]);
            score += (100/paper.size());
        }
        return score;
    }
}
