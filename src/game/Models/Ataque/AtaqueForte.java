package game.Models.Ataque;


/**
 * Write a description of class AtaqueForte here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AtaqueForte extends Ataque
{
    private static AtaqueForte instancia = new AtaqueForte();
    
    public AtaqueForte(){
        super.setForca(15);
    }
    
    @Override
    public int atacar(){
        return super.getForca();
    }
    
    public static synchronized AtaqueForte getInstance() {
        return instancia;
    }
}
