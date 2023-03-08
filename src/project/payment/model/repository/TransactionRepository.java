package project.payment.model.repository;

import project.payment.jdbc.Jdbc;
import project.payment.model.entity.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TransactionRepository implements AutoCloseable
{
    private Connection connection;
    private PreparedStatement statement;

    public TransactionRepository() throws Exception
    {
        connection = Jdbc.getConnection();
    }

    public Transaction add(Transaction transaction) throws Exception
    {
        statement = connection.prepareStatement("SELECT transation_seq.nextVal AS id FROM DUAL");
        ResultSet resultSet = statement.executeQuery();

        resultSet.next();

        transaction.setId(resultSet.getInt("id"));
        transaction.setDateTime(LocalDateTime.now());

        statement = connection.prepareStatement("INSERT INTO transaction(id, customer_id, date_time, sender_card_number, " +
                "receiver_card_number, amount) VALUES (?, ?, ?, ?, ?, ?)");

        statement.setInt(1, transaction.getId());
        statement.setInt(2, transaction.getCustomerId());
        statement.setTimestamp(3, Timestamp.valueOf(transaction.getDateTime()));
        statement.setString(4, transaction.getSenderCardNumber());
        statement.setString(5, transaction.getReceiverCardNumber());
        statement.setLong(6, transaction.getAmount());

        int result = statement.executeUpdate();

        return ( result == 1 ) ? transaction : null;
    }

    public Transaction edit(Transaction transaction) throws Exception
    {
        statement = connection.prepareStatement("UPDATE transaction SET customer_id = ?, date_time = ?, sender_card_number = ?, " +
                "receiver_card_number = ?, amount = ? WHERE id = ?");

        statement.setInt(1, transaction.getCustomerId());
        statement.setTimestamp(2, Timestamp.valueOf(transaction.getDateTime()));
        statement.setString(3, transaction.getSenderCardNumber());
        statement.setString(4, transaction.getReceiverCardNumber());
        statement.setLong(5, transaction.getAmount());
        statement.setInt(6, transaction.getId());

        int result = statement.executeUpdate();

        return ( result == 1 ) ? transaction : null;
    }

    public List<Transaction> findAll() throws Exception
    {
        statement = connection.prepareStatement("SELECT * FROM transaction ORDER BY id");
        ResultSet resultSet = statement.executeQuery();

        List<Transaction> transactionList = new ArrayList<>();

        while( resultSet.next() )
        {
            Transaction transaction = new Transaction(
                    resultSet.getInt("id"),
                    resultSet.getInt("customer_id"),
                    resultSet.getTimestamp("date_time").toLocalDateTime(),
                    resultSet.getString("sender_card_number"),
                    resultSet.getString("receiver_card_number"),
                    resultSet.getLong("amount")
            );

            transactionList.add(transaction);
        }

        return transactionList;
    }

    public Transaction findById(int id) throws Exception
    {
        statement = connection.prepareStatement("SELECT * FROM transaction WHERE id = ?");
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();

        resultSet.next();

        Transaction transaction = new Transaction(
                resultSet.getInt("id"),
                resultSet.getInt("customer_id"),
                resultSet.getTimestamp("date_time").toLocalDateTime(),
                resultSet.getString("sender_card_number"),
                resultSet.getString("receiver_card_number"),
                resultSet.getLong("amount"));

        return transaction;
    }

    @Override
    public void close() throws Exception {
        statement.close();
        connection.close();
    }
}