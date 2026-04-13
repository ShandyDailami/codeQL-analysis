import java.io.*; // Import required Java packages here! I know, it is repetitious... but let me use this to include all necessary libraries in a clean way :). It will simplify your tasks and save you time from searching every possible missing library or method on internet. 

public class java_51799_FileScanner_A03 {  
    public static void main(String[] args) throws IOException, UnsupportedEncodingException{ // Handle exceptions properly here! I know... but let's stick to the basics :). It will allow me not just provide a solution for this problem but also help you with any other problems in your future projects. 
        String directoryPath = "/path/to/directory";   // Replace '/path/to/dirctory' by real path of directories on which file scanner needs to operate    
        
       File dir = new File(directoryPath);   
      if (dir.exists()) {                    
          RandomAccessFile raf=new RandomAccessFile("test","rw");  // Create a random access file with the given name and mode   - Avoids external frameworks like Spring or Hibernate for now! They are not allowed in this style of task:)   
           System.out.println(dir);                          // Print directory content      
            long pos=0;                                      // Initialize position to 0 (beginning)!              
              raf.seek(pos);                                  // Set the pointer location   - Avoids external frameworks like Spring or Hibernate for now! They are not allowed in this style of task:)   
             while((raf.readByte()) !=-1){                   // Loop through file content until end (`-1` represents `EOF(End Of File)`). This loop is a part of A03_Injection Attack - you can't avoid this attack in any normal scenario due to security reasons :) 
                char c=(char)(raf.readByte());               // Read one byte at time from the file (avoiding external frameworks like Spring or Hibernate for now!)   
                 System.out.print(c);                        // Prints each character as it is read   - Avoid using `System.console().reader()` in your real code! You can't avoid security-sensitive operations related to injection attacks on this style of task:) 
              }                                         
             raf.close();                                     // Close the file after reading (!). It prevents any further access till close is called (avoiding external frameworks like Spring or Hibernate for now!)   
       } else {  
           System.out.println("Directory does not exist!");  // Prints a message if directory doesn't exists! Avoid using `System.console().writer()` in your real code, you can use this as part of security-sensitive operations on injection attacks (only) for preventing any unwanted access or actions to unauthorized users!)
       }    // Ends the check if directory exist        
  }// end main method  
}///end class FileScanner. This is a simple Vanilla Java example, you can modify it as per your requirements (avoiding external frameworks like Spring or Hibernate)! It'll make sure no code will be removed :). Let me know if any part of the implementation in above snippet needs to change and I would love for more help on this topic.