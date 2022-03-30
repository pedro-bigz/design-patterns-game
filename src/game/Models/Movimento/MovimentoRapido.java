package game.Models.Movimento;


/**
 * Write a description of class MovimentoRapido here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MovimentoRapido implements Movimento
{
    private static MovimentoRapido instancia = new MovimentoRapido();
    private int velocidade;
    
    private MovimentoRapido()
    {
        velocidade = 15;
    }
    public int correr() {
        return velocidade;
    }
    
    public static MovimentoRapido getInstance()
    {
        return instancia;
    }
}
