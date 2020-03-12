package edu.utcn.gpsm.position.security;

public class AuthRequest {
    private  String username;
    private  String password;
    public AuthRequest(){}


    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}
