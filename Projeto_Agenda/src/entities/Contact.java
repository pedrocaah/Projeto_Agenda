package entities;

import java.util.List;

public class Contact {

    private Long id;
    private String nome;
    private String sobrenome;
    private List<Telephone> telefones;

    public Contact(Long id, String nome, String sobreNome, List<Telephone> telefones) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefones = telefones;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Telephone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telephone> telefones) {
        this.telefones = telefones;
    }

    @Override
    public String toString() {
        return String.format("%d,%s,%s", id, nome, sobrenome);
    }
}
