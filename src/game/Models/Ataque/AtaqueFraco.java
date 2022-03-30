package game.Models.Ataque;


/**
 * Write a description of class AtaqueFraco here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AtaqueFraco extends Ataque
{
    private static AtaqueFraco instancia = new AtaqueFraco();
    
    public AtaqueFraco(){
        super.setForca(5);
    }
    
    public int atacar(){
        return super.getForca();
    }
    
    public static synchronized AtaqueFraco getInstance() {
        return instancia;
    }
}
