/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Views;

import game.GameFactory;
import game.Models.Ataque.Poder;
import game.Models.Escudo.Escudo;
import game.Models.Escudo.EscudoForte;
import game.Models.Escudo.EscudoFraco;
import game.Models.Escudo.EscudoMedio;
import game.Helpers.DataManager;
import static game.Helpers.FactoryHelper.getFactory;
import game.Helpers.JLabelData;
import game.Helpers.Posicao;
import game.Models.Game;
import game.Models.Inimigo.Inimigo;
import game.Models.Personagem.Jogador;
import game.Utilities;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Dictionary;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Usuario
 */
public class PrimeiraFase extends GameView
{
    private GameView proximaFase;
    private static PrimeiraFase instancia = null;
    
    protected final Font EnemyStatusFont = new Font("Serif", Font.BOLD, 20);
    protected final Font baseFont = new Font("Serif", Font.BOLD, 60);
    
    public static PrimeiraFase getInstance(int gameType, KeyListener listener)
    {
        if (instancia == null) {
            instancia = new PrimeiraFase(gameType, listener);
        }
        
        return instancia;
    }

    private PrimeiraFase(int gameType, KeyListener listener)
    {
        super(gameType);
        addKeyListener(listener);
        setFocusable(true);
        
        proximaFase = SegundaFase.getInstance(gameType, listener);

    }  

    @Override
    public void drawJogador(Graphics2D g2d, Jogador jogador, JLabelData jogadorLabel)
    {
        // g2d.fillOval(jogador.getX(), jogador.getY(), 20, 20);        
        g2d.drawImage(
            jogador.getAvatar(),
            jogador.getX(),
            jogador.getY(),
            jogador.getWidth(),
            jogador.getHeight(),
            null
        );        

        // -- Jogador -- //
        g2d.setColor(Color.WHITE);
        g2d.fillRect(
            jogadorLabel.getBackgroundPosX(),
            jogadorLabel.getBackgroundPosY(),
            jogadorLabel.getWidth(),
            jogadorLabel.getHeight()
        );

        g2d.setColor(Color.RED);
        g2d.setFont(EnemyStatusFont);
         
        g2d.drawString(
            getPorcentagemVida(jogador, "Jogador: "),
            jogadorLabel.getTextPosX(),
            jogadorLabel.getTextPosY()
        );
    }

    @Override
    public void drawRobo(Graphics2D g2d, Inimigo robo, Dictionary<String, Object> enemyData)
    {
        JLabelData labelData = (JLabelData) enemyData.get("jlabel");
        Color color = (Color) enemyData.get("color");
        
        g2d.drawImage(
            robo.getAvatar(),
            robo.getX(),
            robo.getY(),
            robo.getWidth(),
            robo.getHeight(),
            null
        );

        // --- Inimigo 3 --- //
        g2d.setColor(Color.WHITE);
        g2d.fillRect(
            labelData.getBackgroundPosX(),
            labelData.getBackgroundPosY(),
            labelData.getWidth(),
            labelData.getHeight()
        );

        g2d.setColor(color);
        g2d.setFont(EnemyStatusFont);
        
        g2d.drawString(
            getPorcentagemVida(robo, robo.getNome() + ":"),
            labelData.getTextPosX(),
            labelData.getTextPosY()
        );
    }

    public String getPorcentagemVida(Jogador jogador, String preffix)
    {
        return String.format("%s %d", preffix, jogador.getQuantidade());
    }

    public String getPorcentagemVida(Inimigo robo, String preffix)
    {
        return String.format("%s %d", preffix, robo.getQuantidade());
    }

    @Override
    public void jogar(Game g)
        throws InterruptedException
    {
        this.game = g;
        if (game.getJogador() == null || game.getEnemys() == null) {
            System.exit(0);
        }
        
        System.out.println("------------- Comeca jogo --------------");

        JFrame frame = new JFrame("RoboHunt");

        JLabel label = new JLabel();
        JLabel lifeJogador = new JLabel();
        JLabelData jogadorLabel = (JLabelData) configs.personagemData.get("jlabel");
        
        configs.enemysData.forEach(enemy -> {
            JLabel enemyLabel = new JLabel();
            JLabelData labelData = (JLabelData) enemy.get("jlabel");
            
            enemyLabel.setFont(baseFont);
            enemyLabel.setText(labelData.getName());
            
            this.add(enemyLabel);
        });
        
        game.getEnemys().forEach(enemy -> {
            game.getJogador().addObserver(enemy);
        });

        label.setBounds(0, 0, Utilities.WIDTH, Utilities.HEIGHT);
        label.setIcon(game.getBackgroundGame());

        this.setLayout(null);
        this.add(label);

        // ------- //

        lifeJogador.setFont(baseFont);
        lifeJogador.setText(jogadorLabel.getName());
        this.add(lifeJogador);
        
        // ------- //

        frame.add(this);
        frame.setSize(Utilities.WIDTH, Utilities.HEIGHT + 29);
        frame.setVisible(true);
        frame.setResizable(false);   
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (!game.getEnemys().isEmpty()) {            
            game.getJogador().show();
            this.repaint();
            Thread.sleep(50);
        }
        
        setProximaFase();        
        proximaFase.jogar(game);
    }
      
    @Override
    public void setProximaFase()
    {
        GameFactory factory = getFactory(gameType);
        
        game.setEnemys(factory.criarInimigosRapidos(5));
        game.setBackgroundGame(factory.criarCenarioFase2());
        game.setEscudos(factory.criarEscudosFase2());
    }
    
    public static void show(int gameType, Game game, KeyListener listener)
        throws InterruptedException
    {
        PrimeiraFase.getInstance(gameType, listener)
            .jogar(game);
    }
}
