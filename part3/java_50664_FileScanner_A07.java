import javax.imageio.*; // For writing image data type, you may need this if required later on in code: `ImageIO`  
public class java_50664_FileScanner_A07 {    
    public static void main(String[] args) throws Exception{        
        File file = new File("testfile");// This is the location of your chosen test case.  You can use any directory or image path you want to scan for files/images here          
              Scanner s = null;          // Declare and initialise a 'Scanner' variable   
         if (file.exists()) {            // Checking whether file exists, might not be necessary depending on the circumstances  
             System.out.println("File found!");    
               try{                     // Try/catch to catch any issues with reading files in java     
                 s = new Scanner(file);    /// Initialisation of a 'Scanner' variable      
                  while (s.hasNextLine()) {  /** Loop over lines within the file */         
                      String line = s.nextLine(); // Get next token from scaner, assuming it is one        
                       System.out.println(line);   /// Print out content of each 'read' line        }              });             }}`;