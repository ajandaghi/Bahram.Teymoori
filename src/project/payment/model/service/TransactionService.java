package project.payment.model.service;

import project.payment.model.entity.Customer;
import project.payment.model.entity.Transaction;
import project.payment.model.repository.TransactionRepository;

import java.util.List;

public class TransactionService
{
    public static Transaction add(Transaction transaction) throws Exception
    {
        try( TransactionRepository transactionRepository = new TransactionRepository() )
        {
            return transactionRepository.add(transaction);
        }
    }

    public static Transaction edit( Transaction transaction ) throws Exception
    {
        try( TransactionRepository transactionRepository = new TransactionRepository() )
        {
            return transactionRepository.edit(transaction);
        }
    }

    public static List<Transaction> findAll() throws Exception
    {
        try( TransactionRepository transactionRepository = new TransactionRepository() )
        {
            return transactionRepository.findAll();
        }
    }

    public static Transaction findById(int id) throws Exception
    {
        try( TransactionRepository transactionRepository = new TransactionRepository() )
        {
            return transactionRepository.findById(id);
        }
    }


}