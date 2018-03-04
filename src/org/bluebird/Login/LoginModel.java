package org.bluebird.Login;

class LoginModel {

    boolean usernameIsEmpty(String username) {
        return username.isEmpty();
    }

    boolean isEqual(String user1, String user2) {
        return user1.equals(user2);
    }
}
