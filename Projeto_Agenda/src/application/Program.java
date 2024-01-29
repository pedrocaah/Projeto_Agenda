package application;
//C:\Users\Pedro\Documents\SantanderCoders\Projeto_Agenda\agenda.txt

import entities.Contact;
import entities.Telephone;


import java.io.*;
import java.text.ParseException;
import java.util.*;
import java.util.List;
import java.util.Scanner;


public class Program {
    public static void main(String[] args) throws ParseException, IOException {

        List<Telephone> telephones = new ArrayList<>();
        List<Contact> list = new ArrayList<>();


        System.out.println("##################");
        System.out.println("##### AGENDA #####");
        System.out.println("##################\n");
        reader(list, telephones);
        writer(list, telephones);
        list(list, telephones);
        Menu(list, telephones);


    }

    public static void reader(List<Contact> list, List<Telephone> telephones) { //método para criação do arquivo .csv e escrever dentro.

        String sourceFileStr = "agenda.csv";
        File sourceFile = new File(sourceFileStr);

        try (BufferedReader br = new BufferedReader(new FileReader(sourceFileStr))) {
            String itemCsv = br.readLine();
            while (itemCsv != null) {
                String[] fields = itemCsv.split(","); // usei o split para separar os parâmetros por vírgula, implementei um toString nas classes entities.
                Long id = Long.parseLong(fields[0]);
                String nome = fields[1];
                String sobrenome = fields[2];
                String ddd = fields[3];
                Long numero = Long.parseLong(fields[4]);
                list.add(new Contact(id, nome, sobrenome, telephones));
                telephones.add(new Telephone(id, ddd, numero));
                itemCsv = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static void writer(List<Contact> list, List<Telephone> telephones) throws IOException { // método para saída do arquivo na tela.
        FileWriter fw = new FileWriter("agenda.csv");
        PrintWriter pw = new PrintWriter(fw);
        for (Contact item : list) {
            pw.print(item.getId() + "," + item.getNome() + "," + item.getSobrenome());

            for (Telephone telefone : item.getTelefones()) {
                pw.print("," + telefone.getDdd() + "," + telefone.getNumero());
            }
            pw.println();
        }
    }

    public static void Menu(List<Contact> list, List<Telephone> telephones) throws IOException { //método para criação e interação do menu proposto no projeto.
        Scanner sc = new Scanner(System.in);
        System.out.println(">>>> Menu <<<<");
        System.out.println("1 - Adicionar Contato");
        System.out.println("2 - Remover Contato");
        System.out.println("3 - Editar Contato");
        System.out.println("4 - Sair");
        System.out.println("Digite a opção deseja");
        int opcao = sc.nextInt();

        switch (opcao) { // Utilizei o laço switch case para interação com o menu.
            case 1:
                adicionar(list, telephones);
                break;
            case 2:
                remover(list, telephones);
                break;
            case 3:
                editar(list, telephones);
                break;
            case 4:
                list(list, telephones);
        }

    }


    public static void adicionar(List<Contact> list, List<Telephone> telephones) { // método para adicionar contatos a lista

        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o id: ");
        Long id = sc.nextLong();
        System.out.println("Digite o nome: ");
        sc.nextLine();
        String nome = sc.nextLine();
        System.out.println("Digite o sobrenome: ");
        String sobrenome = sc.nextLine();
        System.out.println("Digite o DDD: ");
        String ddd = sc.nextLine();
        System.out.println("Digite o numero: ");
        Long numero = sc.nextLong();
        Telephone tel = new Telephone(id, ddd, numero);
        telephones.add(tel);
        list.add(new Contact(id, nome, sobrenome, telephones));

    }

    public static void list(List<Contact> list, List<Telephone> telephones) { // método para imprimir saida da lista na tela.
        System.out.println(">>>> Contatos <<<<");
        System.out.println("Id | Nome");
        System.out.println();
        int i, n = list.size();
        for (i = 0; i < n; i++) {
            System.out.printf("%d | %s", i, list.get(i));
        }
    }

    public static void remover(List<Contact> list, List<Telephone> telephones) { // método para excluir contatos, referenciando o ID digitado.
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o ID que deseja excluir: ");
        Long id = sc.nextLong();

        list.removeIf(x -> x.getId().equals(id));
        telephones.removeIf(x -> x.getId().equals(id));
    }

    public static void editar(List<Contact> list, List<Telephone> telephones) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o id do contato a ser editado: ");
        Long id = sc.nextLong();

        int index = list.indexOf(id);

        if (index != -1) {

            System.out.println("Digite o novo nome: ");
            sc.nextLine();
            String nome = sc.nextLine();
            System.out.println("Digite o novo sobrenome: ");
            String sobrenome = sc.nextLine();
            System.out.println("Digite o novo DDD: ");
            String ddd = sc.nextLine();
            System.out.println("Digite o novo numero: ");
            Long numero = sc.nextLong();
            Telephone tel = new Telephone(id, ddd, numero);
            int newIndex = list.indexOf(new Contact(id, nome, sobrenome, telephones));
            telephones.set(newIndex, tel);
            list.set(newIndex, new Contact(id, nome, sobrenome, telephones));

        } else {
            System.out.println("Contato não encontrado.");
            writer(list, telephones);
        }
    }

}

