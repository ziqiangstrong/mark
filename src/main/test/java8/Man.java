package java8;

public class Man extends People {


    public void talk() {
        System.out.println("子类");
    }

    public static void main(String[] args) {
        Man man=new Man();
        man.talk();
    }
}
