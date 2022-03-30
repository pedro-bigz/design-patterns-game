/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Controller;

import game.GameFactory;
import static game.Helpers.FactoryHelper.getFactory;
import game.Models.Game;
import game.Models.Inimigo.Inimigo;
import game.Models.Personagem.Jogador;
import game.Views.GameView;
import game.Views.PrimeiraFase;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author Usuario
 */
public class GameController
{
    private Game game;
    private ControleLoader controleLoader;
    
    private static GameController instance = new GameController();

    public static GameController getInstance() {
        return instance;
    }
    
    private GameController(){}
            
    public void index(int value) throws InterruptedException
    {
        GameFactory factory = getFactory(value);
        
        game = new Game(
            value,
            factory.criarJogador(),
            factory.criarInimigos(3),
            factory.criarEscudosFase1(),
            factory.criarCenario()
        );
        
        controleLoader = new ControleLoader(game); 
        
        KeyListener listener = controleLoader.getListener();
        PrimeiraFase.show(value, game, listener);
    } 
}
