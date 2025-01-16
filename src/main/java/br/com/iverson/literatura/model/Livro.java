package br.com.iverson.literatura.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Livros")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String titulo;
    @ManyToOne
    @JoinColumn(name = "autor")
    private Autor autor;

    private Double numeroDownloads;

    private String idioma;

    @Column(name = "autor_nome")
    private String autorNome;

    public String getAutorNome() {
        return autorNome;
    }

    public void setAutorNome(String autorNome) {
        this.autorNome = autorNome;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Double getNumeroDownloads() {
        return numeroDownloads;
    }

    public void setNumeroDownloads(Double numeroDownloads) {
        this.numeroDownloads = numeroDownloads;
    }

    public Livro() {}

    public Livro(DadosLivro dadosLivro) {
        this.titulo = dadosLivro.titulo();
        if (dadosLivro.autores() != null && !dadosLivro.autores().isEmpty()) {
            DadosAutor dadosAutor = dadosLivro.autores().get(0);  // Primeiro autor
            this.autor = new Autor(dadosAutor.autor(), dadosAutor.anoNascimento(), dadosAutor.anoFalecimento());
            this.autorNome = dadosAutor.autor(); // Inicializa o autorNome
        } else {
            this.autor = new Autor("Autor não informado", null, null);
            this.autorNome = "Autor não informado"; // Define autorNome como "não informado"
        }
        this.idioma = (dadosLivro.idioma() != null && !dadosLivro.idioma().isEmpty()) ? dadosLivro.idioma().get(0) : "Idioma não informado";
        this.numeroDownloads = dadosLivro.numeroDownload() != null ? dadosLivro.numeroDownload() : 0.0;
    }

    @Override
    public String toString() {
        return
                "Título: " + titulo + "\n" +
                        "Autor: " + autor + "\n" +
                        "Idioma: " + idioma + "\n" +
                        "Downloads: " + numeroDownloads + "\n" +
                        "***********************************************"+ "\n";
    }
}
