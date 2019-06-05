package java8;


public class JavaLambdaTest {


    /**
     * lambda 表达式
     * @param args
     */
    public static void main(String[] args) {
        JavaLambdaTest tester=new JavaLambdaTest();
        //类型声明
        MathOperation addtion=(int a,int b)->a+b;
        //不用类型声明
        MathOperation subtraction=(a,b)-> a-b;
        //大括号中的返回语句
        MathOperation mulitiplication=(int a,int b)->{
            return a*b;
        };
        //没有大括号或语句
        MathOperation divison=(int a,int b)->a|b;
        //不用括号
        GreetingService greetingService=message -> System.out.println("hello "+message);
        //用括号
        GreetingService greetingService1=(message) -> System.out.println("quoat "+message);
        System.out.println("10+5="+tester.operate(10,5,addtion));
        System.out.println("10-5="+tester.operate(10,5,subtraction));
        System.out.println("10*5="+tester.operate(10,5,mulitiplication));

        //测试
        greetingService.sayMessage("test");
        greetingService1.sayMessage("test2");
    }

    interface  MathOperation{
        int operation(int a,int b);
//      int addtion(int a,int b);
    }

    interface  GreetingService{
        void sayMessage(String message);
    }

    private int operate(int a,int b,MathOperation mathOperation){
        return mathOperation.operation(a,b);
    }


}
