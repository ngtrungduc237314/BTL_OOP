package com.hotelmanagement.common.session;

import com.hotelmanagement.domain.entity.User;

public final class SessionManager {
    private static final SessionManager INSTANCE = new SessionManager();

    private User currentUser;

    private SessionManager() {}

    public static SessionManager getInstance() {
        return INSTANCE;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User user) {
        this.currentUser = user;
    }

    public void clear() {
        this.currentUser = null;
    }
}
