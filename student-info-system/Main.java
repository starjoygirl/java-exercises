import java.util.Scanner;

//class 1: STUDENT --- The Parent Class
class  Student{
    private String name;
    private String ID;
    private int age;

    //CONSTRUCTOR
    Student(String name, String ID, int age){
        this.name = name;
        this.ID = ID;
        setAge(age);
    }

    //GETTERS
    public String getName(){ return name; }
    public String getID() { return ID; }
    public int getAge(){ return age; }

    //SETTERS
    public void setName(String name) { this.name = name; }
    public void setID(String ID) {this.ID = ID; }
    public void setAge(int age){
        if (age < 18) {
            throw new IllegalArgumentException("Student must be 18 or older");
        }
        this.age = age;
    }


    void displayProfile(){
        System.out.println("Student Name: " + name);
        System.out.println("Student Age: " + age);
        System.out.println("Student ID Number: " + ID);
    }

}
//class 2: CollegeStudent --- extends the parent class (student)
class CollegeStudent extends Student{
    private String course;
    private int yearLevel;

    CollegeStudent(String name, String ID, int age, String course, int yearLevel){
        super(name, ID, age);
        this.course = course;
        this.yearLevel = yearLevel;

    }

    //GETTERS
    public String getCourse(){ return course; }
    public int getYearLevel() { return yearLevel; }

    //SETTERS
    public void setCourse(String course) { this.course = course; }
    public void setYearLevel(int yearLevel) { this.yearLevel = yearLevel;}

    void displayCourse(){
        super.displayProfile();
        System.out.println("Course: " + course);
        System.out.println("Year Level: " + yearLevel);
    }

}


//class3: HonorsGraduate --- extends the child class (College student
class HonorsGraduate extends CollegeStudent{
    private double gpa;
    private String honorStatus;

    HonorsGraduate(String name,String ID, int age, String course, int yearLevel, double gpa, String honorStatus){
        super(name, ID, age, course, yearLevel);
        setGpa(gpa);
        this.honorStatus = honorStatus;
    }

    public double getGpa() { return gpa; }
    public String getHonorStatus() {return honorStatus; }

    public void setGpa(double gpa) {
        if ( gpa >= 1.0 && gpa <=5.0){
            this.gpa = gpa;
        } else {
            throw new IllegalArgumentException("ERROR: Invalid GPA scale");
        }
    }

    public void setHonorStatus(String honorStatus){
        this.honorStatus = honorStatus;
    }

    void displayStatus(){
        super.displayCourse();
        System.out.println("GPA: " + gpa);
        System.out.println("Honor Status: " + honorStatus);
    }
}


public class Main {
    public static void main(String []args){
        Scanner scan = new Scanner(System.in);

        boolean registrationSuccessful = false;

        //TRY AND CATCH inside while loop
        while (!registrationSuccessful) {
            try {
                System.out.println("----- STUDENT INFORMATION -----");

                System.out.print("Enter Student Name: ");
                String name = scan.nextLine();

                System.out.print("Enter Student Age: ");
                int age = scan.nextInt();

                scan.nextLine();

                System.out.print("Enter Student ID Number: ");
                String ID = scan.nextLine();

                System.out.print("Enter Course: ");
                String course = scan.nextLine();

                System.out.print("Enter Year Level: ");
                int yearLevel = scan.nextInt();

                scan.nextLine();

                System.out.print("Enter GPA (1.0 - 5.0) : ");
                double gpa = scan.nextDouble();

                scan.nextLine();

                System.out.print("Enter Honors Status (e.g, Magna Cum Laude) : ");
                String honorStatus = scan.nextLine();

                HonorsGraduate graduateStudent = new HonorsGraduate(name, ID, age, course, yearLevel, gpa, honorStatus);


                System.out.println(" ----- STUDENT GRADUATION PROFILE ----- ");
                graduateStudent.displayStatus();
                System.out.println("");

                registrationSuccessful = true;

            } catch (IllegalArgumentException e) {
                System.out.println("\n---- REGISTRATION ERROR ----");
                System.out.println(e.getMessage());
                System.out.println("Please re-enter student information.");
                System.out.println("");
            }

        }
        scan.close();
    }
}