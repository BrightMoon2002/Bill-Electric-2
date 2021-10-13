package model;

import java.io.Serializable;

public class Bill implements Serializable {
    private String codeBill;
    private int oldIndex;
    private int newIndex;
    private Customer customer;

    public Bill() {
    }

    public Bill(String codeBill, int oldIndex, int newIndex, Customer customer) {
        this.codeBill = codeBill;
        this.oldIndex = oldIndex;
        this.newIndex = newIndex;
        this.customer = customer;
    }

    public String getCodeBill() {
        return codeBill;
    }

    public void setCodeBill(String codeBill) {
        this.codeBill = codeBill;
    }

    public int getOldIndex() {
        return oldIndex;
    }

    public void setOldIndex(int oldIndex) {
        this.oldIndex = oldIndex;
    }

    public int getNewIndex() {
        return newIndex;
    }

    public void setNewIndex(int newIndex) {
        this.newIndex = newIndex;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getIndexOfMonth() {
        return getNewIndex() - getOldIndex();
    }

    public double getMoneyPay() {
        return getIndexOfMonth() * 750;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "codeBill='" + codeBill + '\'' +
                ", oldIndex=" + oldIndex +
                ", newIndex=" + newIndex +
                ", customer=" + customer +
                '}';
    }
}
