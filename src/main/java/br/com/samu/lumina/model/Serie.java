package br.com.samu.lumina.model;

import br.com.samu.lumina.service.ConsultaChatGPT;
import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.Optional;
import java.util.OptionalDouble;

public class Serie {
    private String titulo;
    private Integer totalTemporadas;
    private Double avaliacao;
    private Categoria genero;
    private String atores;
    private String poster;
    private String sinopse;

    public  Serie(DadosSerie dadosSerie){
        this.titulo = dadosSerie.titulo();
        this.totalTemporadas = dadosSerie.totalTemporadas();
        this.genero = Categoria.fromString(dadosSerie.genero().split(",")[0].trim()); //Pega a String antes da virgula;
        this.atores = dadosSerie.atores();
        this.poster = dadosSerie.poster();

        try {
            this.avaliacao = Double.valueOf(dadosSerie.avaliacao());
        } catch (NumberFormatException e) {
            this.avaliacao = 0.0;
        }

        if (dadosSerie.sinopse() != null && !dadosSerie.sinopse().equalsIgnoreCase("N/A")) {
            this.sinopse = ConsultaChatGPT.obterTraducao(dadosSerie.sinopse());
        } else {
            this.sinopse = "Sinopse não disponível.";
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getTotalTemporadas() {
        return totalTemporadas;
    }

    public void setTotalTemporadas(Integer totalTemporadas) {
        this.totalTemporadas = totalTemporadas;
    }

    public Double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Categoria getGenero() {
        return genero;
    }

    public void setGenero(Categoria genero) {
        this.genero = genero;
    }

    public String getAtores() {
        return atores;
    }

    public void setAtores(String atores) {
        this.atores = atores;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    @Override
    public String toString() {
        return
                "genero=" + genero +
                ", titulo='" + titulo + '\'' +
                ", totalTemporadas=" + totalTemporadas +
                ", avaliacao=" + avaliacao +
                ", atores='" + atores + '\'' +
                ", poster='" + poster + '\'' +
                ", sinopse='" + sinopse + '\'';
    }

}
