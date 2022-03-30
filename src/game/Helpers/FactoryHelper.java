/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Helpers;

import game.FuturisticGameFactory;
import game.GameFactory;
import game.MedievalGameFactory;

/**
 *
 * @author Usuario
 */
public class FactoryHelper
{
    public static GameFactory getFactory(int value)
    {
        if (value == 1) {
            return FuturisticGameFactory.getInstance();
        } else if (value == 0) {
            return MedievalGameFactory.getInstance();
        }
        
        return null;
    }
    
    public static GameFactory getFactory(String value)
    {
        if (value.equals("1")) {
            return FuturisticGameFactory.getInstance();
        } else if (value.equals("0")) {
            return MedievalGameFactory.getInstance();
        }
        
        return null;
    }
}
