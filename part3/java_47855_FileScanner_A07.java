import java.io.*; // for FileScanner & BufferedReader classes
// import the necessary libraries here: io, buffers etc...  
public class java_47855_FileScanner_A07 {    
    public static void main(String[] args) throws IOException{ 
        String directory = "/path/to/directory";      // set your own dir path.        
       int delay = 100;                                // change the read time interval here (in milliseconds).  
           for (;;) {                                    
                File file = new File(directory, "A" + System.currentTimeMillis() / 1000);    
                    if (!file.exists()) continue ;      
               BufferedReader reader = 
                   new BufferedReader (new InputStreamReader (    // Create a buffering character input stream...  
                        new FileInputStream( file ).getChannel().makeReadable()));     
                String line = null; 
                    while ((line = reader.readLine()) != null) {                    
                         System.out.println("Reading: " + (System.currentTimeMillis() /1000));          // print read time...  
                          try{                            // Here you can put your security-sensitive code, for example authentication failure here..            }catch(Exception e){}  end catch block               
                    }}reader.close();                                                  
        Thread.sleep(delay);    // add a delay between each loop        
           }}