/*
 * Copyright 2018 Pivotal Software, Inc..
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.matecomp.sportlife.controller;

import java.util.List;
import org.matecomp.sportlife.collection.User;
import org.matecomp.sportlife.repository.UserRepository;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UserRepository userRepository;

    public UsuarioController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(method = GET)
    public List<User> list() {
        return this.userRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = GET)
    public Object get(@PathVariable String id) {
        return this.userRepository.findOne(id);
    }

    @RequestMapping(method = PUT)
    public ResponseEntity<User> put(@RequestBody User collection) {
        return new ResponseEntity(this.userRepository.insert(collection), HttpStatus.CREATED);
    }

    @RequestMapping(method = POST)
    public ResponseEntity<User> post(@RequestBody User collection) {
        return new ResponseEntity(this.userRepository.save(collection), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = DELETE)
    public void delete(@PathVariable String id) {
        User usuario = this.userRepository.findByUsername(id);
        this.userRepository.delete(usuario);
    }

}
