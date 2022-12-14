package entity;

import java.io.Serializable;

public class User implements Serializable {
    private int userId;
    private String userName;
    private String password;
    private String fullName;
    private boolean permission;
    private boolean userStart;


    public User(){

    }

    public User(int userId, String userName, String password, String fullName, boolean permission, boolean userStart) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.permission = permission;
        this.userStart = userStart;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isPermission() {
        return permission;
    }

    public void setPermission(boolean permission) {
        this.permission = permission;
    }

    public boolean isUserStart() {
        return userStart;
    }

    public void setUserStart(boolean userStart) {
        this.userStart = userStart;
    }
}
