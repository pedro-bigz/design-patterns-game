package game.Models.Ataque;


/**
 * Write a description of class AtaqueMedio here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AtaqueMedio extends Ataque
{
    private static AtaqueMedio instancia = new AtaqueMedio();
    
    public AtaqueMedio(){
        super.setForca(10);
    }
    
    public int atacar(){
        return super.getForca();
    }
    
    public static synchronized AtaqueMedio getInstance() {
        return instancia;
    }
}
