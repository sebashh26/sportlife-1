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
package org.matecomp.sportlife.controllers;

import java.util.List;
import org.matecomp.sportlife.collections.Usuario;
import org.matecomp.sportlife.repositories.UsuarioRepository;
import org.springframework.data.domain.Example;
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

    private final UsuarioRepository repository;

    public UsuarioController(UsuarioRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = GET)
    public List<Usuario> list() {
        return this.repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = GET)
    public Object get(@PathVariable String id) {
        return this.repository.findOne(id);
    }

    @RequestMapping(method = PUT)
    public ResponseEntity<Usuario> put(@RequestBody Usuario collection) {
        return new ResponseEntity(this.repository.insert(collection), HttpStatus.CREATED);
    }

    @RequestMapping(method = POST)
    public ResponseEntity<Usuario> post(@RequestBody Usuario collection) {
        return new ResponseEntity(this.repository.save(collection), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = DELETE)
    public void delete(@PathVariable String id) {
        Usuario usuario = this.repository.findByUserName(id);
        this.repository.delete(usuario);
    }

}
