package week7.models;
public class User {
    
    private String name;
    private String lastName;
    private String username;
    private String password;
    
    public User(String name, String lastName, String username, String password){
        this.username = username;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
    }
    
    public String getName(){
        return name;
    }
    
    public String getLastName(){
        return lastName;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public String getFullName(){
        return getName() + " " + getLastName();
    }
}
