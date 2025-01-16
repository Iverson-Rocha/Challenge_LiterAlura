package br.com.iverson.literatura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosLivro(@JsonAlias("title") String titulo,
                         @JsonAlias("download_count") Double numeroDownload,
                         @JsonAlias("languages") List<String> idioma,
                         @JsonAlias("authors") List<DadosAutor> autores) {
}
