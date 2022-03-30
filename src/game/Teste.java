package game;

import game.Controller.GameController;

public class Teste
{
    static final Runtime run = Runtime.getRuntime();
    static Process pro;
    
    public static void main(String args[])
        throws InterruptedException
    {
        Utilities.readConfigs();
        GameController.getInstance().index(0);
    }
}
