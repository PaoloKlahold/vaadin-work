package com.example.application.views.booksearch;


import com.example.application.data.entity.Books;
import com.example.application.data.entity.SamplePerson;
import com.example.application.data.service.SamplePersonService;
import com.example.application.views.MainLayout;
import com.example.application.views.booksearch.BookSearchView.SampleItem;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.MultiSelectComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.data.VaadinSpringDataHelpers;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;



@PageTitle("Book Search")
@Route(value = "Book-Search", layout = MainLayout.class)
@Uses(Icon.class)
public class BookSearchView extends Composite<VerticalLayout> {

    public BookSearchView() {
        HorizontalLayout layoutRow = new HorizontalLayout();
        TextField textField = new TextField();
        TextField textField2 = new TextField();
        MultiSelectComboBox multiSelectComboBox = new MultiSelectComboBox();
        MultiSelectComboBox multiSelectComboBox2 = new MultiSelectComboBox();
        DatePicker datePicker = new DatePicker();
        DatePicker datePicker2 = new DatePicker();
        HorizontalLayout layoutRow2 = new HorizontalLayout();
        Checkbox checkbox = new Checkbox();
        Button buttonPrimary = new Button();
        Grid minimalistGrid = new Grid(SamplePerson.class);
        getContent().setHeightFull();
        getContent().setWidthFull();
        getContent().addClassName(Gap.XSMALL);
        getContent().addClassName(Padding.XSMALL);
        layoutRow.setWidthFull();
        layoutRow.addClassName(Gap.MEDIUM);
        

        textField.setLabel("Name");
        layoutRow.setAlignSelf(FlexComponent.Alignment.CENTER, textField);

        textField2.setLabel("Autor");
        layoutRow.setAlignSelf(FlexComponent.Alignment.CENTER, textField2);

        multiSelectComboBox.setLabel("Genre");
        layoutRow.setAlignSelf(FlexComponent.Alignment.CENTER, multiSelectComboBox);
        setMultiSelectComboBoxSampleDataGenre(multiSelectComboBox);

        multiSelectComboBox2.setLabel("Theme");
        layoutRow.setAlignSelf(FlexComponent.Alignment.CENTER, multiSelectComboBox2);
        setMultiSelectComboBoxSampleDataTheme(multiSelectComboBox2);

        datePicker.setLabel("Started after");
        layoutRow.setAlignSelf(FlexComponent.Alignment.CENTER, datePicker);

        datePicker2.setLabel("Finished before");
        layoutRow.setAlignSelf(FlexComponent.Alignment.CENTER, datePicker2);

        layoutRow2.setWidthFull();
        layoutRow2.addClassName(Gap.MEDIUM);

        checkbox.setLabel("Favorite");
        layoutRow2.setAlignSelf(FlexComponent.Alignment.CENTER, checkbox);

        buttonPrimary.setText("Search");
        layoutRow2.setAlignSelf(FlexComponent.Alignment.CENTER, buttonPrimary);
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);


        minimalistGrid.addThemeVariants(
            GridVariant.LUMO_COMPACT, 
            GridVariant.LUMO_NO_BORDER,
            GridVariant.LUMO_NO_ROW_BORDERS);

        //Adiciona os dados ao grid
        setGridSampleData(minimalistGrid);
        //

        Grid<Books> gridCostumized = new Grid<>(Books.class, false);
        gridCostumized.addColumn(Books::getBookName).setHeader("Name");
        gridCostumized.addColumn(Books::getAutorName).setHeader("Autor");
        gridCostumized.addColumn(Books::getGenre).setHeader("Genre");
        gridCostumized.addColumn(Books::getTheme).setHeader("Theme");

        List<Books> books = getBooksFromDatabase();
        gridCostumized.setItems(books);
  
        getContent().add(layoutRow);
        layoutRow.add(textField);
        layoutRow.add(textField2);
        layoutRow.add(multiSelectComboBox);
        layoutRow.add(multiSelectComboBox2);
        layoutRow.add(datePicker);
        layoutRow.add(datePicker2);
        getContent().add(layoutRow2);
        layoutRow2.add(checkbox);
        layoutRow2.add(buttonPrimary);

        //onde coloca a grid que via ser usada
        getContent().add(gridCostumized);
    }


// -- Começo para funcionar a Combobox
    record SampleItem(String value, String label, Boolean disabled) {
    }

    private void setMultiSelectComboBoxSampleDataGenre(MultiSelectComboBox multiSelectComboBoxGenre) {
        List<SampleItem> sampleItemsGenre = new ArrayList<>();
        sampleItemsGenre.add(new SampleItem("action", "Action", null));
        sampleItemsGenre.add(new SampleItem("adventure", "Adventure", null));
        sampleItemsGenre.add(new SampleItem("comedy", "Comedy", null));
        sampleItemsGenre.add(new SampleItem("drama", "Drama", null));
        sampleItemsGenre.add(new SampleItem("fantasy", "Fantasy", null));
        sampleItemsGenre.add(new SampleItem("mystery", "Mystery", null));
        sampleItemsGenre.add(new SampleItem("Romance", "Romance", null));
        sampleItemsGenre.add(new SampleItem("scifi", "Sci-Fi", null));
        sampleItemsGenre.add(new SampleItem("sports", "Sports", null));
        sampleItemsGenre.add(new SampleItem("suspense", "Suspense", null));
        multiSelectComboBoxGenre.setItems(sampleItemsGenre);
        multiSelectComboBoxGenre.setItemLabelGenerator(item -> ((SampleItem) item).label());
    }

    private void setMultiSelectComboBoxSampleDataTheme(MultiSelectComboBox multiSelectComboBoxTheme) {
        List<SampleItem> sampleItemsTheme = new ArrayList<>();
        sampleItemsTheme.add(new SampleItem("educational", "Educational", null));
        sampleItemsTheme.add(new SampleItem("historical", "Historical", null));
        sampleItemsTheme.add(new SampleItem("martialarts", "Martial Arts", null));
        sampleItemsTheme.add(new SampleItem("military", "Military", null));
        sampleItemsTheme.add(new SampleItem("music", "Music", null));
        sampleItemsTheme.add(new SampleItem("psychological", "Psychological", null));
        sampleItemsTheme.add(new SampleItem("space", "Space", null));
        multiSelectComboBoxTheme.setItems(sampleItemsTheme);
        multiSelectComboBoxTheme.setItemLabelGenerator(item -> ((SampleItem) item).label());
    }

// -- Fim para funcionar a Combobox

    private void setGridSampleData(Grid grid) {
        grid.setItems(query -> samplePersonService.list(
                PageRequest.of(query.getPage(), query.getPageSize(), VaadinSpringDataHelpers.toSpringDataSort(query)))
                .stream());
    }

    @Autowired()
    private SamplePersonService samplePersonService;


    private List<Books> getBooksFromDatabase() {
        List<Books> books = new ArrayList<>();
        try {
            
            // Estabelecer uma conexão com o banco de dados MySQL
            Connection connection = DriverManager.getConnection("jdbc:mysql://seu_host/seu_banco_de_dados", "seu_usuario", "sua_senha");

            // Preparar a consulta SQL
            String query = "SELECT * FROM sua_tabela";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // Executar a consulta
            ResultSet resultSet = preparedStatement.executeQuery();

            // Processar os resultados
            while (resultSet.next()) {
                Books book = new Books();
                book.setBookName(resultSet.getString("book_name"));
                book.setAutorName(resultSet.getString("autor_name"));
                book.setGenre(resultSet.getString("genre"));
                book.setTheme(resultSet.getString("theme"));
                books.add(book);
            }

            // Fechar recursos
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }


}
