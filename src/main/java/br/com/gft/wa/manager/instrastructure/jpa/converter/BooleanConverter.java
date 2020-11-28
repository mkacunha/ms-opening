package br.com.gft.wa.manager.instrastructure.jpa.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class BooleanConverter implements AttributeConverter<Boolean, String> {
    @Override
    public String convertToDatabaseColumn(Boolean value) {
        return value ? "S" : "N";
    }

    @Override
    public Boolean convertToEntityAttribute(String value) {
        return "S".equals(value) ? true : false;
    }
}
