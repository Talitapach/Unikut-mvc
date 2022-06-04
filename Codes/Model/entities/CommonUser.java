package Codes.Model.entities;

public class CommonUser implements Builder {
  private String name;
  private String userName;
  private String password;
  

  public CommonUser(String name, String userName, String password) {
    this.name = name;
    this.userName = userName;
    this.password = password;
   }


  @Override
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public void setUserName(String userName) {
    this.userName = userName;
  }

  @Override
  public void setPassword(String password) {
    this.password = password;
  }

  public Common getResult() {
    return new Common(name, userName, password, false);
  }
}
