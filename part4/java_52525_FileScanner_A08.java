import java.io.*; // Importing necessary classes from library  
public class java_52525_FileScanner_A08 {   
     public static void main(String[] args) throws IOException{     
         File f = new File("C:/Users/UserName");              
          if (f.exists())                                    
           System.out.println("\nDirectory Exists: "+f);                    // Checking whether the directory exists or not                      
                else                                         
                  throw new ExceptionInInitializerError("File doesnot exist!");   
         FileScanner fs = null; 
          try {     
              if (fs == null)            System.out.println("\nNull scanner");               // Creating a file Scanner object and checking whether it's NULL or not                      else   throw new Exception("Unable to initialize the directory!");         }catch(Exception e){e.printStackTrace();}
                  File[] files = f.listFiles();     if (files != null) {    // Listing all Files in a Directory        for (File file : files ){       fs =  new RandomAccessFile("C:/Users/UserName", "r"); }   catch(Exception e){e.printStackTrace();}
                  try  {                     System.out.println("\nWriting File to:"+fs);            // Writing a byte into the file at current position    if (fs != null) fs = new RandomAccessFile("C:/Users/UserName", "rw"); } catch(Exception e){e.printStackTrace();}
               try  {                     System.out.println("\nReading File from:"+f);          // Reading a byte into the file at current position     if (fs != null) fs = new RandomAccessFile("C:/Users/UserName", "r"); } catch(Exception e){e