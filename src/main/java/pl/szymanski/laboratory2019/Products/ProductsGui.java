package pl.szymanski.laboratory2019.Products;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@StyleSheet("static/css/styles.css")
//@StyleSheet("http://www.example.com/example.css")
@Route("addProduct")
public class ProductsGui<style, html> extends VerticalLayout {

 //   @Autowired
    private ProductsRepo productsRepo;

    private TextField textField1 = new TextField("podaj nazwe produktu");
    private TextArea textArea = new TextArea("Opis produktu");
    private Button button = new Button("Dodaj produkt");
    private Grid<Products> grid = new Grid<>(Products.class);
    private VerticalLayout layout = new VerticalLayout();


    @Autowired
    public ProductsGui(ProductsRepo productsRepo){
        this.productsRepo = productsRepo;


        Iterable<Products> all = productsRepo.findAll();
        List<Products> productsList = new ArrayList<>();
        for (Products products : all) {
            productsList.add(products);
        }
        grid.setItems(productsList);


       // UI.getCurrent().getPage().addStyleSheet("public/css/styles.css");
        layout.setSizeFull();

        add(layout);
        add(textField1);
        add(textArea);
        add(button);
        button.addClickListener(buttonClickEvent -> addProduct());
        add(grid);
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
