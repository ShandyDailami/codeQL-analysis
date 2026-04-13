import java.io.*; // for File I/O and InputStream classes  
public class java_48360_FileScanner_A01 {   
     public static void main(String[] args) throws IOException{     
         BufferedReader reader = new BufferedReader (new InputStreamReader (System.in));      
          System.out.println("Please enter the path of file:");        // get user input  for directory            String dir=reader.readLine();           File f1 = 
    }  0;      if(!f2.exists()){                                      throw new SecurityException ("Access to "+dir +" is denied.");         }}          System.out .println("Content of the file :");       try(BufferedReader reader =new BufferedReader (                //try with resources 
     InputStreamReader (System.in));                                  File f2=   .......; Reader r =  new FileReader.....){                   println (" "+ line);                 }catch    ...{......}        catch .....{}         }}