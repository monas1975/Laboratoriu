package pl.szymanski.laboratory2019.Analizy;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.szymanski.laboratory2019.Parameters.ParameterA.ParametrA;
import pl.szymanski.laboratory2019.Parameters.ParameterA.ParametrARepo;
import pl.szymanski.laboratory2019.Parameters.ParameterB.ParametrB;
import pl.szymanski.laboratory2019.Parameters.ParameterB.ParametrBRepo;
import pl.szymanski.laboratory2019.Parameters.ParameterC.ParametrC;
import pl.szymanski.laboratory2019.Parameters.ParameterC.ParametrCRepo;
import pl.szymanski.laboratory2019.Products.Products;
import pl.szymanski.laboratory2019.Products.ProductsRepo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@StyleSheet("static/css/style.css")

@Route("addAnalise")
public class Analizy1Gui extends VerticalLayout {


    ProductsRepo productsRepo;
    ParametrARepo parametrARepo;
    ParametrCRepo parametrCRepo;
    ParametrBRepo parametrBRepo;

    // @Autowired
    Analizy1Repo analizy1Repo;

//    private Long tempID;
//    private LocalDateTime tempNow;

    List<String> elements = new ArrayList<>();
    List<Analizy1> analizy1sList = new ArrayList<>();
    ComboBox<String> comboBox = new ComboBox("test");

    ParametrA parametrA;
    ParametrB parametrB;
    ParametrC parametrC;


    private Button button1 = new Button("Uworz analize");
    private Label label1 = new Label("nr analizy                     ");
    private Label label2 = new Label("data analizy                   ");
    private NumberField numberField = new NumberField("Parametr A");
    private NumberField numberField2 = new NumberField("Parametr B");
    private NumberField numberField3 = new NumberField("Parametr C");
    final VerticalLayout layout = new VerticalLayout();

    private Button button2 = new Button("Wprowadz wyniki");

    private Analizy1 analizy1;

    @Autowired
    private Analizy1Gui(ProductsRepo productsRepo, Analizy1Repo analizy1Repo, ParametrARepo parametrARepo, ParametrBRepo parametrBRepo, ParametrCRepo parametrCRepo) {
        this.productsRepo = productsRepo;
        this.analizy1Repo = analizy1Repo;
        this.parametrARepo = parametrARepo;
        this.parametrBRepo = parametrBRepo;
        this.parametrCRepo = parametrCRepo;
        //  elements.add("test");
        //  elements.add("test2");
        //  elements.add("test3");
        //  comboBox.setItems("1","2","3","4");
        Iterable<Products> all = productsRepo.findAll();
        List<String> producsNames = new ArrayList<>();
        for (Products products : all) {
            producsNames.add(products.getName());
        }
        comboBox.setItems(producsNames);

        Iterable<Analizy1> allAnalzy1 = analizy1Repo.findAll();
        List<Analizy1> analizy1List = new ArrayList<>();

        for (Analizy1 analizy1 : allAnalzy1) {
            analizy1List.add(analizy1);

        }

      //  tempID = analizy1List.get(analizy1List.size() - 1).getId();
       // tempNow = analizy1List.get(analizy1List.size() - 1).getDatetime();


        layout.setSizeFull();
        add(layout);

        numberField.setStep(0.01);
        numberField2.setStep(0.01);

        button1.addClickListener(buttonClickEvent -> createAnalizy1());


        button2.addClickListener(buttonClickEvent -> updateAnalizy1());
        //   listBox.setItems(productsRepo.findAll());
        add(button1);
        add(label1);
        add(label2);
        add(comboBox);
        add(numberField);
        add(numberField2);
        add(numberField3);
        add(button2);
    }

    public Analizy1 createAnalizy1() {

        analizy1 = new Analizy1();
        analizy1.setDatetime(LocalDateTime.now());
        analizy1 = analizy1Repo.save(analizy1);
        label1.add(analizy1.getId() + "");
        label2.add(analizy1.getDatetime().toString());
     //   UI.getCurrent().getPage().reload();
        return analizy1;

    }

    public String updateAnalizy1() {


        //  analizy1.setParametrA( new ParametrA(LocalDateTime.now(),numberField.getValue().doubleValue()));
        //  analizy1.setParametrB(new ParametrB(LocalDateTime.now(),numberField2.getValue().doubleValue()));
        //   analizy1.setParametrC(new ParametrC(LocalDateTime.now(),numberField3.getValue().doubleValue()));

        ParametrA parametrA = new ParametrA(LocalDateTime.now(), numberField.getValue().doubleValue());
        parametrARepo.save(parametrA);
        ParametrB parametrB = new ParametrB(LocalDateTime.now(), numberField2.getValue().doubleValue());
        parametrBRepo.save(parametrB);
        ParametrC parametrC = new ParametrC(LocalDateTime.now(), numberField3.getValue().doubleValue());
        parametrCRepo.save(parametrC);

        analizy1.setParametrA(parametrA);
        analizy1.setParametrB(parametrB);
        analizy1.setParametrC(parametrC);
        analizy1.setUpdateDataTime(LocalDateTime.now());
        String value = comboBox.getValue();
        analizy1.setProducts(productsRepo.findByName(value));
        analizy1Repo.save(analizy1);
        UI.getCurrent().getPage().reload();



        // analizy1Repo.findAllById()
        // Book book = new Book();
        // book.setAuthor(textField.getValue());
        // book.setTitle(textField2.getValue());
        //book.setPrice(numberField.getValue());
        //bookRepo.save(book);
        //textField.clear();
        //textField2.clear();
        //numberField.clear();
        return "added";

    }

}