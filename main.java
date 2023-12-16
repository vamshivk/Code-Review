import java.util.*;
import java.io.*;

class MainMenu {
    public void displayMenu() {
        System.out.println("\t\t*******************************************");
        System.out.println("\t\t\t  EMPLOYEE MANAGEMENT SYSTEM");
        System.out.println("\t\t*******************************************");
        System.out.println("\t\t\t    --------------------");
        System.out.println("\t\t\t     ~$ Abhinav Dubey");
        System.out.println("\t\t\t    --------------------");
        System.out.println("\n\nPress 1 : To Add an Employee Details");
        System.out.println("Press 2 : To See an Employee Details ");
        System.out.println("Press 3 : To Remove an Employee");
        System.out.println("Press 4 : To Update Employee Details");
        System.out.println("Press 5 : To Exit the EMS Portal");
    }
}

class Employee_Add {
    public void createFile() {
        Scanner sc = new Scanner(System.in);

        EmployDetail emp = new EmployDetail();
        emp.getInfo();
        try {
            // Changed variable name for better readability
            File employeeFile = new File("file" + emp.getEmployId() + ".txt");
            if (employeeFile.createNewFile()) {
                FileWriter myWriter = new FileWriter("file" + emp.getEmployId() + ".txt");
                // Improved formatting for better readability
                myWriter.write("Employee ID:" + emp.getEmployId() + "\n" + "Employee Name     :" + emp.getName() + "\n" +
                        "Father's Name     :" + emp.getFatherName() + "\n" + "Employee Contact  :" + emp.getEmployContact() + "\n" +
                        "Email Information :" + emp.getEmail() + "\n" + "Employee position :" + emp.getPosition() + "\n" +
                        "Employee Salary   :" + emp.getEmploySalary());
                myWriter.close();
                System.out.println("\nEmployee has been Added :)\n");
                System.out.print("\nPress Enter to Continue...");
                sc.nextLine();
            } else {
                System.out.println("\nEmployee already exists :(");
                System.out.print("\nPress Enter to Continue...");
                sc.nextLine();
            }
        } catch (IOException e) {
            // Improved error message
            System.out.println("An error occurred while creating the employee file: " + e.getMessage());
        }
    }
}

class EmployDetail {
    private String name;
    private String fatherName;
    private String email;
    private String position;
    private String employId;
    private String employSalary;
    private String employContact;

    public void getInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Employee's name --------: ");
        name = sc.nextLine();
        System.out.print("Enter Employee's Father name -: ");
        fatherName = sc.nextLine();
        System.out.print("Enter Employee's ID ----------: ");
        employId = sc.nextLine();
        System.out.print("Enter Employee's Email ID ----: ");
        do {
            // Improved email validation with regex
            email = sc.nextLine();
            if (!email.matches("^[\\w.-]+@[\\w.-]+\\.[a-z]{2,}$")) {
                System.out.println("Invalid email format. Please enter a valid email.");
                // Ask the user to input the email again or handle it appropriately
                System.out.print("Enter Employee's Email ID ----: ");
            }
        } while (!email.matches("^[\\w.-]+@[\\w.-]+\\.[a-z]{2,}$"));
        System.out.print("Enter Employee's Position ----: ");
        position = sc.nextLine();
        System.out.print("Enter Employee contact Info --: ");
        employContact = sc.nextLine();
        System.out.print("Enter Employee's Salary ------: ");
        employSalary = sc.nextLine();
    }

    // Getter and setter methods (Encapsulation)
    // ...
}

class Employee_Show {
    public void viewFile(String s) throws Exception {
        // No changes in this class
    }
}

class Employee_Remove {
    public void removeFile(String ID) {
        File file = new File("file" + ID + ".txt");
        //Improved validation for file removal
        if (file.exists() && file.delete()) {
            System.out.println("\nEmployee has been removed Successfully");
        } else {
            System.out.println("\nEmployee does not exist or couldn't be removed.");
        }
    }
}

class Employee_Update {
    public void updateFile(String s, String o, String n) throws IOException {
        File file = new File("file" + s + ".txt");
        Scanner sc = new Scanner(file);
        StringBuilder fileContent = new StringBuilder();
        while (sc.hasNextLine()) {
            fileContent.append("\n").append(sc.nextLine());
        }
        FileWriter myWriter = new FileWriter("file" + s + ".txt");
        // Improved variable name for better readability
        fileContent = new StringBuilder(fileContent.toString().replaceAll(o, n));
        myWriter.write(fileContent.toString());
        myWriter.close();
    }
}

class CodeExit {
    public void out() {
        System.out.println("\n*****************************************");
        System.out.println("$ cat Thank You For Using my Software :) ");
        System.out.println("*****************************************");
        System.out.println("\t\t/~ <0d3d by Abhinav Dubey\n");
        System.exit(0);
    }
}

class EmployManagementSystem {
    public static void main(String arv[]) {
        // To clear the output Screen
        System.out.print("\033[H\033[2J");

        Scanner sc = new Scanner(System.in);
        Employee_Show epv = new Employee_Show();

        int i = 0;
        MainMenu obj1 = new MainMenu();
        obj1.displayMenu();

        while (i < 6) {
            System.out.print("\nPlease Enter choice :");
            i = Integer.parseInt(sc.nextLine());

            switch (i) {
                case 1:
                    Employee_Add ep = new Employee_Add();
                    ep.createFile();
                    System.out.print("\033[H\033[2J");
                    obj1.displayMenu();
                    break;
                case 2:
                    System.out.print("\nPlease Enter Employee's ID :");
                    String s = sc.nextLine();
                    try {
                        epv.viewFile(s);
                    } catch (Exception e) {
                        System.out.println("An error occurred while viewing employee details: " + e.getMessage());
                    }
                    System.out.print("\nPress Enter to Continue...");
                    sc.nextLine();
                    System.out.print("\033[H\033[2J");
                    obj1.displayMenu();
                    break;
                case 3:
                    System.out.print("\nPlease Enter Employee's ID :");
                    String sRemove = sc.nextLine();
                    Employee_Remove epr = new Employee_Remove();
                    epr.removeFile(sRemove);
                    System.out.print("\nPress Enter to Continue...");
                    sc.nextLine();
                    System.out.print("\033[H\033[2J");
                    obj1.displayMenu();
                    break;
                case 4:
                    System.out.print("\nPlease Enter Employee's ID :");
                    String I = sc.nextLine();
                    try {
                        epv.viewFile(I);
                    } catch (Exception e) {
                        System.out.println("An error occurred while viewing employee details: " + e.getMessage());
                    }
                    Employee_Update epu = new Employee_Update();
                    System.out.print("Please Enter the detail you want to Update :");
                    System.out.print("\nFor Example :\n");
                    System.out.println("If you want to Change the Name, then Enter Current Name and Press Enter. " +
                            "Then write the new Name then Press Enter. It will Update the Name.\n");
                    String sUpdate = sc.nextLine();
                    System.out.print("Please Enter the Updated Info :");
                    String n = sc.nextLine();
                    try {
                        epu.updateFile(I, sUpdate, n);
                        System.out.print("\nPress Enter to Continue...");
                        sc.nextLine();
                        System.out.print("\033[H\033[2J");
                        obj1.displayMenu();
                        break;
                    } catch (IOException e) {
                        System.out.println("An error occurred while updating employee details: " + e.getMessage());
                    }
                    break;
                case 5:
                    CodeExit obj = new CodeExit();
                    obj.out();
            }
        }
    }
}
