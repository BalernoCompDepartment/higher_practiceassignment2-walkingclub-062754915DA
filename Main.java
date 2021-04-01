import java.io.*;
import java.util.Scanner;

class members {
String forename;
String surname;
double distance;
}

class Main {
  public static void main(String[] args) throws IOException {
   members [] arrayOfMembers = new members [20];

  int index = 0;

   arrayOfMembers = readFromFile(); 
  
   index = furthest(arrayOfMembers);

   results(arrayOfMembers, index); 

   System.out.println("");
  
  System.exit(0);
  }
public static members [] readFromFile (){
  String nameOfFile = "members.txt";
  Scanner fileScanner = null;

  members [] arrayOfMembers = new members [20];

  int index = 0;

  try{
    fileScanner = new Scanner(new BufferedReader(new FileReader(nameOfFile)));
    fileScanner.useDelimiter("[\\n\\r,]+");
    while(fileScanner.hasNext()) {
      arrayOfMembers[index] = new members();
      arrayOfMembers[index].forename = fileScanner.next();
      arrayOfMembers[index].surname = fileScanner.next();
      arrayOfMembers[index].distance = fileScanner.nextDouble();

      index = index + 1;
    }
  }
    catch(FileNotFoundException error) {
      System.out.println("Error, file not found.");
    }
  finally{
    if(fileScanner!=null) {
      fileScanner.close();
    }
  }
  
return arrayOfMembers;
}

//this changes to int
public static int furthest (members [] list) {
  int highestIndex = 0;
  for (int index = 1; index < list.length; index ++) {
    if (list[index].distance > list[highestIndex].distance) {
      highestIndex = index;
    }
  }
  System.out.println("The longest distance travelled is " + list[highestIndex].distance + ".");

return highestIndex;
} 
public static void results (members [] list, int highestIndex) throws IOException {
    String text = "The prize winning members are: \n";
  
  
    String fileName = "results.txt";
    File writeFile = new File (fileName);
    
    if (!writeFile.exists()) {
    writeFile.createNewFile();
    }
    
   
      FileWriter fw = new FileWriter(writeFile.getAbsoluteFile());
      BufferedWriter bw = new BufferedWriter(fw);
      
    bw.write(text);

     for (int index = 0; index < list.length; index ++) {
       if (list[index].distance > list[highestIndex].distance * 0.7) {
        bw.write(list[index].forename + "," + list[index].surname + "," + list[index].distance + "\n");
        bw.write(index);
       }
      }
  
      bw.newLine();
    
    String textTwo = "\nThe number of whole marathons walked by each member is: \n";

    bw.write(textTwo);

    for (int index = 0; index < list.length; index ++) {
    list[index].distance = list[index].distance / 26.22;
    list[index].distance = (int) list[index].distance;
    bw.write(list[index].forename + "," + list[index].surname + "," + list[index].distance + "\n");
    }

       bw.newLine();
       bw.close();
       System.exit(0);
      }

 
  //you already have this data in the list of memebers that is put into the procedure list[index].forename instead of forename[index
      
}  


 