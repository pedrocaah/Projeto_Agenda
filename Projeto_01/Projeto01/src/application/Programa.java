package application;

import entities.Telefone;
import entities.Contato;

import java.util.*;

/*Método main, onde monto a lógica da aplicação e layout da saída na tela*/
public class Programa {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Contato contato = new Contato();
        Telefone telefone = new Telefone();
        List<Telefone> telefones = new ArrayList<>();
        List<Contato> agenda = new ArrayList<>();


        System.out.println("##################");
        System.out.println("##### AGENDA #####");
        System.out.println("##################\n");

        System.out.println(">>>> Contatos <<<<");
        System.out.println("Id | Nome");
        System.out.println();


        System.out.println();
        System.out.println(">>>> Menu <<<<");
        System.out.println("1 - Adicionar Contato");
        System.out.println("2 - Remover Contato");
        System.out.println("3 - Editar Contato");
        System.out.println("4 - Sair");
        System.out.println("Digite a opção deseja");
        int opcao = sc.nextInt();

        switch (opcao) { // Utilizei o laço switch case para interação com o menu
            case 1:
                contato.adcionar(); //Chamando o método adcionar da classe contato
                telefone.adicionarTelefone(); //Chamando o método adiconar da classe telefone
                break;
            case 2:
                contato.remover(); //Chamando o método remover da classe contato
                break;
            case 3:
                contato.editar(); //Chamando o método editar da classe contato
                break;
            case 4:
                sc.close();

                while (opcao != 4) { //Tentei criar um laço para que o terminal só fechasse caso o usuário digitasse 4, porém não consegui
                    System.out.println();
                    System.out.println(">>>> Menu <<<<");
                    System.out.println("1 - Adicionar Contato");
                    System.out.println("2 - Remover Contato");
                    System.out.println("3 - Editar Contato");
                    System.out.println("4 - Sair");
                    System.out.println("Digite a opção deseja");
                    opcao = sc.nextInt();
                }
        }
        System.out.println(telefones); // Ainda tentando imprimir a lista na tela, porém ainda não consegui
        System.out.println(agenda); // Ainda tentando imprimir a lista na tela, porém ainda não consegui
        //Tentarei corrigir essas falhas, e codar um novo projeto utizando arquivos de textos.
    }

}
