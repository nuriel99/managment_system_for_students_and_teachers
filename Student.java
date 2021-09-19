package projectInJava;

import java.util.ArrayList;

public class Student extends Person {
    private ArrayList<Score> scores=new ArrayList<Score>();
    private double avg = 0;

    public Student(){
        super();
    }

    public Student(String id, String firstName, String lastName, String familyStatus) {
        super(id, firstName, lastName, familyStatus);
    }


    public void input(String course, int mark) {
        Score score= new Score(course, mark);
        scores.add(score);
    }

    public void printAllScoresOdStudent(){
        for(int i=0;i<scores.size();i++){
            System.out.println("The index is: "+i+ "  ," + "the course is: "+ scores.get(i).getCourse()+
                    "  ,"+ "the mark is:"+ scores.get(i).getValue());
        }
    }


    public double getAverageScore(){
        double avg;
        int sum = 0, counter =0;

        if (scores.size()==0)
            return 0.0;

        for(int i=0;i<scores.size();i++) {
            sum+= scores.get(i).getValue();
            counter++;
        }
        avg = (double)sum/counter;
        return avg;

    }

    public void deleteRow(int idx){
         scores.remove(idx);
    }

    @Override
    public String toString() {
        String str = super.toString();
        return str + "The average is : " + getAverageScore() ;

    }
}
