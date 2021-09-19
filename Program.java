package projectInJava;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {
    public  static int convertToNum(String s) {
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


    public static void main(String[] args) {
        //for test
        Scanner scanner= new Scanner(System.in);
        ArrayList<Person> people= new ArrayList<Person>(); // will contain student and teachers


        boolean stayInMain= true;
        while (stayInMain) {
            System.out.println(
            "\nPlease choose one of the following :\n" +
            "\t 1) Add teacher. \n" +
            "\t 2) Add student. \n" +
            "\t 3) Show all people.\n" +
            "\t 4) Show all teachers.\n" +
            "\t 5) Show all students.\n" +
            "\t 6) Print Teacher by ID.\n" +
            "\t 7) Show status by ID and check scores.\n" +
            "\t 8) Show students by score range.\n" +
            "\t 0) Quit.\n" +
            "Your option:\n "
             );
             String option = scanner.next();

            switch(option) {
                case "1":
                    Person teacher = new Teacher();
                    teacher.input();
                    people.add(teacher);

                    break;
                case "2":
                    Person student = new Student();
                    student.input();   //  קופץ לפונקציה הכי עדכנית שנקראת INPUT
                    people.add(student);

                    break;
                case "3":
                    for(Person i:people)
                        System.out.println(i);
                    break;
                case "4":
                    for(Person i:people){
                        if (i instanceof Teacher)
                            System.out.println(i);
                    }
                    break;
                case "5":
                    for(Person i:people){
                        if (i instanceof Student)
                            System.out.println(i);
                    }
                    break;
                case "6":
                    boolean flag= false;
                    System.out.println("Please enter teacher`s ID: " );
                    String IDTeacher = scanner.next().strip();
                    for(Person i:people){
                        if (  (i instanceof Teacher) && (IDTeacher.equals(i.getId()))  ) {
                            System.out.println(i);
                            flag =true;
                        }
                        else if (i instanceof Student && IDTeacher.equals(i.getId())){
                            System.out.println("Not a teacher");
                            flag =true;
                        }
                    }
                    if (!flag)
                        System.out.println("Does not exists");
                    break;
                case "7":
                    boolean stay=true;
                    int indx = 0;
                    boolean exist =false;
                    boolean flagExtra= false;
                    System.out.println("Please enter student`s ID:");
                    String IDStudent = scanner.next();
                    //for(Person i:people){
                    for(int j=0;j<people.size();j++) {
                        if (people.get(j) instanceof Student && IDStudent.equals(people.get(j).getId())) {
                            System.out.println(people.get(j));
                            flagExtra = true;
                            exist = true;
                            indx=j;
                        }
                    }
                    for(Person i:people){
                        if (i instanceof Teacher && IDStudent.equals(i.getId())){
                            System.out.println("Not a student");
                            flagExtra =true;
                        }
                    }
                    if (!flagExtra)
                        System.out.println("Does not exists");

                    if (exist) {
                        while (stay) {
                            System.out.println(
                                    "\nPlease choose from a to e: \n" +
                                            "\t a) Show all scores. \n" +
                                            "\t b) Insert a new score.\n" +
                                            "\t c) Show average score. \n" +
                                            "\t d) Remove score by index. \n" +
                                            "\t e) Return to the main menu.\n"
                            );
                            String op = scanner.next().toLowerCase();

                            switch (op) {
                                case "a":
                                    ((Student) people.get(indx)).printAllScoresOdStudent();
                                    break;

                                case "b":
                                    System.out.println("Please enter your course:");
                                    String course = scanner.next();
                                    System.out.println("Please enter your mark:");
                                    int mark = convertToNum(scanner.next());
                                    ((Student)people.get(indx)).input(course, mark);  //its the object of the student
                                    break;

                                case "c":
                                    double avgStudent= ((Student) people.get(indx)).getAverageScore();
                                    System.out.println("The average of the student is: "+avgStudent);

                                    break;
                                case "d":
                                    System.out.println("Please enter index of the course that you want to delete: ");
                                    int inx=convertToNum(scanner.next()) ;
                                    ((Student) people.get(indx)).deleteRow(inx);
                                    break;

                                case "e":
                                    stay= false;
                                    break;
                                default:
                                    System.out.println(" You entered invalid key, please enter char 'a' to 'e'.");
                                    break;
                            }
                        }
                    }
                    break;
                case "8":
                    System.out.println("Please enter minimum mark: ");
                    int min = convertToNum(scanner.next());
                    System.out.println("Please enter maximum mark: ");
                    int max = convertToNum(scanner.next());
                    for(Person i: people){
                        if ((i instanceof Student))

                        {
                            double average= ((Student)i).getAverageScore();
                            if (average >= min && average <= max)
                                System.out.println(i);
                        }
                    }

                break;
                case "0":
                    stayInMain=false;
                    break;
                default:
                    System.out.println(" You entered invalid key, please enter correct integer number.");;
            }
        }
    }
}
