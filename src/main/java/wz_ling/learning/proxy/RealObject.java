package wz_ling.learning.proxy;

public class RealObject implements SayDemo, PlayDemo {


    @Override
    public String sayGoodBye() {
        return "goodbye RealObject";
    }

    @Override
    public void playGame(String game) {
        System.out.println("play game[" + game + "]");
    }
}
