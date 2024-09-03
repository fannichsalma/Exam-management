package com.ensah.core.config;


import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomDateEditor extends PropertyEditorSupport {

    private SimpleDateFormat dateFormat;

    public CustomDateEditor(String pattern) {
        this.dateFormat = new SimpleDateFormat(pattern);
        this.dateFormat.setLenient(false);
    }



    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
            setValue(dateFormat.parse(text));
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid date format. Please use the correct format.");
        }
    }

    @Override
    public String getAsText() {
        return dateFormat.format((Date) getValue());
    }
}