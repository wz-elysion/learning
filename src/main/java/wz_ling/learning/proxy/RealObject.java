package wz_ling.learning.proxy;

public class RealObject implements SayDemo, PlayDemo {


    @Override
    public String sayGoodBye() {
        System.out.println("goodbye RealObject");
        return "goodbye RealObject";
    }

    @Override
    public void playGame(String game) {
        System.out.println("play game[" + game + "]");
    }
}
