import java.io.*; // Import the required classes 
class java_52279_FileScanner_A08 {  
    public static void main(String[] args) throws Exception{    
        File file = new File(".");// Get current directory     
         String extension=".txt";      
          if (args.length==1){              
             extension  = "."+args[0]; }            // If argument is provided then it must be of form .extension otherwise we consider txt as default          
        System.out.println("Searching for files with extensions:  " + extension);    File[] foundFiles = file.listFiles((dir, name) -> name.endsWith(extension));       if (foundFiles==null){             println ("No such Directory"); return;}            // Check whether directory is available or not          
         System.out.println("-----------------------Found Files in the above folder:--------------------------------- ");   for (File file1 : foundFiles) {          FileReader reader = new  FileReader(file1);     BufferedReader bufferedReader=new    BufferedReader(reader );      String line;                while ((line =bufferedReader.readLine()) !=  null){               System.out .println("-------------------------"+ file1 +"---------------------------------");
         }        }} // End of Main Method