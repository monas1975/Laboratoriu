package pl.szymanski.laboratory2019.Parameters.ParameterA;

import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.*;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.szymanski.laboratory2019.Analizy.Analizy1Gui;
import pl.szymanski.laboratory2019.Products.Products;

import java.util.ArrayList;
import java.util.List;

@Route("showValuesOfParameterA2")
public class ParametrAGui extends VerticalLayout {

    ParametrARepo parametrARepo;



    private Grid<ParametrA> grid = new Grid<>(ParametrA.class);
    private Chart chart= new Chart(ChartType.LINE);
    Configuration conf = chart.getConfiguration();
    PlotOptionsLine plotOptions = new PlotOptionsLine();
    ListSeries series = new ListSeries("Parametr A [%]");
    DataSeries dataSeries= new DataSeries();




    final HorizontalLayout layout = new HorizontalLayout();

    @Autowired
    private ParametrAGui(ParametrARepo parametrARepo){
        this.parametrARepo = parametrARepo;

        Iterable<ParametrA> all = parametrARepo.findAll();
        List<ParametrA> parametrAS = new ArrayList<>();
        List<Double> parametrASNumbers = new ArrayList<>();
        dataSeries.setName("Total Reindeer Population");
        for (ParametrA parametrA : all) {
            parametrAS.add(parametrA);
            System.out.println(parametrA.getDatatime() + "   " + parametrA.getValue());
            System.out.println("to string  " + parametrA.getDatatime().toString() + "   " + parametrA.getValue().toString());
            dataSeries.add(new DataSeriesItem(parametrA.getDatatime().toString(),parametrA.getValue()));
        }
        grid.setItems(parametrAS);

        chart.setTimeline(true);
        conf.setTitle("Parmetr A");
        conf.setSubTitle("Wartosci");
        conf.addSeries(dataSeries);
       // series.setData(parametrASNumbers);


        plotOptions.setMarker(new Marker(false));
        conf.setPlotOptions(plotOptions);

        layout.setSizeFull();
        add(layout);
        add(grid);
        add(chart);

    }
}
