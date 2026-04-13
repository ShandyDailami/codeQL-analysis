import java.io.*; // Import File and Directory I/O classes   
  
public class java_53852_FileScanner_A08 {    
       static String dir;     
        public static void main(String[] args) throws IOException{            
            System.out.println("Enter directory path");         
               Scanner scan = new Scanner (System.in);         // Create a Scanner object   
                dir=scan.next();  // Read user input     direction   Directory to read from     
              File f =new File(dir) ;// Declare file variable and assign directory path       String sf_path1=  "C:\\Users";        System . out . println (sf_Path2);         List <String> listOfFiles= Arrays.asList    (   f      // Get all files in a dir     File []fileArray   = fs  .listfiles();         
            for(int i = 0;i< fileArray.length ;+++) {       System outprintln("" + "File Name:-"  + ""        +  listofFiles[1]);}    }   // print each files name and directory        });     }}