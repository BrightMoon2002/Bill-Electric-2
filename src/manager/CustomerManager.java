package manager;

import model.Bill;
import model.Customer;

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
        writeListCustomer();
    }

    @Override
    public List<Customer> findAll() {
        return customerList;
    }

    @Override
    public void saveList(Customer customer) {
        customerList.add(customer);
        writeListCustomer();
    }

    @Override
    public void removeByIndex(int index) {
        customerList.remove(index);
        writeListCustomer();
    }

    @Override
    public void update(int index, Customer customer) {
        customerList.set(index, customer);
        writeListCustomer();
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

   public void writeListCustomer()  {
        File file = new File("CustomerList.txt");
       try {
           OutputStream os = new FileOutputStream(file);
           ObjectOutputStream oos = new ObjectOutputStream(os);
           oos.writeObject(customerList);

       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }
   }

   public List<Customer> readListCustomer() {
        List<Customer> customerList = new ArrayList<>();
        File file = new File("CustomerList.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (file.length() == 0) {
            return customerList;
        }
       try {
           InputStream is = new FileInputStream(file);
           ObjectInputStream ois = new ObjectInputStream(is);
           customerList = (List<Customer>) ois.readObject();
           ois.close();

       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (ClassNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }
       return customerList;
   }

}
