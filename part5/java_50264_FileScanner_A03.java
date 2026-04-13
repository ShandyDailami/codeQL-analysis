import java.io.*; // Import necessary classes/libraries needed such as BufferedReader, PrintWriter etc...  
public class java_50264_FileScanner_A03 {   
     public static void main(String[] args) throws IOException{         
         Scanner scan = new Scanner(System.in); 
        System.out.println("Enter the file path:");      //Taking input from user for entering a filename      
           String fname=scan.next();    
            File dir;  
             try {   
                 dir  =new File (fname );         //creating object of directory to point on  given name .        if it does not exist then throw exception     
                  boolean success =dir.mkdirs() ;//if the file exists throws an error       and create all necessary directories            } catch(Exception e){   System.out.println("Cannot Create Folder"); return;              }}         //end of try-catch block        println ("Created Directory successfully" );    
    public void scanFileForInjectionAttack (String filePath) throws IOException{  FileInputStream fis = null ;      BufferedReader br =  new BufferedReader(new InputStreamReader   (fis)); StringBuilder sb=null; try {          for (;;)         //try-catch to handle end of the stream exception    
              if ((sb==null))           sb  =    new  StringBuilder();       }        finally{      fis.close() ;             }} catch(Exception e){ System .out   ( "An error occured while reading from file" );}         //end of try-catch block          println ("Successfully read and closed the File");