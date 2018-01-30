package org.matecomp.sportlife.converter.dto;

import org.springframework.core.convert.converter.Converter;

import java.util.ArrayList;
import java.util.List;
import org.matecomp.sportlife.collection.Authority;
import org.matecomp.sportlife.collection.User;
import org.matecomp.sportlife.dto.UserDTO;

public class UserDTOConverter implements Converter<UserDTO, User> {

    @Override
    public User convert(final UserDTO dto) {
        final User user = new User();

        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setAccountNonExpired(false);
        user.setCredentialsNonExpired(false);
        user.setEnabled(true);

        List<Authority> authorities = new ArrayList<>();
        authorities.add(Authority.ROLE_USER);
        user.setAuthorities(authorities);
        return user;
    }
}
