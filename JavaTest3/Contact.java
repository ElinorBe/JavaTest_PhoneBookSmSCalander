package JavaTest3;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Contact {
    String firstName;
    String middleName;
    String lastName;
    String fullName;
    String contactPhoneNumber;
    String contactCompanyName;

    Contact(String firstName, String middleName, String lastName, String contactPhoneNumber, String contactCompanyName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.contactPhoneNumber = contactPhoneNumber;
        this.contactCompanyName = contactCompanyName;
        this.fullName = this.firstName + this.middleName + this.lastName;
    }

    Contact() {

    }

    public void setFirstName(String firstName) {
        String regex = "^[a-zA-Z0-9]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        if (!pattern.matcher(firstName).matches()) {
            System.out.println("'First name' must contain a-zA-Z0-9 only and at least 2 characters.");
            Scanner s = new Scanner(System.in);
            setFirstName(s.nextLine());
        }
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setMiddleName(String middleName) {
        if (middleName.equals("") || middleName.equals(" "))
            this.middleName = "";
        else this.middleName = " " + middleName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setLastName(String lastName) {
        String regex = "^[a-zA-Z0-9]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        if (!pattern.matcher(lastName).matches()) {
            System.out.println("'Last name' must contain a-zA-Z0-9 only and at least 2 characters.");
            Scanner s = new Scanner(System.in);
            setLastName(s.nextLine());
        }
        this.lastName = " " + lastName;
    }

    public String getFullName(){
        return fullName;
    }
    public String getLastName() {
        return lastName;
    }

    public void setContactPhoneNumber(String phone) {
        if (phone.length() != 10) {
            System.out.println("Phone must have 10 digits, please try again.");
            Scanner s = new Scanner(System.in);
            setContactPhoneNumber(s.nextLine());
        }
        this.contactPhoneNumber = phone;
    }
    public String getContactPhoneNumber() {
        return contactPhoneNumber;
    }

    public void setContactCompanyName(String contactCompanyName) {
        this.contactCompanyName = contactCompanyName;
    }
    public String getContactCompanyName() {
        return contactCompanyName;
    }

    public String toString() {
        return "[Contact name: '" + this.firstName + this.getMiddleName() + this.getLastName() + "', " + "Contact phone number: '" + this.getContactPhoneNumber() + "', " + "Contact company name: '" + this.getContactCompanyName() + "']\n";
    }

    public void equals() {

    }
}
