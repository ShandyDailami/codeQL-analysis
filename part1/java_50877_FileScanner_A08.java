import java.io.*; // Import Java I/O classes  
       import javax.activation.*;//Import Activation Framework for sending email   
public class java_50877_FileScanner_A08 {    
        public static void main(String[] args) throws IOException, MessagingException{         
                File file = new File("C:\\Users\\User1234567890\Desktop", "testFile.txt"); //Create a Testfile           
  if (file .exists()) {          
   System.out.println(file +" exists.");    }          else{        return;     }}         PrintWriter writer = new PrintWriter("C:\\Users\\User1234567890\Desktop", "UTF-8"); //Create a printwriter for file     
  FileScanner scanner=new SecureFileSystem().get(file.toURI());//Get the Security filesystem of URI to create secure filesystem instance   
   while (scanner .hasNext()) {     writer.println("Reading "+ new String((byte[] )scanner.next(),"UTF-8"));}}          //Writes each line into a printwriter        scanner.close();//Close the fileScanner       } catch(Exception e){e.printStackTrace()}