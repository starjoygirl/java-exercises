import java.util.Scanner;

//1ST
class Automobile {
    //-- FIELDS ---
    private String vin;
    private String type;

    // ----  CONSTRUCTOR ------
    public Automobile(String vin, String type){
        this.vin = vin;
        this.type = type;
    }

    // GETTERS
    public String getVin(){ return vin; }
    public String getType() { return type; }

    //SETTERS
    public void setVin(String vin) { this.vin = vin; }
    public void setType(String type) { this.type = type; }

}



//==================================================================================================
// 2ND
class Make extends Automobile{
    //-- FIELDS ---
    private String makeName;

    // ----  CONSTRUCTOR ------
    public Make(String vin, String type, String makeName){
        super(vin, type);
        this.makeName = makeName;
    }

    // GETTERS & SETTERS
    public String getMakeName() { return makeName; }
    public void setMakeName(String makeName) { this.makeName = makeName; }

}


//==================================================================================================
//3RD
class Model extends Make{
    //-- FIELDS ---
    private String modelName;
    private int year;

    // ----  CONSTRUCTOR ------
    public Model(String vin, String type, String makeName, String modelName, int year){
        super(vin, type, makeName);
        this.modelName = modelName;
        this.year = year;
    }

    // GETTERS
    public String getModelName() { return modelName; }
    public int getYear() { return year; }


    // SETTERS
    public void setModelName(String modelName) { this.modelName = modelName; }
    public void setYear(int year) { this.year = year; }


    // OVERRIDE TO STRING
    @Override
    public String toString(){
        return "---- AUTOMOBILE INFORMATION ----\n" +
                "VIN     : " + getVin() + "\n" +
                "Type    : " + getType() + "\n" +
                "Make    : " + getMakeName() + "\n" +
                "Model   : " + getModelName() + "\n" +
                "Year    : " + getYear() + "\n" +
                "--------------------------------";
    }
}

public class Car {
    public static void main (String [] args){
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter VIN: ");
        String vin = scan.nextLine();

        System.out.print("Enter Type: ");
        String type = scan.nextLine();

        System.out.print("Enter Make: ");
        String makeName = scan.nextLine();

        System.out.print("Enter Model: ");
        String modelName = scan.nextLine();

        System.out.print("Enter Year: ");
        int year = scan.nextInt();
        scan.nextLine();

        Model myModel = new Model(vin, type, makeName, modelName, year);
        System.out.println();
        System.out.println(myModel);



    }
}