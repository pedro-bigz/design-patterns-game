/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Helpers;

import java.awt.Color;

/**
 *
 * @author Usuario
 */
public class ColorFinder {
    public static Color getColorByName(String name) {
        Color color = null;
        try {
            color = (Color) Color.class.getField(name.toUpperCase()).get(null);
        } catch (
            IllegalArgumentException |
            IllegalAccessException |
            NoSuchFieldException |
            SecurityException e
        ) {
            e.printStackTrace();
        } finally {
            return color;
        }
    }
}
