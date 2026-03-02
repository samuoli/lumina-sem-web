package br.com.samu.lumina.repository;

import br.com.samu.lumina.model.Categoria;
import br.com.samu.lumina.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface  SerieRepository extends JpaRepository<Serie, Long> {
    Optional<Serie> findByTituloContainingIgnoreCase(String nomeSerie);

    List<Serie> findByAtoresContainingIgnoreCaseAndAvaliacaoGreaterThanEqual(String nomeAtor, Double avaliacao);

    List<Serie> findTop5ByOrderByAvaliacaoDesc();

    List<Serie> findByGenero(Categoria categoria);

    List<Serie> findByTotalTemporadasLessThanEqualAndAvaliacaoGreaterThanEqual(Integer numeroMaxTemporadas, Double avaliacao);

    @Query(value = "select * from series WHERE series.total_temporadas <= 8.3 AND series.avaliacao >= 8.6", nativeQuery = true)
    List<Serie> seriesPorTemporadaEAvaliacao();
}
