package application;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Player {
    private SimpleStringProperty name;
    private SimpleStringProperty country; 
    private SimpleStringProperty position;
    private SimpleIntegerProperty age;
    private SimpleIntegerProperty number;
    private SimpleDoubleProperty height;
    private SimpleDoubleProperty weeklySalary;
    private SimpleStringProperty playerClub;
    
    public Player() {
    	this.name = new SimpleStringProperty();
    	this.country = new SimpleStringProperty();
    	this.position = new SimpleStringProperty();
    	this.playerClub = new SimpleStringProperty();
    	this.age = new SimpleIntegerProperty();
    	this.number = new SimpleIntegerProperty();
    	this.height = new SimpleDoubleProperty();
    	this.weeklySalary = new SimpleDoubleProperty();
	}
    
    public Player(String name, String country, String position, String playerClub, Integer age, Integer number, Double height, Double weeklySalary) {
    	this.name = new SimpleStringProperty(name);
    	this.country = new SimpleStringProperty(country);
    	this.position = new SimpleStringProperty(position);
    	this.playerClub = new SimpleStringProperty(playerClub);
    	this.age = new SimpleIntegerProperty(age);
    	this.number = new SimpleIntegerProperty(number);
    	this.height = new SimpleDoubleProperty(height);
    	this.weeklySalary = new SimpleDoubleProperty(weeklySalary);
    }
    
	public String getName() { return name.get(); }
    public void setName(String name) { this.name.set(name); }

    public String getCountry() { return country.get(); }
    public void setCountry(String country) { this.country.set(country); }

    public String getPosition() { return position.get(); }
    public void setPosition(String position) { this.position.set(position); }

    public int getAge() { return age.get(); }
    public void setAge(int age) { this.age.set(age); }

    public int getNumber() { return number.get(); }
    public void setNumber(int number) { this.number.set(number); }

    public double getHeight() { return height.get(); }
    public void setHeight(double height) { this.height.set(height); }

    public double getWeeklySalary() { return weeklySalary.get(); }
    public void setWeeklySalary(double weeklySalary) { this.weeklySalary.set(weeklySalary);; }

    public String getPlayerClub() { return playerClub.get(); }
    public void setPlayerClub(String playerClub) { this.playerClub.set(playerClub); }

    public void displayPlayer() {
        System.out.println("Name: " + name + "\n" +
                "Country: " + country + "\n" +
                "Age: " + age + "\n" +
                "Height: " + height + "\n" +
                "Club: " + playerClub + "\n" +
                "Position: " + position + "\n" +
                "Number: " + number + "\n" +
                "Weekly Salary: " + weeklySalary + "\n");
    }
}
