package game.Models.Inimigo;

import java.util.Scanner;

/**
 * Write a description of class RoboMorto here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RoboMorto extends RoboEstado
{
    public RoboMorto(Inimigo r)
    {
        super(r);
        morte();
    }
    
    @Override
    public void setLimites()
    {
        this.setLimiteInferior(0);
        this.setLimiteSuperior(0);
    }
    
    @Override
    public void verificaEstado()
    {
        return;
    }
    
    @Override
    public void perdeVida(int lostLife)
    {
        this.morte();
    }
    
    public void morte()
    { 
        System.out.printf("Robo %s morto.\n", this.getRobo().getNome());
    }
    
    @Override
    public void dano(int dano)
    {
        this.morte();
    }
}
