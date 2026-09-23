import java.util.Scanner;
//Abstract parent class -- PARTIAL ABSTRACT
abstract class Employee{
    protected String name;

    public Employee(String name){
        this.name = name;
    }
    public abstract double calculatePay();

    public void displayPay(){
        System.out.println(" === Calculated Pay === ");
        System.out.println("Employee: " + name);
        System.out.println("Weekly Pay: " + calculatePay());
    }
 }
//SUBCLASS EXTENDING FROM THE PARENT CLASS -- NOT MULTILEVEL
 class RegularEmployee extends Employee{
    protected double hoursWorked;
    protected double ratePerHour;

    public RegularEmployee(String name, double hoursWorked, double ratePerHour){
        super(name);
        this.hoursWorked = hoursWorked;
        this.ratePerHour = ratePerHour;
    }

    @Override
     public double calculatePay(){
        return hoursWorked * ratePerHour;
    }

    @Override
     public void displayPay(){
        System.out.println(" === Calculated Pay === ");
        System.out.println("Employee: " + name);
        System.out.println("Weekly Pay: " + calculatePay());
    }
 }

//SUBCLASS EXTENDING FROM THE PARENT CLASS -- NOT MULTILEVEL
 class ContractEmployee extends  Employee {
     protected double fixedPay;

     public ContractEmployee(String name, double fixedPay) {
         super(name);
         this.fixedPay = fixedPay;
     }

     @Override
     public double calculatePay() {
         return fixedPay;
     }

     @Override
     public void displayPay() {
         System.out.println(" === Calculated Pay === ");
         System.out.println("Employee: " + name);
         System.out.println("Weekly Pay: " + calculatePay());

     }
 }

//OBJECT INSTANTIATION -- EXECUTION OF CODE
 public class PracticeAbstract {
     public static void main(String[] args) {
         Scanner scan = new Scanner(System.in);


         System.out.println(" ---- INPUT EMPLOYEE INFORMATION ---- ");
         System.out.print("Regular Employee Name:       ");
         String name = scan.nextLine();
         System.out.print("Hours Worked:       ");
         double hoursWorked = scan.nextDouble();
         scan.nextLine();
         System.out.print("Rate Per Hour:       ");
         double ratePerHour = scan.nextDouble();
         scan.nextLine();

         System.out.println();
         System.out.print("Contract Employee Name:       ");
         String name1 = scan.nextLine();
         System.out.print("FixedPay:       ");
         double fixedPay = scan.nextDouble();
         scan.nextLine();

         Employee regEmp = new RegularEmployee(name, hoursWorked, ratePerHour);
         Employee conEmp = new ContractEmployee(name1, fixedPay);

         regEmp.displayPay();
         System.out.println();
         conEmp.displayPay();





     }
 }