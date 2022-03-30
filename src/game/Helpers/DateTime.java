/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Helpers;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Usuario
 */
public class DateTime
{
    public static String now()
    {
        return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
    }
    
    public static String now(String format)
    {
        return new SimpleDateFormat(format).format(new Date());
    }
}
