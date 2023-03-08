package project.payment.model.repository;

import project.payment.jdbc.Jdbc;
import project.payment.model.entity.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements AutoCloseable
{
    private Connection connection;
    private PreparedStatement statement;

    public CustomerRepository() throws Exception
    {
        connection = Jdbc.getConnection();
    }

    public Customer add(Customer customer) throws Exception
    {
        statement = connection.prepareStatement("SELECT customer_seq.nextVal AS id FROM DUAL");
        ResultSet resultSet = statement.executeQuery();

        resultSet.next();

        customer.setId(resultSet.getInt("id"));

        statement = connection.prepareStatement("INSERT INTO customer(id, first_name, last_name, age, card_number, balance) " +
                "VALUES (?, ?, ?, ?, ?, ?)");

        statement.setInt(1, customer.getId());
        statement.setString(2, customer.getFirstName());
        statement.setString(3, customer.getFirstName());
        statement.setInt(4, customer.getAge());
        statement.setString(5, customer.getCardNumber());
        statement.setLong(6, customer.getBalance());

        int result = statement.executeUpdate();

        return ( result == 1 ) ? customer : null;
    }

    public Customer edit(Customer customer) throws Exception
    {
        statement = connection.prepareStatement("UPDATE customer SET first_name = ?, last_name = ?, age = ?, " +
                "card_number = ?, balance = ? WHERE id = ?");

        statement.setString(1, customer.getFirstName());
        statement.setString(2, customer.getFirstName());
        statement.setInt(3, customer.getAge());
        statement.setString(4, customer.getCardNumber());
        statement.setLong(5, customer.getBalance());
        statement.setInt(6, customer.getId());

        int result = statement.executeUpdate();

        return ( result == 1 ) ? customer : null;
    }

    public List<Customer> findAll() throws Exception
    {
        statement = connection.prepareStatement("SELECT * FROM customer ORDER BY id");
        ResultSet resultSet = statement.executeQuery();

        List<Customer> customerList = new ArrayList<>();

        while( resultSet.next() )
        {
            Customer customer = new Customer(
                    resultSet.getInt("id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getInt("age"),
                    resultSet.getString("card_number"),
                    resultSet.getLong("balance")
            );

            customerList.add(customer);
        }

        return customerList;
    }

    public Customer findById(int id) throws Exception
    {
        statement = connection.prepareStatement("SELECT * FROM customer WHERE id = ?");
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();

        resultSet.next();

        Customer customer = new Customer(
                resultSet.getInt("id"),
                resultSet.getString("first_name"),
                resultSet.getString("last_name"),
                resultSet.getInt("age"),
                resultSet.getString("card_number"),
                resultSet.getLong("balance"));

        return customer;
    }

    public Customer findByFullName(String firstName, String lastName) throws Exception
    {
        statement = connection.prepareStatement("SELECT * FROM customer WHERE first_name = ? AND last_name = ?");

        statement.setString(1, "%" + firstName + "%");
        statement.setString(2, "%" + lastName + "%");

        ResultSet resultSet = statement.executeQuery();

        resultSet.next();

        Customer customer = new Customer(
                resultSet.getInt("id"),
                resultSet.getString("first_name"),
                resultSet.getString("last_name"),
                resultSet.getInt("age"),
                resultSet.getString("card_number"),
                resultSet.getLong("balance"));

        return customer;
    }

    @Override
    public void close() throws Exception {
        statement.close();
        connection.close();
    }
}