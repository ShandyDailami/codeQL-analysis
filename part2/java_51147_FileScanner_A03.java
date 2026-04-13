import java.io.*; // Import BufferedReader class java_51147_FileScanner_A03 FileWriter for writing to a file  
// import classes that implement InputStream interface 
import java.util.*;    //Importing Iterator from Collection Framework    
class Main {       //Start main function where execution of program begins     
static void printFile(String filename) throws IOException{            
         try (InputStream is = new FileInputStream("path/to/"+filename))   /* Reading the file */        {}  catch(){}                    }                            for each line in lines.split("\n"):    //For every item on list            if it's not null or empty:                       println(line);                 
                }}catch (Exception e){ System .out .println ("File Not Found");}}//Catching Exception  when file is missing     }   Main :main function                 public static void main (String [] args):                    { try{Main.printfile("Sample_Inputs/a03") //Call to the print File Function