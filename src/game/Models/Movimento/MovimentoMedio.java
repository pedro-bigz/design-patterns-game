package game.Models.Movimento;


/**
 * Write a description of class MovimentoMedio here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MovimentoMedio implements Movimento
{
    private static MovimentoMedio instancia = new MovimentoMedio();
    private int velocidade;
    
    private MovimentoMedio()
    {
        velocidade = 10;
    }
    
    public int correr()
    {
        return velocidade;
    }
    
    public static MovimentoMedio getInstance()
    {
        return instancia;
    }
}
