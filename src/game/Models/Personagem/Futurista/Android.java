package game.Models.Personagem.Futurista;

import game.Models.Ataque.AtaqueMedio;
import game.Helpers.Posicao;
import game.Models.Personagem.Jogador;
import game.Utilities;
import java.io.IOException;

public class Android extends Jogador {
    public Android(Posicao posicao, int width, int height)
        throws IOException
    {
        super(
            "Android",
            posicao,
            width,
            height,
            Utilities.futuristicData.characterPaths.get("android")
        );
        
        String descricao = "Mussum Ipsum, cacilds vidis litro abertis."
            + "Si num tem leite então bota uma pinga aí cumpadi!"
            + "Quem num gosta di mim que vai caçá sua turmis!"
            + "Delegadis gente finis, bibendum egestas augue arcu ut est."
            + "Per aumento de cachacis, eu reclamis.";
        
        super.setAtaque(AtaqueMedio.getInstance());
        super.setDescricao(descricao);
    }
}
