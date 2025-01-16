package br.com.iverson.literatura.model;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String autor;
    private Double anoNascimento;
    private Double anoFalecimento;

    @OneToMany(mappedBy = "autor", fetch = FetchType.EAGER)
    private List<Livro> livros = new ArrayList<>();

    public Autor() {}

    public Autor(String autor, Double anoNascimento, Double anoFalecimento) {
        this.autor = autor;
        this.anoNascimento = anoNascimento;
        this.anoFalecimento = anoFalecimento;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Double getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(Double anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public Double getAnoFalecimento() {
        return anoFalecimento;
    }

    public void setAnoFalecimento(Double anoFalecimento) {
        this.anoFalecimento = anoFalecimento;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    @Override
    public String toString() {
        return "Autor: " + autor + ", Nascimento: " + anoNascimento + ", Falecimento: " + anoFalecimento;
    }
}
