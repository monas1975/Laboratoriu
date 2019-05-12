package pl.szymanski.laboratory2019.Analizy;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import pl.szymanski.laboratory2019.Products.Products;
import pl.szymanski.laboratory2019.Products.ProductsRepo;

import javax.xml.soap.Name;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Route("addAnalise")
public class Analizy1Gui extends VerticalLayout {


    ProductsRepo productsRepo;


    List<String> elements = new ArrayList<>();
    ComboBox comboBox = new ComboBox("test");


    private Button button1 = new Button("Uworz analize");
    private Label label1 = new Label("nr analizy");
    private Label label2 = new Label("data analizy");
    private NumberField numberField = new NumberField("Parametr A");
    private NumberField numberField2 = new NumberField("Parametr B");
    private NumberField numberField3 = new NumberField("Parametr C");
    final VerticalLayout layout = new VerticalLayout();

    private Button button2 = new Button("Wprowadz wyniki");

    @Autowired
    private Analizy1Gui(ProductsRepo productsRepo) {
        this.productsRepo = productsRepo;
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



        layout.setSizeFull();
        add(layout);

        numberField.setStep(0.01);
        numberField2.setStep(0.01);
        button1.addClickListener(buttonClickEvent -> createAnalizy1());
        button2.addClickListener(buttonClickEvent -> updateAnalizy1());
     //   listBox.setItems(productsRepo.findAll());

        add(comboBox);
        add(numberField);
        add(numberField2);
        add(numberField3);
        add(button2);
    }

    public String createAnalizy1() {

        Analizy1 analizy1 = new Analizy1();
       // analizy1.setDatetime(LocalDateTime.now());
        // book.setAuthor(textField.getValue());
        // book.setTitle(textField2.getValue());
        //book.setPrice(numberFiel.getValue());
        //bookRepo.save(book);
        //textField.clear();
        //textField2.clear();
        //numberField.clear();
        return "added";

    }

    public String updateAnalizy1() {

        Analizy1 analizy1 = new Analizy1();
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