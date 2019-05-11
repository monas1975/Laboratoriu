package pl.szymanski.laboratory2019.Analizy;

import pl.szymanski.laboratory2019.Parameters.ParameterA.ParametrA;
import pl.szymanski.laboratory2019.Parameters.ParameterB.ParametrB;
import pl.szymanski.laboratory2019.Parameters.ParameterC.ParametrC;
import pl.szymanski.laboratory2019.Products.Products;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Analizy1 {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; //nr parti

    private Date datetime;

    @OneToOne
    @JoinColumn(name="produkt")
    private Products products;


    @OneToOne
    @JoinColumn(name="parametrA_id")
    private ParametrA parametrA;

    @OneToOne
    @JoinColumn(name="parametrB_id")
    private ParametrB parametrB;

    @OneToOne
    @JoinColumn(name="parametrC_id")
    private ParametrC parametrC;











}
