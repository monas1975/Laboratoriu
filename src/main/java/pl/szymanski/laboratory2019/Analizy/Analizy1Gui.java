package pl.szymanski.laboratory2019.Analizy;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.router.Route;
import javafx.scene.control.ComboBox;
import org.springframework.beans.factory.annotation.Autowired;
import pl.szymanski.laboratory2019.Products.Products;
import pl.szymanski.laboratory2019.Products.ProductsRepo;

import java.util.ArrayList;
import java.util.List;

@Route("addAnalise")
public class Analizy1Gui extends HorizontalLayout {

    @Autowired
    ProductsRepo productsRepo;

    ListBox<Object> listBox = new ListBox<>();


    private NumberField numberField = new NumberField("Parametr A");
    private NumberField numberField2 = new NumberField("Parametr B");
    private NumberField numberField3 = new NumberField("Parametr C");
    final HorizontalLayout layout = new HorizontalLayout();

    private Button button = new Button("Wprowadz wyniki");

    private Analizy1Gui() {


        layout.setSizeFull();
        add(layout);

        numberField.setStep(0.01);
        numberField2.setStep(0.01);
        button.addClickListener(buttonClickEvent -> addAnalizy1());
        listBox.setItems(productsRepo.findAll());
        add(numberField);
        add(numberField2);
        add(numberField3);
        add(button);
    }

    public String addAnalizy1() {

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