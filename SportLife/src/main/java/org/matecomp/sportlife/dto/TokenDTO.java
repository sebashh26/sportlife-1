package org.matecomp.sportlife.dto;

import java.io.Serializable;

public class TokenDTO implements Serializable {

    private static final long serialVersionUID = 2278361717695993868L;

    private String token;

    public TokenDTO() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(final String token) {
        this.token = token;
    }
}
