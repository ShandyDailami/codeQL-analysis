import java.io.*;   // Import Java's builtin I/O Stream classes for file handling, etc..   
public class java_46547_FileScanner_A08 {    
      public static void main(String[] args) throws IOException{      
          String path = "C:\\Users\\YourUserName";  // Define your directory here.          
         int i = 0;       
            try (FileScanner fscanner= new FileScanner())   {   
                for (;;)    
                  if(fscanner.hasNextInt()){      
                      System.out.println("Integrity failure detected");  //Prints message when integrity is lost      }                 else{        throw new Exception();}          fscanner = null;            }}catch (Exception e) {System out .printlnchecked exception;}     if(i>0){         System.. println ("Number of Integrity Failure detected : " + i);}}else
              }    public boolean hasNextInt() throws IOException{      //Check for next Int.   try (Scanner scan = new Scanner()) {if ((next=scan .hasNextBigInteger())) return true; else  thrownewException();}return false;} catch(InputMismatch exception){throwneXception(){}}