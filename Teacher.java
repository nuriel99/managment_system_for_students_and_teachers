package projectInJava;

import java.util.Scanner;

public class Teacher extends Person{
    private int wage;


    public Teacher(){
        super();
    }

    public Teacher(String id, String firstName, String lastName, String familyStatus, int wage) {
        super(id, firstName, lastName, familyStatus);
        this.wage = wage;
    }

    @Override
    public void input() {
        super.input();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your wage: ");
        String wageString = scanner.next();
        this.wage = convertToNum(wageString);
    }

    @Override
    public String toString() {
        String str =super.toString();
        return str + "Wage=" + wage;
    }
}
