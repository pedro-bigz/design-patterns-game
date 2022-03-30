/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Helpers;

/**
 *
 * @author Usuario
 */
public class Dir {
    public static String pwd()
    {
        return System.getProperty("user.dir");
    }
    
    public static String imagePath()
    {
        return "/images";
    }
    
    public static String configsPath()
    {
        return "src/configs";
    }
}
