package pl.szymanski.laboratory2019.Parameters.ParameterA;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class ParametrA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
   // private String tagname;
    private LocalDateTime datatime;
    private Double value;

    public ParametrA() {
    }

    public ParametrA(LocalDateTime datatime, Double value) {
        this.datatime = datatime;
        this.value = value;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public LocalDateTime getDatatime() {
        return datatime;
    }

    public void setDatatime(LocalDateTime datatime) {
        this.datatime = datatime;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ParametrA{" +
                "id=" + id +
                ", datatime=" + datatime +
                ", value=" + value +
                '}';
    }
}
