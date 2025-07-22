public class UserInfo {
    private String name;
    private int age;
    private String email;
    private boolean isActive;

    //constructor
public UserInfo(String name,int age, String email, boolean isActive ){
    this.name=name;
    this.age=age;
    this.email=email;
    this.isActive=isActive;
}

    public String getName() {
        return name;
    }
    public int getAge(){
    return age;
    }
    public String getEmail(){
    return email;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void setIsActive(boolean isActive){
    this.isActive=isActive;
    }
// display menu
    public void displayInfo(){
    System.out.println("----User Info----");
        System.out.println("Name:"+ " "+ name);
        System.out.println("Age:"+ " "+ age);
        System.out.println("Email:"+ " "+ email);
        System.out.println("Active:"+ " "+ (isActive?"Yes" : "No"));
    }
    // create  3 usernames for testing
    public static void main(String[] args){
    UserInfo user1= new UserInfo("Sara",22,"sarsar@example.com", true);
    UserInfo user2= new UserInfo("Ahmed",22,"ahmed@example.com", true);
    UserInfo user3= new UserInfo("Aala",22,"aaa@example.com", false);

user1.displayInfo(); //display the user info
user2.displayInfo();
user3.displayInfo();
 //test getters

        user1.setEmail("saraa@gmail.com");
        System.out.println("Updated Email for " + user1.getName() + ": " + user1.getEmail());

    }
}
