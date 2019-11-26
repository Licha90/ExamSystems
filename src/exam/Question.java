package exam;

public class Question {

    private String title;
    private String answer;

    public Question(String title, String answer){
        this.answer = answer;
        this.title = title;
    }

    //重写方法 将默认比较题目对象地址规则 改成 比较题干 如果题干一致 就认为是同一个题目
    public boolean equals(Object obj){
        if (this==obj){//比较类 如果类相同 类的内容就相同类 就直接返回true
            return true;
        }
        if (obj instanceof Question){//如果类不一样 就判断当前的obj是不是属于Question类型的 如果类型不一样就直接返回false不用比了
            //如果属于Question  就先把obj还原回Question类型 这样就可以使用Question里面独有的方法
            Question anotherQuestion = (Question)obj;
            if (this.title.equals(anotherQuestion.title)){
                return true;
            }
        }

        return false;
    }

    public int hashCode(){
        return this.title.hashCode();
    }

    public String getTitle(){
        return this.title;
    }

    public String getAnswer(){
        return this.answer;
    }
}
