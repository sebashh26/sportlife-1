package org.matecomp.sportlife.exception.model;

public class UserNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -3928880958352209319L;

    public UserNotFoundException() {
        super();
    }

    public UserNotFoundException(final String message) {
        super(message);
    }

    public UserNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
