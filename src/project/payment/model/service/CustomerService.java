package project.payment.model.service;

import project.payment.model.entity.Customer;
import project.payment.model.repository.CustomerRepository;

import java.util.List;

public class CustomerService
{
    public static Customer add(Customer customer) throws Exception
    {
        try( CustomerRepository customerRepository = new CustomerRepository() )
        {
            return customerRepository.add(customer);
        }
    }

    public static Customer edit( Customer customer ) throws Exception
    {
        try( CustomerRepository customerRepository = new CustomerRepository() )
        {
            return customerRepository.edit(customer);
        }
    }

    public static List<Customer> findAll() throws Exception
    {
        try( CustomerRepository customerRepository = new CustomerRepository() )
        {
            return customerRepository.findAll();
        }
    }

    public static Customer findById(int id) throws Exception
    {
        try( CustomerRepository customerRepository = new CustomerRepository() )
        {
            return customerRepository.findById(id);
        }
    }

    public static Customer findByFullName(String firstName, String lastName) throws Exception
    {
        try( CustomerRepository customerRepository = new CustomerRepository() )
        {
            return customerRepository.findByFullName(firstName, lastName);
        }
    }
}