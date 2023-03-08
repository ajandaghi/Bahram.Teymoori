package project.payment.controller;

import project.payment.model.entity.Transaction;
import project.payment.model.service.TransactionService;

import java.time.LocalDateTime;

public class TransactionController
{
    public static String add(int customerId, String senderCardNumber, String receiverCardNumber, long amount)
    {
        if( customerId != 0 && senderCardNumber != null && receiverCardNumber != null && amount != 0 )
        {
            try
            {
                Transaction transaction = new Transaction(customerId, senderCardNumber, receiverCardNumber, amount);
                return TransactionService.add(transaction).toString();
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

    public static String edit(int id, int customerId, LocalDateTime dateTime, String senderCardNumber, String receiverCardNumber, long amount)
    {
        if( id != 0 && customerId != 0 && dateTime != null && senderCardNumber != null && receiverCardNumber != null && amount != 0 )
        {
            try
            {
                Transaction transaction = new Transaction(id, customerId,  dateTime, senderCardNumber, receiverCardNumber, amount);
                return TransactionService.edit(transaction).toString();
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

    public String findAll()
    {
        try
        {
            return TransactionService.findAll().toString();
        }
        catch( Exception e )
        {
            return e.getMessage();
        }
    }

    public String findById(int id)
    {
        try
        {
            return TransactionService.findById(id).toString();
        }
        catch( Exception e )
        {
            return e.getMessage();
        }
    }
}