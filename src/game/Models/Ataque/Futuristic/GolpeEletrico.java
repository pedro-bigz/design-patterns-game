package game.Models.Ataque.Futuristic;

import game.Models.Ataque.Ataque;
import game.Models.Ataque.Poder;
import static game.Utilities.futuristicData;
import java.io.IOException;


/**
 * Write a description of class SuperSoco here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GolpeEletrico extends Poder
{
    private static GolpeEletrico instancia = null;
    
    public GolpeEletrico(Ataque poder) throws IOException {
        super(poder, futuristicData.ataqueImagesPath.get("superchute"));
        super.setForca(5);
    }
    
    @Override
    public int atacar(){
        return super.atacar();
    }        
    
    public static synchronized GolpeEletrico getInstance(Ataque poder)
        throws IOException
    {
        if (instancia == null) {
            instancia = new GolpeEletrico(poder);
        }
        return instancia;
    } 
}
