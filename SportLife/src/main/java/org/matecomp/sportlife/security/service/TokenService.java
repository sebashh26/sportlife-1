package org.matecomp.sportlife.security.service;

public interface TokenService {

    String getToken(String username, String password);
}
