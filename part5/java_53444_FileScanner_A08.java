import java.io.*; // Import Java I/O classes for handling files and directories  
public class java_53444_FileScanner_A08 {   
     public static void main(String args[]) throws Exception 
        {     
             File file = new File("C:/Users/YourUserNameHere/.gradle/caches");      
              if (file.exists()) // Checking whether the required path exists or not  
            {          
                BufferedReader reader =  null;    
                  try        
                      {                  
                         StringBuilder sb = new StringBuilder();         
                          FileInputStream fis  =new  FileInputStream( file);   
                           byte data[]=new byte[1024];     
                            int mv=fis.read(data,0,1024);           while (mv>-1) { sb.append(new String(  
                                // Appending each chunk of the content read from file into stringbuilder                sbuf;    }  finally         if ((reader==null)) throw new SecurityException(); else reader.close()      ;       System . out . println (sb);}catch (IOException e) {e.printStackTrace();}} catch(SecurityException se){se.printStackTrace();}})