package com.vaadin.starter.skeleton.components;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.MultiSelectComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.validator.DateRangeValidator;
import com.vaadin.flow.data.validator.EmailValidator;
import com.vaadin.flow.data.validator.StringLengthValidator;
import com.vaadin.starter.skeleton.models.Person;
import com.vaadin.starter.skeleton.services.DataBinding;
import com.vaadin.starter.skeleton.services.HobbyService;

import java.time.LocalDate;

public class MainFormLayout extends FormLayout {

    private FormLayout form;

    public FormLayout getForm() {
        return form;
    }

    public MainFormLayout(DataBinding dataBinding, Runnable afterSaveAction){
        form = new FormLayout();

        addFormFieldsWithBinding(dataBinding);
        addFormButtons(dataBinding, afterSaveAction);
    }

    public void addFormFieldsWithBinding(DataBinding dataBinding){
        TextField field_name = new TextField("First name");
        dataBinding.getBinder().forField(field_name)
            .asRequired("El nombre es obligatorio")
            .withValidator(new StringLengthValidator("El nombre debe tener máximo 10 caracteres", 0, 10))
            .bind(Person::getFirstName, Person::setFirstName);

        DatePicker field_date = new DatePicker("Birthday date");
        dataBinding.getBinder().forField(field_date)
            .asRequired("La fecha de nacimiento es obligatoria")
            .withValidator(new DateRangeValidator("La fecha no debe ser posterior a la fecha de hoy", LocalDate.MIN, LocalDate.now()))
            .bind(Person::getBirthday, Person::setBirthday);

        EmailField field_email = new EmailField("Email address");
        dataBinding.getBinder().forField(field_email)
            .asRequired("El email es obligatorio")
            .withValidator(new EmailValidator("El email debe tener un formato válido"))
            .bind(Person::getEmail, Person::setEmail);

        MultiSelectComboBox<String> field_hobbies = new MultiSelectComboBox<>(
            "Hobbies");
        field_hobbies.setItems(HobbyService.getHobbies());
        dataBinding.getBinder().forField(field_hobbies).bind(Person::getHobbies, Person::setHobbies);

        form.add(field_name, field_date, field_email, field_hobbies);
    }

    public void addFormButtons(DataBinding dataBinding, Runnable afterSaveAction){
        HorizontalLayout horizontalLayout = new HorizontalLayout();

        Button saveButton = new Button("Save",
            event -> {
            dataBinding.saveNewOrEdit(afterSaveAction);
            });
        saveButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        saveButton.addClickShortcut(Key.ENTER);

        Button removeButton = new Button("Remove",
            event -> dataBinding.delete(afterSaveAction));
        removeButton.addThemeVariants(ButtonVariant.LUMO_ERROR);
        removeButton.addClickShortcut(Key.ENTER);

        horizontalLayout.add(saveButton, removeButton);

        form.add(horizontalLayout);
    }
}
