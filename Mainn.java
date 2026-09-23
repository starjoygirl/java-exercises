import java.util.Scanner;

//PARENT CLASS: EMPLOYEE
class Employee {
    private String name;
    private int employeeId;
    private double salary;


    //CONSTRUCTORS
    public Employee(String name, int employeeId, double salary){
        this.name = name;
        this.employeeId = employeeId;
        this.salary = salary;
    }


    //GETTERS section:
    public String getName() { return name; }
    public int getEmployeeId() { return employeeId; }
    public double getSalary() { return salary; }

    //SETTERS section:
    public void setName(String name) { this.name = name; }
    public void setEmployeeId(int employeeId) { this.employeeId = employeeId; }
    public void setSalary(double salary) { this.salary = salary; }


    void displayEmployee(){
        System.out.println("Name: " + name);
        System.out.println("Employee ID Number: " + employeeId);
        System.out.println("Salary: " + salary);
    }
}

class Manager extends Employee{
    private String department;

    //CONSTRUCTOR
    public Manager(String name, int employeeId, double salary, String department){
        super(name, employeeId, salary);
        this.department = department;
    }

    //GETTERS & SETTERS
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }


    void displayManager(){
        System.out.println(" --- MANAGERS INFORMATION --- ");
        super.displayEmployee();
        System.out.println("Department: " + department);
    }
}

// MAIN == ACTUAL RUNNING OF CODE and OBJECT CREATION

public class Mainn {
    public static void main (String [] args){
        Scanner scan = new Scanner(System.in);

        // ----- USER INPUT -----
        System.out.print("Enter Name: ");
        String name = scan.nextLine();

        System.out.print("Enter Employee ID: ");
        int employeeId = scan.nextInt();
        scan.nextLine();

        System.out.print("Enter Salary: ");
        double salary = scan.nextDouble();
        scan.nextLine();

        System.out.print("Enter Department: ");
        String department = scan.nextLine();


        // ---- OBJECT CREATION ----
        Manager newMan = new Manager(name, employeeId, salary, department);

        System.out.println();
        // --- DISPLAY USER INPUTS INFORMATION
        newMan.displayManager();
        System.out.println();

        // --- GIVING OPTIONS TO USER IF THEY WANT TO UPDATE ANY INFORMATION ---
        System.out.println("Do you want to update your data, " + name + " ?");
        System.out.println("1. YES");
        System.out.println("2. NO");
        System.out.print("choice: ");
        int option = scan.nextInt();
        scan.nextLine();


        // --- CLEAN IF-ELSE ROUTING ---
        if (option == 1){
            // ---- calling sub-method to run the menu -----
            presentUpdateMenu(scan, newMan);
        } else {
            System.out.println(" ----- NO CHANGES MADE ----- ");
        }


        // display updated information
        System.out.println();
        newMan.displayManager();
        scan.close();

    }


    private static void presentUpdateMenu(Scanner scan, Manager manager){
        int choice;
        System.out.println();
        do {
            System.out.println(" ----- INFORMATION UPDATE ----- ");
            System.out.println("1. Update Name");
            System.out.println("2. Update Employee ID");
            System.out.println("3. Update Salary");
            System.out.println("4. Update Department");
            System.out.println("5. Exit & Save Changes");
            System.out.print("Select what you'd like to change: ");
            choice = scan.nextInt();
            scan.nextLine();

            switch(choice){
                case 1:
                    System.out.print("Enter new Name: ");
                    String newName = scan.nextLine();
                    manager.setName(newName); // Inherited parent setter
                    System.out.println("Name updated successfully!");
                    break;

                case 2:
                    System.out.print("Enter new Employee ID Number: ");
                    int newEmployeeId = scan.nextInt();
                    manager.setEmployeeId(newEmployeeId);
                    System.out.println("ID Number updated successfully!");
                    break;

                case 3:
                    System.out.print("Enter new Salary: ");
                    double newSalary = scan.nextDouble();
                    manager.setSalary(newSalary);
                    System.out.println("Salary updated successfully!");
                    break;

                case 4:
                    System.out.print("Enter new Department: ");
                    String newDepartment = scan.nextLine();
                    manager.setDepartment(newDepartment);
                    break;

                case 5:
                    System.out.println("Saving and Exiting menu option ... ");
                    break;
                default:
                    System.out.println("INVALID CHOICE! Please select between 1 to 5");

            }

        } while(choice != 5);

        scan.close();
    }
}








