package game.Models.States;

import game.Models.Ataque.AtaqueMedio;
import game.Models.Inimigo.Inimigo;
import game.Models.Movimento.MovimentoRapido;
import game.Models.Personagem.Jogador;


/**
 * Write a description of class EstadoNormal here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class EstadoNormal extends Estado
{
    private Jogador jogador;
    private Inimigo robo;
    private int limiteInferior, limiteSuperior;
    private static EstadoNormal instancia = null;
    
    private EstadoNormal(Jogador jogador)
    {
        this.jogador = jogador;
        this.jogador.setMovimento(MovimentoRapido.getInstance());
        this.jogador.setAtaque(AtaqueMedio.getInstance());
        
        setLimites();
        System.out.println("Estado Normal");
    }
    
    public static synchronized EstadoNormal getInstance(Jogador jogador) {
        if(instancia == null) {
            instancia = new EstadoNormal(jogador);
        }
        return instancia;
    }
    
    @Override
    public final void setLimites()
    {
        this.setLimiteInferior(35);
        this.setLimiteSuperior(75);
    }
    
    @Override
    public void verificaEstado()
    {
        if(this.getJogador().getQuantidade() <= this.getLimiteInferior()){
            this.getJogador().setVida(EstadoPerigo.getInstance(this.getJogador()));
        }else if(this.getJogador().getQuantidade() > this.getLimiteSuperior()){
            this.getJogador().setVida(EstadoForte.getInstance(this.getJogador()));
        }
    }
    
    @Override
    public void dano(int dano)
    {
        this.perdeVida(dano);
    }
    
    public Jogador getJogador()
    {
        return this.jogador;
    }
    
    public void setJogador(Jogador jogador)
    {
        this.jogador = jogador;
    }
    
    public Inimigo getRobo()
    {
        return this.robo;
    }
    
    public void setRobo(Inimigo robo)
    {
        this.robo = robo;
    }
    
    public int getLimiteInferior()
    {
        return this.limiteInferior;
    }
    
    public void setLimiteInferior(int limiteInferior)
    {
        this.limiteInferior = limiteInferior;
    }
    
    public int getLimiteSuperior(){
        return this.limiteSuperior;
    }
    
    public void setLimiteSuperior(int limiteSuperior)
    {
        this.limiteSuperior = limiteSuperior;
    }
    
    public void perdeVida(int lostLife)
    {
        this.jogador.setQuantidade(
            this.jogador.getQuantidade() - lostLife
        );
        this.verificaEstado();
    }
    
    public void ganhaVida()
    {
        if(this.jogador.getQuantidade() >= 100){
            this.jogador.setQuantidade(100);
        } else {
            this.jogador.setQuantidade(this.jogador.getQuantidade() + 10);
        }
        this.verificaEstado();
    }
}
