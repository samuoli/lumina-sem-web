package br.com.samu.lumina;

import br.com.samu.lumina.model.DadosSerie;
import br.com.samu.lumina.service.ConsumoApi;
import br.com.samu.lumina.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LuminaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LuminaApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        var consumoApi = new ConsumoApi();
        var json = consumoApi.obterDados("https://www.omdbapi.com/?t=The+Sopranos&apikey=f57b6e86");

        System.out.println(json);
        ConverteDados conversor = new ConverteDados();
        DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
        System.out.println(dados);
    }
}
