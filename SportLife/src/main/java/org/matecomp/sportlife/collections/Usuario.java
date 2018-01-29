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
package org.matecomp.sportlife.collections;

import java.io.Serializable;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Usuario")
public class Usuario extends DefaultDocument implements Serializable {

    private static final long serialVersionUID = -5435721305545342037L;

    @Indexed(name = "IndxUsuarioCodigo", unique = true, direction = IndexDirection.ASCENDING)
    private String codigoUsuario;
    private String nombres;
    private String apellidos;

    public Usuario() {
        super();
    }

    public Usuario(String codigoUsuario) {
        super();
        this.codigoUsuario = codigoUsuario;

    }

    public Usuario(String codigoUsuario, String nombres, String apellidos) {
        super();
        this.codigoUsuario = codigoUsuario;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public String getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Override
    public String toString() {
        return "Usuario[codigoUsuario=" + codigoUsuario + "]";
    }

}
