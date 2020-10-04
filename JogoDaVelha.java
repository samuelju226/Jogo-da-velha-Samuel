package br.edu.main;

import java.util.Scanner;

public class JogoDaVelha {


String[][] jogodavelha2 = { { "1a", "1b", "1c" }, { "2a", "2b", "2c" }, { "3a", "3b", "3c" } };

public static void main(String[] args) {
       Scanner leitura = new Scanner(System.in);
       JogoDaVelha jogo = new JogoDaVelha();
       String posicao;
       String vencedor = null;

      System.out.println("Jogador 1 informe seu nome:");
      String Nome1 = leitura.nextLine();
      System.out.println("Jogador 2 informe seu nome:");
      String Nome2 = leitura.nextLine();



while (true) {
      System.out.println("::::: Jogo da Velha :::::");
      jogo.mostrar();

do {
      System.out.println("Informe a posição de jogada:" + Nome1);
      posicao = leitura.next();

}while(!jogo.jogadaEValida(posicao));

      jogo.jogada(posicao, "X");

  vencedor = jogo.Vencedor(Nome1, Nome2);
     if (vencedor != null) {
     if (vencedor.equals("Empate")) {
        System.out.println("Deu Velha...");
   } else {
   System.out.println("O jogador: " + vencedor + " venceu ");
 }
   jogo.mostrar();
   leitura.close();
   break;
 }

 jogo.mostrar();

do {
   System.out.println("Informe a posição de jogada:" + Nome2);
posicao = leitura.next();

}while(!jogo.jogadaEValida(posicao));

  jogo.jogada(posicao, "O");

   vencedor = jogo.Vencedor(Nome1, Nome2);
     if (vencedor != null) {
     if (vencedor.equals("Empate")) {
   System.out.println("Deu Velha...");
  } else {
   System.out.println("O jogador: " +  vencedor  +  " venceu ");
 }
   jogo.mostrar();
leitura.close();
break;
 }

jogo.mostrar();

   }
 }

  public void mostrar() {
   for (int i = 0; i < 3; i++) {
   for (int j = 0; j < 3; j++) {
   System.out.printf(" " + jogodavelha2[i][j]);
 }
   System.out.println(" ");
     }
}

 public boolean jogo(String a) {
 for (int i = 0; i < 3; i++) {
 for (int j = 0; j < 3; j++) {
  if (jogodavelha2[i][j].equals(a))
  return true;
     }
 }
 return false;
}

  public boolean jogadaEValida(String a) {
 for (int i = 0; i < 3; i++) {
 for (int j = 0; j < 3; j++) {
 if (jogodavelha2[i][j].equals(a))
 return true;
   }
 }
 System.out.println("Jogada Invalida, tente novamente!");
return false;
 }

public void jogada(String a, String j) {
  if (a.equals("1a"))
  jogodavelha2[0][0] = j;
  else if (a.equals("1b"))
  jogodavelha2[0][1] = j;
  else if (a.equals("1c"))
  jogodavelha2[0][2] = j;
  else if (a.equals("2a"))
  jogodavelha2[1][0] = j;
  else if (a.equals("2b"))
  jogodavelha2[1][1] = j;
  else if (a.equals("2c"))
  jogodavelha2[1][2] = j;
  else if (a.equals("3a"))
  jogodavelha2[2][0] = j;
  else if (a.equals("3b"))
  jogodavelha2[2][1] = j;
  else if (a.equals("3c"))
  jogodavelha2[2][2] = j;
}

public String Vencedor(String nome1, String nome2) {
  String[] possiveisVencedor = new String[8];
  String Vencedor = null;
  boolean faltamJogadas = false;

possiveisVencedor[0] = jogodavelha2[0][0] + jogodavelha2[0][1] + jogodavelha2[0][2];
possiveisVencedor[1] = jogodavelha2[1][0] + jogodavelha2[1][1] + jogodavelha2[1][2];
possiveisVencedor[2] = jogodavelha2[2][0] + jogodavelha2[2][1] + jogodavelha2[2][2];
possiveisVencedor[3] = jogodavelha2[0][0] + jogodavelha2[1][0] + jogodavelha2[2][0];
possiveisVencedor[4] = jogodavelha2[0][1] + jogodavelha2[1][1] + jogodavelha2[2][1];
possiveisVencedor[5] = jogodavelha2[0][2] + jogodavelha2[1][2] + jogodavelha2[2][2];
possiveisVencedor[6] = jogodavelha2[0][0] + jogodavelha2[1][1] + jogodavelha2[2][2];
possiveisVencedor[7] = jogodavelha2[0][2] + jogodavelha2[1][1] + jogodavelha2[2][0];
  for (int i = 0; i < possiveisVencedor.length; i++) {
  if (possiveisVencedor[i].equals("XXX")) {
   Vencedor = nome1;
    } else if (possiveisVencedor[i].equals("OOO")) {
    Vencedor = nome2;
    }
}

   for (int i = 0; i < 3; i++) {
   for (int j = 0; j < 3; j++) {
    if (!jogodavelha2[i][j].equals("X") && !jogodavelha2[i][j].equals("O"))
     faltamJogadas = true;
   }
 }

   if (Vencedor == null) {
   if (faltamJogadas == false) {
    Vencedor = "Empate";
    }
}

return Vencedor;
  }

}

