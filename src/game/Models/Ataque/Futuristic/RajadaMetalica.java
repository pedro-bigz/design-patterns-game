package game.Models.Ataque.Futuristic;

import game.Models.Ataque.Ataque;
import game.Models.Ataque.Poder;
import static game.Utilities.futuristicData;
import java.io.IOException;


/**
 * Write a description of class RajadaMetalica here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RajadaMetalica extends Poder
{
    private static RajadaMetalica instancia = null;
    
    public RajadaMetalica(Ataque poder) throws IOException {
        super(poder, futuristicData.ataqueImagesPath.get("special"));
        super.setForca(7);
    }
    
    @Override
    public int atacar(){
        return super.atacar();
    }     
    
    public static synchronized RajadaMetalica getInstance(Ataque poder)
        throws IOException
    {
        if (instancia == null) {
            instancia = new RajadaMetalica(poder);
        }
        return instancia;
    }
}
