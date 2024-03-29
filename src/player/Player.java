package player;

public class Player {

    private String name;
    private char playerSymbol;
    private String address;
    private String contactNumber;
    private String emailId;
    private int age;

    public void setPlayerDetails(String name, char symbol, String addr, String number, String email, int age) {
        this.name = name;
        this.playerSymbol = symbol;
        this.address = addr;
        this.contactNumber = number;
        this.emailId = email;
        this.age = age;
    }

    public void setPlayerNameAndSymbol(String name, char symbol) {
        this.name = name;
        this.playerSymbol = symbol;
    }

    public String getPlayerName() {
        return this.name;
    }

    public char getPlayerSymbol() {
        return this.playerSymbol;
    }

    public void changeSymbol(char symbol) {
        this.playerSymbol = symbol;
    }

    public void getPlayerDetails() {
        System.out.println("Player Name: " + this.name);
        System.out.println("Player Symbol: " + this.playerSymbol);
        System.out.println("Player Address: " + this.address);
        System.out.println("Player Age: " + this.age);
        System.out.println("Player Number: " + this.contactNumber);
        System.out.println("Player Email: " + this.emailId);

    }

}
