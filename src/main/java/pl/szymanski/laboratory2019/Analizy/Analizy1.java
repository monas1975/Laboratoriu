package pl.szymanski.laboratory2019.Analizy;

import pl.szymanski.laboratory2019.Parameters.ParameterA.ParametrA;
import pl.szymanski.laboratory2019.Parameters.ParameterB.ParametrB;
import pl.szymanski.laboratory2019.Parameters.ParameterC.ParametrC;
import pl.szymanski.laboratory2019.Products.Products;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Analizy1 {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; //nr parti

    private LocalDateTime datetime;
    private LocalDateTime updateDataTime;

    public LocalDateTime getUpdateDataTime() {
        return updateDataTime;
    }

    public void setUpdateDataTime(LocalDateTime updateDataTime) {
        this.updateDataTime = updateDataTime;
    }

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


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public ParametrA getParametrA() {
        return parametrA;
    }

    public void setParametrA(ParametrA parametrA) {
        this.parametrA = parametrA;
    }

    public ParametrB getParametrB() {
        return parametrB;
    }

    public void setParametrB(ParametrB parametrB) {
        this.parametrB = parametrB;
    }

    public ParametrC getParametrC() {
        return parametrC;
    }

    public void setParametrC(ParametrC parametrC) {
        this.parametrC = parametrC;
    }

    @Override
    public String toString() {
        return "Analizy1{" +
                "id=" + id +
                ", datetime=" + datetime +
                ", products=" + products +
                ", parametrA=" + parametrA +
                ", parametrB=" + parametrB +
                ", parametrC=" + parametrC +
                '}';
    }
}
