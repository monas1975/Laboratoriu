package pl.szymanski.laboratory2019.Products;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.*;

@StyleSheet("static/style.css")
@Route("addProduct")
public class ProductsGui<style, html> extends VerticalLayout {

    @Autowired
    private ProductsRepo productsRepo;

    private TextField textField1 = new TextField("podaj nazwe produktu");
    private TextArea textArea = new TextArea("Opis produktu");
    private Button button = new Button("Dodaj produkt");
    private VerticalLayout layout = new VerticalLayout();

    public ProductsGui(){

        UI.getCurrent().getPage().addStyleSheet("static/style.css");
        layout.setSizeFull();
        add(layout);
        add(textField1);
        add(textArea);
        add(button);
        button.addClickListener(buttonClickEvent -> addProduct());
    }

     public String addProduct(){
        Products products = new Products();
        products.setName(textField1.getValue());
        products.setDescribtion(textArea.getValue());
        productsRepo.save(products);
        textField1.clear();
        textArea.clear();
        return "added";
     }


}
