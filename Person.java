package projectInJava;

import java.util.Scanner;

enum Status
{
    SINGLE, MARRIED, DIVORCED
}

public class Person {
    private String id;
    private String firstName;
    private String lastName;
    private Status familyStatus;

    public Person(){

    }

    public Person(String id, String firstName, String lastName, String familyStatus) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        String familyStatusNew= checkStatus(familyStatus);
        this.familyStatus = Status.valueOf(familyStatusNew);
    }

    public void input(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your ID: ");
        String idPerson = scanner.next();
        this.id=idPerson;
        System.out.println("Enter your first name: ");
        String firstNamePerson = scanner.next();
        this.firstName=firstNamePerson;
        System.out.println("Enter your last name: ");
        String lastNamePerson = scanner.next();
        this.lastName=lastNamePerson;
        System.out.println("Enter your family Status, it must be :'SINGLE' or 'MARRIED' or 'DIVORCED'  ");
        String familyStatusPerson = scanner.next();
        String familyStatusNew= checkStatus(familyStatusPerson);
        this.familyStatus = Status.valueOf(familyStatusNew);
    }



    @Override
    public String toString() {
        return
                "ID='" + id + '\'' +
                ", First Name='" + firstName + '\'' +
                ", Last Name='" + lastName + '\'' +
                ", Family Status='" + familyStatus + '\''+", ";

    }

    public int convertToNum(String s) {
        int num=0;
        Scanner scanner= new Scanner(System.in);
        boolean stayIN = true;
        while (stayIN) {
            if (s.matches("[0-9]+")) {
                num = Integer.parseInt(s);
                stayIN = false;
            } else {
                System.out.println("ERROR, please enter correct integer number: ");
                s = scanner.next();
            }
        }
        return num;
    }


    public String checkStatus(String s) {
        Scanner scanner= new Scanner(System.in);
        boolean stayIN = true;
        while (stayIN) {
            if (s.equals("SINGLE") || s.equals("MARRIED") || s.equals("DIVORCED") ) {
                stayIN = false;
            } else {
                System.out.println("ERROR, it must be :'SINGLE' or 'MARRIED' or 'DIVORCED'  ");
                s = scanner.next();
            }
        }
        return s;
    }


    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Status getFamilyStatus() {
        return familyStatus;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFamilyStatus(Status familyStatus) {
        this.familyStatus = familyStatus;
    }
}
