/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Controller.Commands;

import game.Helpers.DateTime;
import game.Models.Game;

/**
 *
 * @author Usuario
 */
public class RightMovimentCommand implements Command
{
    private Game game;

    public RightMovimentCommand(Game game)
    {
        this.game = game;
    }
    
    @Override
    public void execute()
    {
        game.getJogador().moveToRight();
    } 

    @Override
    public String toString()
    {
        return "Movimento Para direita -> " + DateTime.now() + "\n";
    } 
}
