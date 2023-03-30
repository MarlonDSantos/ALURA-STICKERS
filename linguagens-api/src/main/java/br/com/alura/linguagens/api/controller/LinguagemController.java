package br.com.alura.linguagens.api.controller;

import br.com.alura.linguagens.api.model.Linguagem;
import br.com.alura.linguagens.api.repository.LinguagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LinguagemController {

    @Autowired
    private LinguagemRepository repositorio;
    private List<Linguagem> linguagens = List.of(
            new Linguagem("JAVA","https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/java/java_256x256.png",1),
            new Linguagem("JavaScript","https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/javascript/javascript_256x256.png", 2)
    );
    @GetMapping(value = "/linguagem-preferida")
    public String processoLinguagemPreferida(){
        return "Oi, JAVA!";
    }

    @GetMapping("/linguagens")
    public List<Linguagem> obterLinguagens(){
        List<Linguagem> linguagens = repositorio.findAll();

        return  linguagens;
    }
}
