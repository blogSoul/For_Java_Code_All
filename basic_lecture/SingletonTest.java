class Singleton {
    private static Singleton one;
    private Singleton(){
    }
    public static Singleton getInstance() {
        if(one == null){ // 조건에 들어오는 thread와 조건에 마치고 오는 thread 간의 문제가 생깁니다.
            one = new Singleton();
        } 
        return one;
    } // getInstance라는 static메소드를 이용하여 Single객체를 돌려 받을 수 있습니다.
}

public class SingletonTest {
    public static void main(String[] args){
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton1 == singleton2);
    } // Thread 한경에서도 안전한 싱글톤 패턴은 아니다.
}
