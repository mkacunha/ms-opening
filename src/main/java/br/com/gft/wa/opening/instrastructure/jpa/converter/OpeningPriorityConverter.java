package br.com.gft.wa.opening.instrastructure.jpa.converter;

import br.com.gft.wa.opening.domain.opening.OpeningPriority;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter
public class OpeningPriorityConverter implements AttributeConverter<OpeningPriority, Integer> {

    @Override
    public Integer convertToDatabaseColumn(OpeningPriority openingPriority) {
        return openingPriority.code;
    }

    @Override
    public OpeningPriority convertToEntityAttribute(Integer value) {
        return Stream.of(OpeningPriority.values())
                .filter(priority -> priority.code == value)
                .findFirst()
                .orElse(null);
    }
}
