package game.Models.Inimigo;


/**
 * Write a description of interface RoboEstado here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class RoboEstado
{
    private Inimigo robo;
    private int limiteInferior, limiteSuperior;
    
    public RoboEstado(Inimigo robo)
    {
        this.robo = robo;
        setLimites();
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
    
    public int getLimiteSuperior()
    {
        return this.limiteSuperior;
    }
    
    public void setLimiteSuperior(int limiteSuperior)
    {
        this.limiteSuperior = limiteSuperior;
    }
    
    public void perdeVida(int lostLife)
    {
        this.robo.setQuantidade(this.robo.getQuantidade() - lostLife);
        verificaEstado();
    }
    
    public void ganhaVida()
    {
        if (this.robo.getQuantidade() >= 100) {
            this.robo.setQuantidade(100);
        } else {
            this.robo.setQuantidade(this.robo.getQuantidade() + 10);
        }
        verificaEstado();
    }
    
    public abstract void setLimites();    
    public abstract void dano(int dano);    
    public abstract void verificaEstado();
    
}
