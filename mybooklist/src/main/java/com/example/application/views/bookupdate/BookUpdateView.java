package com.example.application.views.bookupdate;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.MultiSelectComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;
import java.util.ArrayList;
import java.util.List;

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
        setMultiSelectComboBoxSampleData(multiSelectComboBox);
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
        setMultiSelectComboBoxSampleData(multiSelectComboBox2);
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
}
