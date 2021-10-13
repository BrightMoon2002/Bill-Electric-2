package manager;

import model.Bill;

import java.io.*;
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
        writeListBill();
    }

    @Override
    public List findAll() {
        return billList;
    }

    @Override
    public void saveList(Bill b) {
        billList.add(b);
        writeListBill();
    }

    @Override
    public void removeByIndex(int index) {
        billList.remove(index);
        writeListBill();
    }

    @Override
    public void update(int index, Bill b) {
        billList.set(index, b);
        writeListBill();
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

    public void writeListBill () {
        File file = new File("BillList.txt");
        try {
            OutputStream os = new FileOutputStream(file);
            ObjectOutputStream ois = new ObjectOutputStream(os);
            ois.writeObject(billList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public List<Bill> readBillList() {
        List<Bill> billList = new ArrayList<>();
        File file = new File("BillList.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (file.length() == 0) {
            return billList;
        }

        try {
            InputStream is = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(is);
            billList = (List<Bill>) ois.readObject();
            ois.close();
        } catch (FileNotFoundException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return billList;
    }


}
