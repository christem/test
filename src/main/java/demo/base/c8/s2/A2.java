package demo.base.c8.s2;

public class A2 extends Apple {
    // 重写父类的方法
    public String getInfo() {
        // super.getInfo()方法返回值是Object类型，
        // 所以加toString()才返回String类型
        return super.getInfo().toString();
    }
}



