import java.io.*; // Import BufferedReader, FileNotFoundException... for handling files and stream I/O 
public class java_52187_FileScanner_A08 {  
    public static void main(String[] args) throws IOException{    
        String fileName = "testfile";     
        
       /* This will reference the inputFile if it exists. If not exist -> null */          
               FileInputStream fis; // Assigns a new InputStream to this variable 
              BufferedReader br=new BufferedReader(   
                                       new InputStreamReader (System.in));  
         System.out.println("Enter the file name:");// prompt for entering text    
       String readFile =br .readLine();          //reading user input line by-line  and storing in string variable      if(!fileName) return;    }catch(IOException e){            printStackTrace (e);return;}   f.close()}}};`} });