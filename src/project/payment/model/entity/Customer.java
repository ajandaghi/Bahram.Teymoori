package project.payment.model.entity;

import com.google.gson.Gson;

public class Customer
{
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String cardNumber;
    private long balance;

    public Customer() {
    }

    public Customer(int id, String firstName, String lastName, int age, String cardNumber, long balance) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.cardNumber = cardNumber;
        this.balance = balance;
    }

    public Customer(String firstName, String lastName, int age, String cardNumber, long balance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.cardNumber = cardNumber;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public Customer setId(int id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Customer setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Customer setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Customer setAge(int age) {
        this.age = age;
        return this;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public Customer setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
        return this;
    }

    public long getBalance() {
        return balance;
    }

    public Customer setBalance(long balance) {
        this.balance = balance;
        return this;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}