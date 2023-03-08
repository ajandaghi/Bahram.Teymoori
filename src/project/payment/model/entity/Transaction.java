package project.payment.model.entity;

import com.google.gson.Gson;

import java.time.LocalDateTime;

public class Transaction
{
    private int id;
    private int customerId;
    private LocalDateTime dateTime;
    private String senderCardNumber;
    private String receiverCardNumber;
    private long amount;

    public Transaction() {
    }

    public Transaction(int id, int customerId, LocalDateTime dateTime, String senderCardNumber, String receiverCardNumber, long amount) {
        this.id = id;
        this.customerId = customerId;
        this.dateTime = dateTime;
        this.senderCardNumber = senderCardNumber;
        this.receiverCardNumber = receiverCardNumber;
        this.amount = amount;
    }

    public Transaction(int customerId, String senderCardNumber, String receiverCardNumber, long amount) {
        this.customerId = customerId;
        this.senderCardNumber = senderCardNumber;
        this.receiverCardNumber = receiverCardNumber;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public Transaction setId(int id) {
        this.id = id;
        return this;
    }

    public int getCustomerId() {
        return customerId;
    }

    public Transaction setCustomerId(int customerId) {
        this.customerId = customerId;
        return this;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Transaction setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
        return this;
    }

    public String getSenderCardNumber() {
        return senderCardNumber;
    }

    public Transaction setSenderCardNumber(String senderCardNumber) {
        this.senderCardNumber = senderCardNumber;
        return this;
    }

    public String getReceiverCardNumber() {
        return receiverCardNumber;
    }

    public Transaction setReceiverCardNumber(String receiverCardNumber) {
        this.receiverCardNumber = receiverCardNumber;
        return this;
    }

    public long getAmount() {
        return amount;
    }

    public Transaction setAmount(long amount) {
        this.amount = amount;
        return this;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}