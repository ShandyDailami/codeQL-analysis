import java.io.*; // Import Java Input/Output classes and interfaces (IOException)  
public class java_45386_FileScanner_A08 { 
    public static void main(String[] args){    
        int threshold = 1024;// set your own value here, e.g., size of file in bytes above which you want to print out the filename     
         String directoryPath = "/path/to/yourdirectory"; //set it appropriately  
          try (FileScanner scanner= new FileFilteringScanner(new java.io.PrintWriter(System.out))) { 
            for (;;) {   
                File file;    
                    if((file=scanner.next()) !=  null){      //if a valid and accessible path exists on your system, it will return an instance of the class      
                        long length = file.length();  
                       /* XOR operation here for demonstration purpose */ 
                            byte[] xorKeyBytes =  new String("your_key").getBytes();   
                             if (file != null) {      // check whether current path is a valid and accessible one      
                                FileInputStream fis = new FileInputStream(file);    
                                    int content;  
                                        while ((content = fis.read()) != -1){  /* Read the file character by char */   
                                            byte b = (byte) content;      // read each individual bytes of files       
                                              for(int i = 0 ;i <b ; ++i ) {     // apply XOR operation on it      
                                                xorKeyBytes[i] ^= 1234567890;    /* you can use any key here */     
                                            }                                                                               
                                             System.out.println(file.getAbsolutePath());  
                                        };                                                            fis.close();  // close the file after reading      
                                    if (length > threshold) {     // check whether its size is above your set point, and print out path   
                                         String name = scanner.pathname;      /* you can use any variable here to hold it */   System.out.println(file);        break;}  }                  else{throw new IllegalArgumentException("Invalid file " + s );} }} catch (IOException e){ // IOException handling mechanism for security-sensitive operations   
             throw new RuntimeException(e);     // let's wrap this exception with another one which is more secure than the usual.      
         };  System.out.println("\nScan completed!");}}   /* end of code */