package Store;

import java.util.Random;

public class GeradorEmail {
    public String geradorNome;
    public  void main(String[] args) {
    }
    public  String getNome() {

        // Gera letras aleatórias em cada execução para compor um novo endereço de e-mail.
        String letras = "abcdefghijklmnopqrstuvwxiz";

        Random random = new Random();

        String nome = "";
        String email = "@gmail.com";
        int index = -1;
        for (int i = 0; i < 9; i++) {
            index = random.nextInt(letras.length());
            nome += letras.substring(index, index + 1);
        }
        geradorNome = nome + email;

        return this.geradorNome;
    }

}

