package game.Models.Movimento;


/**
 * Write a description of class MovimentoDevagar here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MovimentoDevagar implements Movimento
{
    private static MovimentoDevagar instancia = new MovimentoDevagar();
    private int velocidade;
    
    private MovimentoDevagar()
    {
        velocidade = 5;
    }
    
    public int correr() {
        return velocidade;
    }
    
    public static MovimentoDevagar getInstance()
    {
        return instancia;
    }
}
