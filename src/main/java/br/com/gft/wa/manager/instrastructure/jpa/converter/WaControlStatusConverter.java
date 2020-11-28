package br.com.gft.wa.manager.instrastructure.jpa.converter;

import br.com.gft.wa.manager.domain.wa.WaControlStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter
public class WaControlStatusConverter implements AttributeConverter<WaControlStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(WaControlStatus waControlStatus) {
        return waControlStatus.code;
    }

    @Override
    public WaControlStatus convertToEntityAttribute(Integer code) {
        return Stream.of(WaControlStatus.values())
                .filter(status -> status.code == code)
                .findFirst()
                .orElse(null);
    }
}
