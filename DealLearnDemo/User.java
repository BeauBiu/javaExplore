package DealLearnDemo;

import java.io.Serializable;

public class User implements Serializable {
    private String Username;
    private String Password;
    private String Idcard;
    private int Birthday;
    private String Address;

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getIdcard() {
        return Idcard;
    }

    public void setIdcard(String idcard) {
        Idcard = idcard;
    }

    public int getBirthday() {
        return Birthday;
    }

    public void setBirthday(int birthday) {
        Birthday = birthday;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "Username='" + Username + '\'' +
                ", Password='" + Password + '\'' +
                ", Idcard='" + Idcard + '\'' +
                ", Birthday=" + Birthday +
                ", Address='" + Address + '\'' +
                '}';
    }
}
