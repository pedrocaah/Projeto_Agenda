package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Contato {
    private Long id;
    private String nome;
    private String sobrenome;
    private List<Telefone> telefones = new ArrayList<>();
    private List<Contato> agenda = new ArrayList<>(); //Criei uma lista para armazenar os dados do contato


    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id.longValue();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public void adcionar() { // construtor do método adicionar
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o ID do contato que deseja adicionar: ");
        Long id = sc.nextLong();
        if (id.equals(this.id)) {
            System.out.println("Não é possível criar um id já existente na agenda"); // condição RN1 do projeto, porém não sei se está correto.
            System.out.println(agenda);
        } else {
            System.out.println("Digite o Nome: ");
            String nome = sc.next();
            System.out.println("Digite o Sobrenome: ");
            String sobrenome = sc.next();
            Contato contato = new Contato();
            contato.setId(id);
            contato.setNome(nome);
            contato.setSobrenome(sobrenome);
            agenda.add(contato);
        }
    }

    public void remover() { // construtor do método remover, com a condição RN3 do projeto.
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o ID do contato que deseja remover: ");
        Long id = sc.nextLong();
        for (Contato contato : agenda) {
            if (contato.id == id) {
                agenda.remove(id);
            }
        }
    }

    public void editar() { // construtor do método editar, com a condição RN3 do projeto.
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o ID do contato que deseja editar: ");
        Long id = sc.nextLong();
        for (Contato contato : agenda) {
            if (contato.id == id) {
                System.out.println("Digite o novo Nome: ");
                String nome = sc.next();
                System.out.println("Digite o novo Sobrenome: ");
                String sobrenome = sc.next();
                contato.setNome(nome);
                contato.setSobrenome(sobrenome);
                break;
            }
        }
    }

    @Override
    public String toString() { // fiz um toString manual para impressão da agenda, porém não consegui imprimir na tela.
        return "Id: " + id
                + ", Nome: " + nome
                + ", Sobrenome: " + sobrenome
                + ", Contato: " + telefones;
    }

}

