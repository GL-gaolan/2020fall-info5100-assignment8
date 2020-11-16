package emailapp;
import java.util.Random;
import java.util.Scanner;


public class Email {

    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String companySuffix = "aeycompany.com";
    private final String firstName;
    private final String lastName;
    public static final int SALES = 1;
    public static final int DEVELOPMENT = 2;
    public static final int ACCOUNTING = 3;
    public static final int NONE = 0;
    private String department;


    // Constructor to receive the first name and last name
    public Email(String firstName, String lastName) {
        this.firstName=firstName;
        this.lastName=lastName;
    }

    // Ask for the department
    private String SetDepartment() {
        Scanner scanner=new Scanner(System.in);
        int code = scanner.nextInt();
        if(code == Email.SALES){
            department = "sal";
        }else if(code == Email.DEVELOPMENT){
            department ="dev";
        }else if(code == Email.ACCOUNTING){
            department="acc";
        }else if(code == Email.NONE){
            department = "";
        }
        return  code + "," +department;
    }

    // Generate a random password
    private String randomPassword(int length) {
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
        Random random= new Random();
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<length;i++){
            int number = random.nextInt(str.length());
            sb.append(str.charAt(number));}
        return sb.toString();
        }

    public int getDefaultPasswordLength() {
        return defaultPasswordLength;
    }

    public void setDefaultPasswordLength(int defaultPasswordLength) {
        this.defaultPasswordLength = defaultPasswordLength;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public void setMailboxCapacity(int mailboxCapacity) {
        this.mailboxCapacity = mailboxCapacity;
    }
    public String getCompanySuffix(){
        return companySuffix;
    }

    public void setCompanySuffix(String companySuffix) {
        this.companySuffix = companySuffix;
    }

    public String showInfo(){
        String s=SetDepartment();
        return "New Worker:"+
                " "+ firstName+" "+lastName+
                ". Department Codes:"+'\n'+
                "1 for Sales"+'\n'+
                "2 for Development" + '\n' +
                "3 for Accounting" + '\n' +
                "0 for none" + '\n' +
                s.split(",")[0] + '\n' +
                "DISPLAY NAME: " + firstName + " " + lastName + '\n' +
                "DEPARTMENT: " + department + '\n' +
                "COMPANY EMAIL: " + firstName.toLowerCase() + "." + lastName.toLowerCase() +"@" + s.split(",")[1] +"." + getCompanySuffix() + '\n' +
                "PASSWORD: " + randomPassword(getDefaultPasswordLength()) + '\n' +
                "MAILBOX CAPACITY:" + getMailboxCapacity() + "mb";
    }
}
