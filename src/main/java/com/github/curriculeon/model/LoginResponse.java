package com.github.curriculeon.model;

/** This class represents the response sent by the server to the Ajax request. It has two fields: success and user.
 * The success field indicates whether the login was successful or not, and the user field contains the user object
 * if the login was successful.
 *
 */

public class LoginResponse {
    private boolean success;
    private User user;

    public LoginResponse(boolean success, User user) {
        this.success = success;
        this.user = user;
    }

    public boolean isSuccess() {
        return success;
    }

    public User getUser() {
        return user;
    }
}

