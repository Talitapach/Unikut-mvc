package Codes.Model;
import java.util.ArrayList;

public class Account {

    private String username;
    private String password;
    private String name;
    private ArrayList<Account> friends = new ArrayList<Account>();
    private ArrayList<Account> friendsRequest = new ArrayList<Account>();
    private ArrayList<String> messagesAccounts = new ArrayList<String>();

    public ArrayList<String> getMessagesAccounts() {
        return messagesAccounts;
    }
    public ArrayList<Account> getFriendsRequest(){
        return this.friendsRequest;
    }
    public ArrayList<Account> getFriends(){
        return this.friends;
    }

    public Account (String username, String password, String name){
        this.username = username;
        this.password = password;
        this.name = name;
    }

    public Account() {
    }
    
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
