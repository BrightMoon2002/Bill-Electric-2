package view;

import manager.BillManager;
import manager.CustomerManager;
import model.Bill;
import model.Customer;
import storage.FileManagerBill;
import storage.FileManagerCustomer;

import java.util.List;
import java.util.Scanner;

public class MainManagerBill {
    public static void main(String[] args) {

        CustomerManager customerManager = new CustomerManager();
        List<Customer> customerList = FileManagerCustomer.readListCustomer();
        BillManager billManager = new BillManager();
        List<Bill> billList = FileManagerBill.readBillList();
        customerManager.setCustomerList(customerList);
        billManager.setBillList(billList);
        MenuOfBillElectric(customerManager, billManager);


    }

    public static void MenuOfBillElectric(CustomerManager customerManager, BillManager billManager) {
        while (true) {
            int choice = getChoice();
            switch (choice) {
                case 1:
                    customerManager.saveList(creatNewCustomer());
                    break;
                case 2:
                    removeCustomer(customerManager);
                    break;
                case 3:
                    updateCustomer(customerManager);
                    break;
                case 4:
                    creatNewBill(customerManager, billManager);
                    break;
                case 5:
                    updateBill(customerManager, billManager);
                    break;
                case 6:
                    removeBillByCodeOfBill(billManager);
                    break;
                case 7:
                    checkMoney(billManager);
                    break;
                case 8:
                    customerManager.showAllList();
                    break;
                case 9:
                    billManager.showAllList();
                    break;
                case 10:
                    billManager.searchById(getIdOfCustomer());
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter again your choice:");
                    break;
            }
        }
    }

    private static void removeBillByCodeOfBill(BillManager billManager) {
        System.out.println("Enter the code of Bill you want to remove");
        Scanner inputCodeBill = new Scanner(System.in);
        String codeBill = inputCodeBill.nextLine();
        Bill bill1  = billManager.searchById(codeBill);
        if (bill1 != null) {
            billManager.removeByIndex(billManager.getBillList().indexOf(bill1));
        } else {
            System.out.println("No bill has that index!");
        }
    }

    private static void updateBill(CustomerManager customerManager, BillManager billManager) {
        System.out.println("Enter the code of Bill which you want to update:");
        Scanner inputCode = new Scanner(System.in);
        String code = inputCode.nextLine();
        Bill bill = billManager.searchById(code);
        if (bill !=  null) {
            System.out.println("Enter the old Index: ");
            Scanner inputOldIndex = new Scanner(System.in);
            int oldIndex = inputOldIndex.nextInt();
            System.out.println("Enter the new Index: ");
            Scanner inputNewIndex = new Scanner(System.in);
            int newIndex = inputNewIndex.nextInt();
            while (newIndex < oldIndex) {
                System.out.println("Enter the new Index again:");
                Scanner inputNewIndex2 = new Scanner(System.in);
                newIndex = inputNewIndex2.nextInt();
            }
            System.out.println("Enter the new code Bill:");
            Scanner inputCodeBill = new Scanner(System.in);
            String codeBill = inputCodeBill.nextLine();
            Bill bill1 = new Bill(codeBill, oldIndex, newIndex, customerManager.searchByName(bill.getCustomer().getFullName()));
            billManager.update(billManager.getBillList().indexOf(bill), bill1);
        } else {
            System.out.println("No Bill has that code");
        }
    }

    private static void checkMoney(BillManager billManager) {
        System.out.println("Enter the code Bill:");
        Scanner inputCodeBill = new Scanner(System.in);
        String codeBill = inputCodeBill.nextLine();
        Bill bill = billManager.searchById(codeBill);
        if (bill != null) {
            System.out.println(bill.getMoneyPay());
        } else {
            System.out.println("No Customer have that code Bill");
        }
    }

    private static void creatNewBill(CustomerManager customerManager, BillManager billManager) {
        String idCustomerCheck = getIdOfCustomer();
        Customer customer3 = customerManager.searchById(idCustomerCheck);
        if (customer3 != null) {
            billManager.saveList(creatNewBill(customer3));
        } else {
            System.out.println("No customer has that id");
        }
    }

    private static void updateCustomer(CustomerManager customerManager) {
        String idCustomer1 = getIdOfCustomer();
        Customer customer2 = customerManager.searchById(idCustomer1);
        if (customer2 != null) {
            Customer customer3 = creatNewCustomer();
            customerManager.update(customerManager.getCustomerList().indexOf(customer2), customer3);
        } else {
            System.out.println("No Customer have that id");
        }
    }

    private static void removeCustomer(CustomerManager customerManager) {
        String idCustomer = getIdOfCustomer();
        Customer customer1 = customerManager.searchById(idCustomer);
        if (customer1 != null) {
            customerManager.removeByIndex(customerManager.getCustomerList().indexOf(customer1));
        } else {
            System.out.println("No Customer have that id");
        }
    }

    private static int getChoice() {
        System.out.println("Menu:");
        System.out.println("1. Add new Customer");
        System.out.println("2. Remove Customer");
        System.out.println("3. Update Customer by id");
        System.out.println("4. Creat new Bill");
        System.out.println("5. Update Bill by codeBill");
        System.out.println("6. Remove Bill");
        System.out.println("7. Check money to pay");
        System.out.println("8. Display list Guest");
        System.out.println("9. Display list Bill");
        System.out.println("10. Search the Guest by Id");
        System.out.println("0. Exit");
        System.out.println("Enter your choice:");
        Scanner inputChoice = new Scanner(System.in);
        return inputChoice.nextInt();
    }

    private static Bill creatNewBill(Customer customer3) {

        System.out.println("Enter the old Index: ");
        Scanner inputOldIndex = new Scanner(System.in);
        int oldIndex = inputOldIndex.nextInt();
        System.out.println("Enter the new Index: ");
        Scanner inputNewIndex = new Scanner(System.in);
        int newIndex = inputNewIndex.nextInt();
        while (newIndex < oldIndex) {
            System.out.println("Enter the new Index again:");
            Scanner inputNewIndex2 = new Scanner(System.in);
            newIndex = inputNewIndex2.nextInt();
        }
        System.out.println("Enter the new code Bill:");
        Scanner inputCodeBill = new Scanner(System.in);
        String codeBill = inputCodeBill.nextLine();
        return new Bill(codeBill, oldIndex, newIndex, customer3);
    }

    private static String getIdOfCustomer() {
        System.out.println("Enter the id of Customer who want to check");
        Scanner inputId = new Scanner(System.in);
        return inputId.nextLine();
    }

    private static Customer creatNewCustomer() {
        System.out.println("Enter Full name of Customer:");
        Scanner inputName = new Scanner(System.in);
        String name = inputName.nextLine();
        System.out.println("Enter the address of Customer: ");
        Scanner inputAddress = new Scanner(System.in);
        String address = inputAddress.nextLine();
        System.out.println("Enter the idCode of Customer:");
        Scanner inputCode = new Scanner(System.in);
        String code = inputCode.nextLine();
        return new Customer(name, address, code);
    }
}