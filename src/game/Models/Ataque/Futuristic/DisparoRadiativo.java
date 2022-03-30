/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Models.Ataque.Futuristic;

import game.Models.Ataque.Ataque;
import game.Models.Ataque.Poder;
import static game.Utilities.futuristicData;
import java.io.IOException;

/**
 *
 * @author Usuario
 */
public class DisparoRadiativo extends Poder
{
    private static DisparoRadiativo instancia = null;
    
    private int forca = 10;
    
    public DisparoRadiativo(Ataque poder) throws IOException {
        super(poder, futuristicData.ataqueImagesPath.get("special"));
        super.setForca(forca);
    }
    
    @Override
    public int atacar(){
        return super.atacar();
    }   
    
    public static synchronized DisparoRadiativo getInstance(Ataque poder)
        throws IOException
    {
        if (instancia == null) {
            instancia = new DisparoRadiativo(poder);
        }
        return instancia;
    }
}