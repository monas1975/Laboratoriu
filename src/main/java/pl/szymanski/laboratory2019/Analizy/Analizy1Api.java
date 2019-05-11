package pl.szymanski.laboratory2019.Analizy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.szymanski.laboratory2019.Products.Products;

@RestController
public class Analizy1Api {

    private Analizy1Repo analizy1Repo;

    @Autowired
    public Analizy1Api(Analizy1Repo analizy1Repo){
        this.analizy1Repo = analizy1Repo;
    }

    @GetMapping("/showAnalizys1")
    public Iterable<Analizy1> show(){

        return analizy1Repo.findAll();
    }

}
