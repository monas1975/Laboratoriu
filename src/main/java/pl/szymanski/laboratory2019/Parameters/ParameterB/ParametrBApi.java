package pl.szymanski.laboratory2019.Parameters.ParameterB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParametrBApi {

    private ParametrBRepo parametrBRepo;

    @Autowired
    public ParametrBApi(ParametrBRepo parametrBRepo){
        this.parametrBRepo = parametrBRepo;
    }

    @GetMapping("/showValuesOfParameterB")
    public Iterable<ParametrB> show(){
        return parametrBRepo.findAll();
    }

}
