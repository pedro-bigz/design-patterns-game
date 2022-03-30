/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Controller;

import game.Controller.Commands.*;
import game.Models.Game;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Usuario
 */
public class ControleLoader
{
    private Game game;
    private ControleInvoker controleRemoto;
    
    public ControleLoader(Game g)
    {
        MacroCommand[] macros = new MacroCommand[3];
        
        controleRemoto = new ControleInvoker();
        game = g;
        
        controleRemoto.addCommand(new UpMovimentCommand(game)); // 0
        controleRemoto.addCommand(new RightMovimentCommand(game)); // 1
        controleRemoto.addCommand(new DownMovimentCommand(game)); // 2
        controleRemoto.addCommand(new LeftMovimentCommand(game)); // 3
        controleRemoto.addCommand(new AtaqueCommand(game)); // 4
        controleRemoto.addCommand(new EscudoColetorCommand(game)); // 5
        controleRemoto.addCommand(new AbaixarCommand(game)); // 6
        controleRemoto.addCommand(new PularCommand(game)); // 7
        controleRemoto.addCommand(new MagiaCommand(game)); // 8
        
        macros[0] = new MacroCommand(game);
        macros[0].addCommand(new RightMovimentCommand(game));
        macros[0].addCommand(new AbaixarCommand(game));
        macros[0].addCommand(new AtaqueCommand(game));
        macros[0].addCommand(new PularCommand(game));
        macros[0].addCommand(new LeftMovimentCommand(game));
        
        macros[1] = new MacroCommand(game);
        macros[1].addCommand(new AtaqueCommand(game));
        macros[1].addCommand(new PularCommand(game));
        macros[1].addCommand(new PularCommand(game));
        macros[1].addCommand(new AtaqueCommand(game));
        macros[1].addCommand(new AtaqueCommand(game));
        
        macros[2] = new MacroCommand(game);
        macros[2].addCommand(new AtaqueCommand(game));
        macros[2].addCommand(new LeftMovimentCommand(game));
        macros[2].addCommand(new AtaqueCommand(game));
        macros[2].addCommand(new RightMovimentCommand(game));
        macros[2].addCommand(new AtaqueCommand(game));
        macros[2].addCommand(new AtaqueCommand(game));
        
        controleRemoto.addCommand(macros[0]); // 9
        controleRemoto.addCommand(macros[1]); // 10
        controleRemoto.addCommand(macros[2]); // 11
    }
    
    public ControleInvoker getControle() {
        return controleRemoto;
    } 
    
    public ControleKeyListener getListener() {
        return new ControleKeyListener();
    } 

    public class ControleKeyListener implements KeyListener
    {        
        @Override
        public void keyTyped(KeyEvent e) {}

        @Override
        public void keyPressed(KeyEvent e)
        {
            // System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));

            if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
                controleRemoto.executeCommand(0);
            }

            if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
                controleRemoto.executeCommand(1);
            }

            if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
                controleRemoto.executeCommand(2);
            }

            if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A ) {
                controleRemoto.executeCommand(3);
            }

            if (e.getKeyCode() == KeyEvent.VK_F || e.getKeyCode() == KeyEvent.VK_3) {
                controleRemoto.executeCommand(4);
            }

            if (e.getKeyCode() == KeyEvent.VK_P || e.getKeyCode() == KeyEvent.VK_1) {
                controleRemoto.executeCommand(5);
            }
            
            if (e.getKeyCode() == KeyEvent.VK_ALT) {
                controleRemoto.executeCommand(6);
            }
            
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                controleRemoto.executeCommand(7);
            }
            
            if (e.getKeyCode() == KeyEvent.VK_M || e.getKeyCode() == KeyEvent.VK_2) {
                controleRemoto.executeCommand(8);
            }

            // Macros
            
            if (e.getKeyCode() == KeyEvent.VK_5 || e.getKeyCode() == KeyEvent.VK_T) {
                controleRemoto.executeCommand(9);
            }
            
            if (e.getKeyCode() == KeyEvent.VK_6 || e.getKeyCode() == KeyEvent.VK_Y) {
                controleRemoto.executeCommand(10);
            }
            
            if (e.getKeyCode() == KeyEvent.VK_7 || e.getKeyCode() == KeyEvent.VK_U) {
                controleRemoto.executeCommand(11);
            }
        }

        @Override
        public void keyReleased(KeyEvent e)
        {
            // System.out.println("keyReleased="+KeyEvent.getKeyText(e.getKeyCode()));
        }
    } 
}
