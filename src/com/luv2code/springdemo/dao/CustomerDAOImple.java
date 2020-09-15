package com.luv2code.springdemo.dao;

import com.luv2code.springdemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CustomerDAOImple implements CustomerDAO{

    @Autowired
    private SessionFactory sessionFactory;



    @Override
    public List<Customer> getCustomers() {
        //get current Hibernate session
        //create query
        //execute query
        //return results
        //create a qieru sprt nu ;ast ma,e
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName"
                                                                ,Customer.class);

        List<Customer> customers = theQuery.getResultList();

        return customers;
    }

    @Override
    public void saveCustomer(Customer theCustomer) {

        //get current hibernate session
        //save/update customer finally
        Session currentSession =sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(theCustomer);
    }

    @Override
    public Customer getCustomer(int theId) {
        //get current hibernate session
        //get theCustomerby ID
        Session currentSession =sessionFactory.getCurrentSession();
        Customer theCustomer = currentSession.get(Customer.class,theId);

        return theCustomer;
    }

    @Override
    public void deleteCustomer(int theId) {
        //get current hibernate session
        //get the Customer by ID
        //delete

        Session currentSession = sessionFactory.getCurrentSession();
//        Customer theCustomer = currentSession.get(Customer.class,theId);
//        currentSession.delete(theCustomer);
        Query theQuery =
                currentSession.createQuery("delete from Customer where id=:customerId");
        theQuery.setParameter("customerId",theId);

        //execute query
        theQuery.executeUpdate();
    }

}
