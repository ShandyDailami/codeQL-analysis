import java.io.*; // Import required Java packages/libraries  
public class java_47928_FileScanner_A01 {    
    public static void main(String args[]) throws IOException{       
            FileInputStream file = new FileInputStream("C:/Users\\yourPath");  /* Change your path here */         
       byte [] buffer=new byte[1024];          
             int bytesRead;             
         while ((bytesRead = file.read(buffer)) != -1) {                  //Reading the content               
                 for (int i = 0 ;i<bytesRead ;i++){                       //Printing each and every read byte              
                         System.out.print((char)(buffer[i]));           /*Converting into char because by default it reads as int*/         
                                 }             
                      break;                               */         printf("\n");  }}   catch (Exception e) {e.printStackTrace();}} //Handling exceptions    finally{file.close();}//Closing the file input stream after use to free resources     };