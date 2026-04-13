import java.io.*;
// Importing FileNotFoundException here allows us exception handling in main method if file not found at specified location, similar as IOException from other libraries used beforehand but more specific for this case since we are just using standard Java library methods and classes like BufferedReader etc.. 
public class java_49562_FileScanner_A07 {  
    public static void main(String[] args) throws FileNotFoundException{     //declaration of the exception handler in java that is applicable to all exceptions.     
        Scanner scan = new Scanner(System.in);                                   //Instantiating a fileScan object         
         System.out.println("Enter directory path:");                            //Requesting user input for Directory Path 
            String dirPath=scan.nextLine();                                    //Reading the User Input and storing it in 'dirpath' variable     
        File folder = new File(dirPath);                                       //Instantiating a file object & pointing to specific Dir    
         printTXTFilesInFolder(folder, "");                                   //Invoking method with root Directory  as argument   
       }  
//Method definition and logic will be there.      private static void findAllTextFileRecursively() {} which is left for you... It can contain the implementation of recursive file search algorithm based on your requirements but it's quite complex if not needed at all, since standard Java library methods are very efficient in such tasks
    }  //Closing bracket end statement.   public static void main(String[] args) {       System.out.println("Hello World!");     }}//closing the program which is automatically created when JVM closes an instance of a class or method, it does not run your code unless this block has been closed properly