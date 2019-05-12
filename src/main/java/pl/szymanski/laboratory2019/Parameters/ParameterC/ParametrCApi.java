package pl.szymanski.laboratory2019.Parameters.ParameterC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParametrCApi {

    private ParametrCRepo parametrCRepo;

    @Autowired
    public ParametrCApi(ParametrCRepo parametrCRepo){
        this.parametrCRepo = parametrCRepo;
    }

    @GetMapping("/showValuesOfParameterC")
    public Iterable<ParametrC> show(){
        return  parametrCRepo.findAll();
    }


}
