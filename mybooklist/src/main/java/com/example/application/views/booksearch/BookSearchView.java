package com.example.application.views.booksearch;

import com.example.application.data.entity.SamplePerson;
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
        setMultiSelectComboBoxSampleData(multiSelectComboBox);
        multiSelectComboBox2.setLabel("Theme");
        layoutRow.setAlignSelf(FlexComponent.Alignment.CENTER, multiSelectComboBox2);
        setMultiSelectComboBoxSampleData(multiSelectComboBox2);
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
        minimalistGrid.addThemeVariants(GridVariant.LUMO_COMPACT, GridVariant.LUMO_NO_BORDER,
                GridVariant.LUMO_NO_ROW_BORDERS);
        setGridSampleData(minimalistGrid);
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
        getContent().add(minimalistGrid);
    }

    record SampleItem(String value, String label, Boolean disabled) {
    }

    private void setMultiSelectComboBoxSampleData(MultiSelectComboBox multiSelectComboBox) {
        List<SampleItem> sampleItems = new ArrayList<>();
        sampleItems.add(new SampleItem("first", "First", null));
        sampleItems.add(new SampleItem("second", "Second", null));
        sampleItems.add(new SampleItem("third", "Third", Boolean.TRUE));
        sampleItems.add(new SampleItem("fourth", "Fourth", null));
        multiSelectComboBox.setItems(sampleItems);
        multiSelectComboBox.setItemLabelGenerator(item -> ((SampleItem) item).label());
    }

    private void setGridSampleData(Grid grid) {
        grid.setItems(query -> samplePersonService.list(
                PageRequest.of(query.getPage(), query.getPageSize(), VaadinSpringDataHelpers.toSpringDataSort(query)))
                .stream());
    }

    @Autowired()
    private SamplePersonService samplePersonService;
}
