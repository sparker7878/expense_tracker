package sample;

import java.util.*;
import java.lang.*;

class Expense {

    private String name;
    private double amount;
    private String category;
    private Date date;
    private String note;
    private boolean isScheduled;
    private long frequency;
    private Date nextOccurrence;

    //Constructor
    Expense(String name, double amount, String category, Date date, String note) {
        this.name = name;
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.note = note;
        this.isScheduled = false;
        this.frequency = 0;
        this.nextOccurrence = null;
    }

    //for not scheduled
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    //VERY IMPORTANT FOR TELLING APART NORMAL vs SCHEDULED EXPENSE
    public boolean isScheduled(){
        return this.isScheduled;
    }

    @Override
    public String toString() {
        String s = "(" + this.getName() + ", $" + this.getAmount() + ", " + this.getCategory() + ", " + this.getDate().toString() + ", " + this.getNote() + ")";
        if(this.isScheduled())
            return s + " <- [Occurs every " + this.getFrequency() + " milliseconds]";
        else
            return s;
    }

    //Constructor for scheduled
    Expense(String name, double amount, String category, Date date, String note, long frequency) {
        this.name = name;
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.note = note;
        this.isScheduled = true;
        this.frequency = frequency;
        this.nextOccurrence = new Date(date.getTime() + frequency);
    }

    public boolean needsUpdate()
    {
        Date today = new Date();
        return today.after(this.getNextOccurrence());
    }

    public Date getNextOccurrence() {
        return nextOccurrence;
    }

    public void setNextOccurrence(Date nextOccurrence) {
        this.nextOccurrence = nextOccurrence;
    }

    public long getFrequency() {
        return frequency;
    }

    public void setFrequency(long frequency) {
        this.frequency = frequency;
    }

    public void setScheduled(boolean scheduled) {
        this.isScheduled = scheduled;
    }
}