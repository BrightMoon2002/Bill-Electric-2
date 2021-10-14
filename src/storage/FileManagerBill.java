package storage;

import model.Bill;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManagerBill {
    public static void writeListBill (List<Bill> billList) {
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

    public static List<Bill> readBillList() {
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
