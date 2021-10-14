package manager;

import model.Bill;
import model.Customer;
import storage.FileManagerCustomer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerManager implements IGeneralManager<Customer> {
    private List<Customer> customerList = new ArrayList<>();

    public CustomerManager(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public CustomerManager() {
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
        FileManagerCustomer.writeFile(customerList);
    }

    @Override
    public List<Customer> findAll() {
        return customerList;
    }

    @Override
    public void saveList(Customer customer) {
        customerList.add(customer);
       FileManagerCustomer.writeFile(customerList);
    }

    @Override
    public void removeByIndex(int index) {
        customerList.remove(index);
        FileManagerCustomer.writeFile(customerList);
    }

    @Override
    public void update(int index, Customer customer) {
        customerList.set(index, customer);
        FileManagerCustomer.writeFile(customerList);
    }

    @Override
    public Customer searchById(String id) {
        Customer customer = null;
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getIdCode().equalsIgnoreCase(id)) {
                customer = customerList.get(i);
                break;
            }
        }
        return customer;
    }

    @Override
    public Customer searchByName(String name) {
        Customer customer = null;
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getFullName().equalsIgnoreCase(name)) {
                customer = customerList.get(i);
                break;
            }
        }
        return customer;
    }

    @Override
    public void showAllList() {
        System.out.println(customerList);
    }


}
