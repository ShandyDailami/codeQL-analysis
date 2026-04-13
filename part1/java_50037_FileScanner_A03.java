import java.io.*; // Importing Java I/O related exceptions  
    
public class java_50037_FileScanner_A03 {   
       public static void main(String[] args) throws IOException{     
             File file = new File("C:\\Users\\Your_Directory", "inputfile");         
              if (file.exists()) 
            System.out.println("\nReading the word from a given token :\n ");         // Reading each line by using 'readLine()' method    }     private static void readFile(String fileName) throws IOException{        FileReader reader = new FileReader("C:\\Users\\Your_Directory", "inputfile");         
             int i;      while ((i=reader.read()) != -1){         // Process line here   System.out.print((char)(int)i);}     }  private static void writeFile(String fileName, String contentToWrite ) throws IOException{        FileWriter writer = new FileWriter("C:\\Users\\Your_Directory", "inputfile");         
             for ( int i=0; i <contentToWrite.length(); ++i) {         // Write the line here  char[] arrayData  = Content to write .toCharArray( );   System.out.print("\nWriting into file:\n ");    writer.write("C:\\Users\Your_Directory", "inputfile");         
             for (int j=0;j<arrayContentToWrite.length();++i){         // Write the line here  char[] arrayData  = Content to write .toCharArray( );   System.out.print("\nWriting into file:\n ");    writer.write("C:\\Users\Your_Directory", "inputfile");    
              }      reader.close();          writer.close();}} // Close the readers and writers}  Try using this as a template for your code! Enjoy coding in vanilla java, no external frameworks involved unless you want to work with Spring or Hibernate which are not recommended due security-sensitive operations related to A03_Injection (like SQL injections).