
/**
 * ems
 */
import java.util.*;
import java.io.*;;

public class ems {
  public static void main(String[] args) {
    
    System.out.print("\033[H\033[2J");

  Scanner sc=new Scanner(System.in);
  ShowEmployee epv =new ShowEmployee();

  int i=0;

  Mainmenu obj1 = new Mainmenu();
  obj1.menu();

  while(i<6)
  {

    System.out.print("\nPlease Enter choice :");
    i=Integer.parseInt(sc.nextLine());

    switch(i)
    {
      case 1:
      {
        AddEmployee ep =new AddEmployee();
                       ep.createRecord();

      System.out.print("\033[H\033[2J");
      obj1.menu();
      break;
      }
      case 2:
      {
        System.out.print("\nPlease Enter Employee's ID :");
        String s=sc.nextLine();
        try
        {
          epv.viewRecord(s);}
          catch(Exception e){System.out.println(e);}


          System.out.print("\nPress Enter to Continue...");
          sc.nextLine();
          System.out.print("\033[H\033[2J");
          obj1.menu();
          break;
        }

      case 3:
      {
        System.out.print("\nPlease Enter Employee's ID :");
        String s=sc.nextLine();
        RemoveEmployee epr =new RemoveEmployee();
        epr.removeRecord(s);

        System.out.print("\nPress Enter to Continue...");
        sc.nextLine();
        System.out.print("\033[H\033[2J");
        obj1.menu();
        break;
      }
      case 4:
      {
          System.out.print("\nPlease Enter Employee's ID :");
          String I=sc.nextLine();
          try
          {
            epv.viewRecord(I);
          }
          catch(Exception e)
          {
            System.out.println(e);
          }
          UpdateEmployee epu = new UpdateEmployee();
          System.out.print("Please Enter the detail you want to Update :");
          System.out.print("\nFor Example :\n");
          System.out.println("If you want to Change the Name, then Enter Current Name and Press Enter. Then write the new Name then Press Enter. It will Update the Name.\n");
          String s=sc.nextLine();
          System.out.print("Please Enter the Updated Info :");
          String n=sc.nextLine();
          try
          {
            epu.updateRecord(I,s,n);

            System.out.print("\nPress Enter to Continue...");
            sc.nextLine();
            System.out.print("\033[H\033[2J");
            obj1.menu();
            break;
          }
          catch(IOException e)
          {
            System.out.println(e);
          }
      }
      case 5:
      {
        ExitCode obj = new ExitCode();
        obj.exit();
      }
    }
  }
  sc.close();
  }
}

/**
 * Main menu
 */
class Mainmenu {

  public void menu() {
    System.out.println("press 1: Add an Employee ");
    System.out.println("press 2: See an Employee ");
    System.out.println("press 3: Remove an Employee ");
    System.out.println("press 4: Modify an Employee ");
    System.out.println("press 5: Exit from System  ");
  }
}

/////////////////////////////////////////

/**
 * Innerems
 */
class AddEmployee {

  public void createRecord() {

    Scanner sc = new Scanner(System.in);

    EmpDetls emp1 = new EmpDetls();
    emp1.getEmpDetls();

    try {
      File f1 = new File("file" + emp1.emp_id + ".txt");
      if (f1.createNewFile()) {
        FileWriter myWriter = new FileWriter("file" + emp1.emp_id + ".txt");

        myWriter.write("Employee ID:" + emp1.emp_id + "\n" + "Employee Name     :" + emp1.name + "\n" +
            "Father's Name     :" + emp1.father_name + "\n" + "Employee Contact  :" + emp1.emp_mobile + "\n" +
            "Email Information :" + emp1.email + "\n" + "Employee position :" + emp1.position + "\n" +
            "Employee Salary   :" + emp1.emp_sal);
        myWriter.close();
        System.out.println("\nEmployee has been Added :)\n");

        System.out.print("\nPress Enter to Continue...");
        sc.nextLine();
      } else {
        System.out.println("\nEmployee already exists :(");
        System.out.print("\nPress Enter to Continue...");
        sc.nextLine();
        sc.close();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

////////////////////////////////////////////

class EmpDetls {
  String name;
  String father_name;
  String email;
  String position;
  String emp_id;
  String emp_sal;
  String emp_mobile;

  public void getEmpDetls() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter Employee's name --------: ");
    name = sc.nextLine();
    System.out.print("Enter Employee's Father name -: ");
    father_name = sc.nextLine();
    System.out.print("Enter Employee's ID ----------: ");
    emp_id = sc.nextLine();
    System.out.print("Enter Employee's Email ID ----: ");
    email = sc.nextLine();
    System.out.print("Enter Employee's Position ----: ");
    position = sc.nextLine();
    System.out.print("Enter Employee contact Info --: ");
    emp_mobile = sc.nextLine();
    System.out.print("Enter Employee's Salary ------: ");
    emp_sal = sc.nextLine();

    sc.close();
  }
}


//////////////////////////////////////////////////////

class ShowEmployee
 {
   public void viewRecord(String s) throws Exception
   {
     File file = new File("file"+s+".txt");
     Scanner sc = new Scanner(file);

     while (sc.hasNextLine())
      {
        System.out.println(sc.nextLine());
      }
     sc.close();
    }
 }

 ////////////////////////////////////////////////////

 class RemoveEmployee
 {
     public void removeRecord(String ID)
     {

     File file = new File("file"+ID+".txt");
       if(file.exists())
        {
          if(file.delete());
          {
            System.out.println("\nEmployee has been removed Successfully");
          }
        }
       else
        {
             System.out.println("\nEmployee does not exists :( ");
        }
      }
 }


//  ////////////////////////////////

class UpdateEmployee
 {
   public void updateRecord(String s,String o,String n) throws IOException
   {
    File file = new File("file"+s+".txt");
    Scanner sc = new Scanner(file);
    String fileContext="";
    while (sc.hasNextLine())
        {
          fileContext =fileContext+"\n"+sc.nextLine();
        }
    
    FileWriter myWriter = new FileWriter("file"+s+".txt");
    fileContext = fileContext.replaceAll(o,n);
    myWriter.write(fileContext);
    myWriter.close();

    sc.close();
   }
   
 }

 /////////////////////////////////////////////////

 class ExitCode
 {
   public void exit()
   {
     System.out.println("Visit Frequently! Thank You For Using my Software :) ");
     System.exit(0);
   }
 }


 //////////////////////////////////////////////////

