package game.Models.Personagem.Medieval;

import game.Models.Ataque.AtaqueForte;
import game.Helpers.Posicao;
import game.Models.Personagem.Jogador;
import game.Utilities;
import java.io.IOException;

public class Paladino extends Jogador {
    public Paladino(Posicao posicao, int width, int height)
        throws IOException
    {
        super(
            "Paladino",
            posicao,
            width,
            height,
            Utilities.medievalData.characterPaths.get("paladino")
        );
        String descricao = "Mussum Ipsum, cacilds vidis litro abertis."
            + "Si num tem leite então bota uma pinga aí cumpadi!"
            + "Quem num gosta di mim que vai caçá sua turmis!"
            + "Delegadis gente finis, bibendum egestas augue arcu ut est."
            + "Per aumento de cachacis, eu reclamis.";
        
        super.setAtaque(AtaqueForte.getInstance());
        super.setDescricao(descricao);
    }
}
