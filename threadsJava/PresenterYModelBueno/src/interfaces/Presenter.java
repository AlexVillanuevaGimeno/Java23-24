package interfaces;

public class Presenter implements MyInterface{

    @Override
    public void motrarLoginCorrecto() {
        System.out.println("LOGIN CORRECTO");
    }

    @Override
    public void motrarLoginIncorrecto() {
        System.out.println("LOGIN INCORRECTO");
    }
}
