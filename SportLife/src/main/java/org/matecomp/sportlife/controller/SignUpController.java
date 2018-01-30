package org.matecomp.sportlife.controller;

import org.matecomp.sportlife.converter.ConverterFacade;
import org.matecomp.sportlife.dto.UserDTO;
import org.matecomp.sportlife.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/signup")
public class SignUpController {

    private final UserRepository userRepository;

    private final ConverterFacade converterFacade;

    @Autowired
    public SignUpController(final UserRepository userRepository,
            final ConverterFacade converterFacade) {
        this.userRepository = userRepository;
        this.converterFacade = converterFacade;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> signUp(@RequestBody final UserDTO dto) {
        return new ResponseEntity<>(userRepository.insert(converterFacade.convert(dto)), HttpStatus.OK);
    }
}
