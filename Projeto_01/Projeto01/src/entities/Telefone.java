package entities;

import java.util.Scanner;

public class Telefone {
    private Long idTelefone;
    private String ddd;
    private Long numero;


    public long getidTelefone() {

        return idTelefone;
    }

    public void setidTlefone(Long id) {

        this.idTelefone = id;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {

        this.ddd = ddd;
    }

    public long getNumero() {

        return numero;
    }

    public void setNumero(Long numero) {

        this.numero = numero;
    }

    public void adicionarTelefone() { // construtor método adicionar telefone
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o telefone do contato seguido por Id, DDD e número: ");
        Long idTelefone = sc.nextLong();
        if (idTelefone.equals(this.idTelefone)) { // condição RN1 do projeto, porém não sei se está correto.
            System.out.println("Não é possível criar um Id já existente");
        } else {
            String ddd = sc.next();
            Long numero = sc.nextLong();
            Telefone telefone = new Telefone();
            telefone.setidTlefone(idTelefone);
            telefone.setDdd(ddd);
            telefone.setNumero(numero);
        }
    }

    @Override
    public String toString() { // usei o toString padrão da IDE, porém sem sucesso no retorno na classe Programa.
        final StringBuilder sb = new StringBuilder("Telefone{");
        sb.append("id=").append(idTelefone);
        sb.append(", ddd='").append(ddd).append('\'');
        sb.append(", numero=").append(numero);
        sb.append('}');
        return sb.toString();
    }
}