package com.example.application.views.bookupdate;

import com.example.application.data.service.SamplePersonService;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.MultiSelectComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.data.VaadinSpringDataHelpers;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

@PageTitle("Book Update")
@Route(value = "Book-Update", layout = MainLayout.class)
@Uses(Icon.class)
public class BookUpdateView extends Composite<VerticalLayout> {

    public BookUpdateView() {
        HorizontalLayout layoutRow = new HorizontalLayout();
        VerticalLayout layoutColumn5 = new VerticalLayout();
        VerticalLayout layoutColumn2 = new VerticalLayout();
        H3 h3 = new H3();
        HorizontalLayout layoutRow2 = new HorizontalLayout();
        VerticalLayout layoutColumn3 = new VerticalLayout();
        TextField textField = new TextField();
        MultiSelectComboBox multiSelectComboBox = new MultiSelectComboBox();
        DatePicker datePicker = new DatePicker();
        Checkbox checkbox = new Checkbox();
        VerticalLayout layoutColumn4 = new VerticalLayout();
        HorizontalLayout layoutRow3 = new HorizontalLayout();
        TextField textField2 = new TextField();
        MultiSelectComboBox multiSelectComboBox2 = new MultiSelectComboBox();
        DatePicker datePicker2 = new DatePicker();
        HorizontalLayout layoutRow4 = new HorizontalLayout();
        Button buttonPrimary = new Button();
        Button buttonPrimary2 = new Button();
        Button buttonSecondary = new Button();
        VerticalLayout layoutColumn6 = new VerticalLayout();
        getContent().setWidthFull();
        getContent().addClassName(Padding.LARGE);
        layoutRow.setWidthFull();
        layoutRow.setFlexGrow(1.0, layoutColumn5);
        layoutColumn5.setWidth(null);
        layoutRow.setFlexGrow(1.0, layoutColumn2);
        layoutColumn2.setWidth(null);
        h3.setText("Book Update or Delete");
        layoutRow2.setWidthFull();
        layoutRow2.addClassName(Gap.LARGE);
        layoutRow2.setFlexGrow(1.0, layoutColumn3);
        layoutColumn3.setWidth(null);
        textField.setLabel("Name");
        textField.setWidthFull();
        multiSelectComboBox.setLabel("Genre");
        multiSelectComboBox.setWidthFull();
        setMultiSelectComboBoxSampleDataGenre(multiSelectComboBox);
        datePicker.setLabel("Start date");
        datePicker.setWidthFull();
        checkbox.setLabel("Favorite");
        layoutRow2.setFlexGrow(1.0, layoutColumn4);
        layoutColumn4.setWidth(null);
        layoutRow3.addClassName(Gap.MEDIUM);
        layoutRow3.setWidthFull();
        textField2.setLabel("Autor");
        layoutRow3.setFlexGrow(1.0, textField2);
        multiSelectComboBox2.setLabel("Theme");
        multiSelectComboBox2.setWidthFull();
        setMultiSelectComboBoxSampleDataTheme(multiSelectComboBox2);
        datePicker2.setLabel("Finish date");
        datePicker2.setWidthFull();
        layoutRow4.addClassName(Gap.MEDIUM);
        buttonPrimary.setText("Update");
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonPrimary2.setText("Delete");
        buttonPrimary2.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonSecondary.setText("Cancel");
        layoutRow.setFlexGrow(1.0, layoutColumn6);
        layoutColumn6.setWidth(null);
        getContent().add(layoutRow);
        layoutRow.add(layoutColumn5);
        layoutRow.add(layoutColumn2);
        layoutColumn2.add(h3);
        layoutColumn2.add(layoutRow2);
        layoutRow2.add(layoutColumn3);
        layoutColumn3.add(textField);
        layoutColumn3.add(multiSelectComboBox);
        layoutColumn3.add(datePicker);
        layoutColumn3.add(checkbox);
        layoutRow2.add(layoutColumn4);
        layoutColumn4.add(layoutRow3);
        layoutRow3.add(textField2);
        layoutColumn4.add(multiSelectComboBox2);
        layoutColumn4.add(datePicker2);
        layoutColumn2.add(layoutRow4);
        layoutRow4.add(buttonPrimary);
        layoutRow4.add(buttonPrimary2);
        layoutRow4.add(buttonSecondary);
        layoutRow.add(layoutColumn6);
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



    private void setGridSampleData(Grid grid) {
        grid.setItems(query -> samplePersonService.list(
                PageRequest.of(query.getPage(), query.getPageSize(), VaadinSpringDataHelpers.toSpringDataSort(query)))
                .stream());
    }

    @Autowired()
    private SamplePersonService samplePersonService;

// -- Fim para funcionar a Combobox
}
