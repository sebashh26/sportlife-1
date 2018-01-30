package org.matecomp.sportlife.converter;

import org.matecomp.sportlife.collection.User;
import org.matecomp.sportlife.converter.factory.ConverterFactory;
import org.matecomp.sportlife.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConverterFacade {

    @Autowired
    private ConverterFactory converterFactory;

    public User convert(final UserDTO dto) {
        return (User) converterFactory.getConverter(dto.getClass()).convert(dto);
    }
}
