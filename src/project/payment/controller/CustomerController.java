package project.payment.controller;

import project.payment.model.entity.Customer;
import project.payment.model.service.CustomerService;

public class CustomerController
{
    public static String add(String firstName, String lastName, int age, String cardNumber, long balance)
    {
        if( firstName != null && lastName != null && age != 0 && cardNumber != null && balance != 0)
        {
            try
            {
                Customer customer = new Customer(firstName, lastName, age, cardNumber, balance);
                return CustomerService.add(customer).toString();
            }
            catch( Exception e )
            {
                return e.getMessage();
            }
        }
        else
        {
            return "Invalid Error";
        }
    }

    public static String edit(int id, String firstName, String lastName, int age, String cardNumber, long balance)
    {
        if( id != 0 && firstName != null && lastName != null && age != 0 && cardNumber != null && balance != 0)
        {
            try
            {
                Customer customer = new Customer(firstName, lastName, age, cardNumber, balance);
                return CustomerService.edit(customer).toString();
            }
            catch( Exception e )
            {
                return e.getMessage();
            }
        }
        else
        {
            return "Invalid Error";
        }
    }

    public static String findAll()
    {
        try
        {
            return CustomerService.findAll().toString();
        }
        catch( Exception e )
        {
            return e.getMessage();
        }
    }

    public static String findById(int id)
    {
        try
        {
            return CustomerService.findById(id).toString();
        }
        catch( Exception e )
        {
            return e.getMessage();
        }
    }

    public static String findByFullName(String firstName, String lastName)
    {
        try
        {
            return CustomerService.findByFullName(firstName, lastName).toString();
        }
        catch( Exception e )
        {
            return e.getMessage();
        }
    }
}