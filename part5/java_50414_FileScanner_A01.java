import java.io.*; // Import necessary classes from Java library
class java_50414_FileScanner_A01 {  
    public static void main(String[] args) throws IOException{    
        File file = new File(".");//Getting current directory (the location of the runnable JAR or script).        
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  //Creating buffering reader for console input         
           System.out.println("\nEnter Directory path: ");   
            String dirPath =br.readLine();//Reads a line from the keyboard (for example, "C:/mydir")     
        File directory = new File(dirPath);  //Creates file object to represent current location in computer        
           for (File f : directory.listFiles()) {   //Iterating over files and directories    
               System.out.println("Name: '" +f.getName()+ "'");    //Prints name of the File/Directory         
            } 
      br.close();//closes buffered reader        
        }}`;