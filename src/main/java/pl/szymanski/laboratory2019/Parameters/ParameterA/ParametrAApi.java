package pl.szymanski.laboratory2019.Parameters.ParameterA;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParametrAApi {

    private ParametrARepo parametrARepo;


    @Autowired
    public ParametrAApi(ParametrARepo parametrARepo){
        this.parametrARepo = parametrARepo;
    }

    @GetMapping("/showValuesOfParameterA")
    public Iterable<ParametrA> show(){
        return parametrARepo.findAll();
    }
}
