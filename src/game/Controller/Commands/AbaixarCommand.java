/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Controller.Commands;

import game.Helpers.DateTime;
import game.Models.Game;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class AbaixarCommand implements Command
{
    private Game game;

    public AbaixarCommand(Game game)
    {
        this.game = game;
    }
    
    @Override
    public void execute()
    {
        try {
            game.getJogador().abaixar();
        } catch (InterruptedException ex) {
            Logger.getLogger(AbaixarCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String toString()
    {
        return "Abaixar -> " + DateTime.now() + "\n";
    }
    
}
