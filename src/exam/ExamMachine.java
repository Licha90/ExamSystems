package exam;

import sun.security.ssl.HandshakeOutStream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class ExamMachine {
    //属性--记录学生用户名和密码 HashMap
    private HashMap<String, String> userBox = new HashMap<String,String>();
    {
        userBox.put("小明","123");
        userBox.put("小红","666");
        userBox.put("小绿","333");
    }
    //属性--题库 好多个Questions类型的对象 每一个对象是一道题目
    //Set集合 如果题库进行扩充 产生重复题目可以自动删除掉
    //hash集合遵循的规则是 equals 和 hashCode的方法
    private HashSet<Question> questionBank = new HashSet<>();

    //利用块来初始化hashSet集合内的题目对象
    {
        questionBank.add(new Question("以下哪个选项是Java基本数据类型?\n\tA. String\n\tB. char\n\tC. int\n\tD. double","C"));
        questionBank.add(new Question("以下哪个选项不是Java基本数据类型?\n\tA. String\n\tB. char\n\tC. int\n\tD. double","A"));
        questionBank.add(new Question("以下哪个选项是Java引用数据类型?\n\tA. String\n\tB. char\n\tC. int\n\tD. double","A"));
        questionBank.add(new Question("以下哪个选项不是Java引用数据类型?\n\tA. String\n\tB. char\n\tC. int\n\tD. double","C"));
        questionBank.add(new Question("以下哪个选项是java.util包中的类?\n\tA. String\n\tB. Integer\n\tC. Scanner\n\tD. Math","C"));
        questionBank.add(new Question("以下哪个选项不是java.util包中的类?\n\tA. String\n\tB. Integer\n\tC. Scanner\n\tD. Math","B"));
        questionBank.add(new Question("以下哪个选项是String类中的方法?\n\tA. compareTo\n\tB. append\n\tC. substring\n\tD. concat","D"));
        questionBank.add(new Question("以下哪个选项不是String类中的方法?\n\tA. delete\n\tB. append\n\tC. insert\n\tD. concat","B"));
        questionBank.add(new Question("以下哪个选项不是接口中属性的修饰符?\n\tA. public\n\tB. final\n\tC. abstract\n\tD. static","C"));
        questionBank.add(new Question("以下哪个选项不是Set集合的方法?\n\tA. set\n\tB. add\n\tC. remove\n\tD. iterator","A"));
    }

    //设计一个方法 随机生成试卷
    //参数 确定试卷5道题 返回值-->试卷ArrayList<Question>
    public ArrayList<Question> getPaper(){
        System.out.println("考试机器正在随机的生成试卷 请等待");
        try{
            Thread.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
        }
        //随机抽取试卷的时候 试卷的题目应该不重复 set存-->变成arrayList
        HashSet<Question> paper = new HashSet<Question>();//试卷
        //产生一个随机的序号 去找寻题目 题库是一个set没有序号  就把题库变成有序的--ArrayList
        ArrayList<Question> questionBank = new ArrayList<Question>(this.questionBank);//把当前的questionBank构建回来
        //随机抽题
        while (paper.size()!= 5){
        int index = new Random().nextInt(this.questionBank.size());//[0-10)
        Question question = questionBank.get(index);
        paper.add(question);
        }
        return new ArrayList<Question>(paper);
        //构造方法的来回使用 构建 Set 和 List 都在Collection类中
    }

    //考试机器中还有一个登录方法  HashMap 比较key就等于比较value了
    public String login(String username, String password){
        String realPassword = this.userBox.get(username);
        if (realPassword != null && realPassword.equals(password)){
            return "登录成功";
        }
        return "用户名或密码错误";
    }
}
