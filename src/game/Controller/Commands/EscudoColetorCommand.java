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
public class EscudoColetorCommand implements Command
{
    private Game game;

    public EscudoColetorCommand(Game game)
    {
        this.game = game;
    }
    
    @Override
    public void execute()
    {
        game.getJogador().coletaEscudo(game.getEscudos());
    }

    @Override
    public String toString()
    {
        return "Escudo coletado -> " + DateTime.now() + "\n";
    } 
}
