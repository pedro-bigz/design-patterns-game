package game.Models.Inimigo;

import game.Models.Ataque.Ataque;
import game.Helpers.Posicao;
import game.Models.Personagem.Jogador;
import java.util.Observer;
import java.util.Observable;
import java.awt.image.BufferedImage;
import game.Models.Movimento.Movimento;
import game.Utilities;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Inimigo implements Observer {
    private RoboEstado vida;
    private int quantidade;
    private int x;
    private int y;
    private String nome;
    private Movimento movimento;
    private Ataque ataque;
    private Posicao posicao;
    private BufferedImage image;
    private int width, height;

    public Inimigo(int x, int y, int width, int height, String nome, BufferedImage image)
    {
        this.posicao = new Posicao(x, y, Utilities.WIDTH - width, Utilities.HEIGHT - height);
        this.nome = nome;
        this.image = image;
        this.width = width;
        this.height = height;
        this.quantidade = 70;

        this.vida = new RoboNormal(this);
    }

    public Inimigo(Posicao posicao, int width, int height, String nome, BufferedImage image)
    {
        this.posicao = posicao;
        this.nome = nome;
        this.image = image;
        this.width = width;
        this.height = height;
        this.quantidade = 70;

        this.vida = new RoboNormal(this);
    }

    public Inimigo(int x, int y, int width, int height, String nome, String path)
        throws IOException
    {
        this.posicao = new Posicao(x, y, Utilities.WIDTH - width, Utilities.HEIGHT - height);
        this.nome = nome;
        this.width = width;
        this.height = height;
        this.quantidade = 70;

        this.image = ImageIO.read(
            getClass().getResourceAsStream(path)
        );

        this.vida = new RoboNormal(this);
    }

    public Inimigo(Posicao posicao, int width, int height, String nome, String path)
        throws IOException
    {
        this.posicao = posicao;
        this.nome = nome;
        this.width = width;
        this.height = height;
        this.quantidade = 70;

        this.image = ImageIO.read(
            getClass().getResourceAsStream(path)
        );
        
        this.vida = new RoboNormal(this);
    }

    public int getWidth()
    {
        return width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public RoboEstado getVida()
    {
        return this.vida;
    }

    public void setVida(RoboEstado vida)
    {
        this.vida = vida;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(int quantidade)
    {
        this.quantidade = quantidade;
    }

    public String getNome()
    {
        return this.nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public int getX()
    {
        return this.posicao.getX();
    }

    public int getY()
    {
        return this.posicao.getY();
    }

    public void setX(int x)
    {
        this.posicao.setX(x);
    }

    public void setY(int y)
    {
        this.posicao.setY(y);
    }

    public void setPos(int x, int y)
    {
        this.posicao.setPos(x, y);
    }

    public void setAvatar(BufferedImage image)
    {
        this.image = image;
    }

    public BufferedImage getAvatar()
    {
        return this.image;
    }

    public void recebeAtaque(int ataque)
    {
        vida.dano(ataque);
    }

    public void recompensa()
    {
        vida.ganhaVida();
    }

    public void update(Observable subject, Object arg)
    {
        double randomFloat;
        Jogador jogador = (Jogador) subject;

        // se estiver em distancia de ataque
        if (
            (Math.abs(this.getX() - jogador.getX()) == 0) &&
            (Math.abs(this.getY() - jogador.getY()) == 0)
        ) {
            jogador.recebeAtaque(this.getAtaque().atacar());

            randomFloat = Math.random();
            if (randomFloat < 0.5) {
                jogador.setPos(
                    jogador.getX() + (int) (100 * randomFloat),
                    jogador.getY() - (int) (100 * randomFloat)
                );
            } else {
                jogador.setPos(
                    jogador.getX() - (int) (100 * randomFloat),
                    jogador.getY() + (int) (100 * randomFloat)
                );
            }

        } else {
            // se precisa andar para frente
            if (jogador.getX() > this.getX()) {
                this.moveToRight((int) (5 * Math.random()));
            } else {
                this.moveToLeft((int) (5 * Math.random()));
            }
            // se precisa andar para tras
            if (jogador.getY() > this.getY()) {
                this.moveToDown((int) (5 * Math.random()));
            } else {
                this.moveToUp((int) (5 * Math.random()));
            }

        }

        if (jogador.getX() < 0) {
            jogador.setX(100);
        }
        if (jogador.getY() < 0) {
            jogador.setY(100);
        }

    }

    // ------------------------------------------------ //

    public Movimento getMovimento()
    {
        return this.movimento;
    }

    public void setMovimento(Movimento movimento)
    {
        this.movimento = movimento;
    }

    public Ataque getAtaque()
    {
        return this.ataque;
    }

    public void setAtaque(Ataque ataque)
    {
        this.ataque = ataque;
    }

    public void corrida()
    {
        movimento.correr();
    }

    public void ataque()
    {
        ataque.atacar();
    }

    public void moveToUp(int moviment)
    {
        moviment *= this.getMovimento().correr() * .15;
        if (this.getY() - moviment >= 0) {
            this.setY(this.getY() - moviment);
        } else {
            this.setY(0);
        }
    }

    public void moveToDown(int moviment)
    {
        moviment *= this.getMovimento().correr() * .15;
        if (this.getY() + moviment <= this.posicao.getMaxY()) {
            this.setY(this.getY() + moviment);
        } else {
            this.setY(this.posicao.getMaxY());
        }
    }

    public void moveToLeft(int moviment)
    {
        moviment *= this.getMovimento().correr() * .15;
        if (this.getX() - moviment >= 0) {
            this.setX(this.getX() - moviment);
        } else {
            this.setX(0);
        }
    }

    public void moveToRight(int moviment)
    {
        moviment *= this.getMovimento().correr() * .15;
        if (this.getX() + moviment <= this.posicao.getMaxX()) {
            this.setX(this.getX() + moviment);
        } else {
            this.setX(this.posicao.getMaxX());
        }
    }
}