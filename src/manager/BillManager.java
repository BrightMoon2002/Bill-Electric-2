package manager;

import model.Bill;
import storage.FileManagerBill;

import java.util.ArrayList;
import java.util.List;

public class BillManager implements IGeneralManager<Bill>{

    private List<Bill> billList = new ArrayList<>();

    public BillManager() {
    }

    public List<Bill> getBillList() {
        return billList;
    }

    public BillManager(List<Bill> billList) {
        this.billList = billList;
    }

    public void setBillList(List<Bill> billList) {
        this.billList = billList;
        FileManagerBill.writeListBill(billList);
    }

    @Override
    public List findAll() {
        return billList;
    }

    @Override
    public void saveList(Bill b) {
        billList.add(b);
        FileManagerBill.writeListBill(billList);
    }

    @Override
    public void removeByIndex(int index) {
        billList.remove(index);
        FileManagerBill.writeListBill(billList);
    }

    @Override
    public void update(int index, Bill b) {
        billList.set(index, b);
        FileManagerBill.writeListBill(billList);
    }

    @Override
    public Bill searchById(String id) {
        Bill bill  = null;
        for (int i = 0; i < billList.size(); i++) {
            if (billList.get(i).getCodeBill().equalsIgnoreCase(id)) {
                bill = billList.get(i);
                break;
            }
        }
        return bill;
    }

    @Override
    public Bill searchByName(String name) {
        Bill bill  = null;
        for (int i = 0; i < billList.size(); i++) {
            if (billList.get(i).getCustomer().getFullName().equalsIgnoreCase(name)) {
                bill = billList.get(i);
                break;
            }
        }
        return bill;
    }

    @Override
    public void showAllList() {
        System.out.println(billList);
    }




}
