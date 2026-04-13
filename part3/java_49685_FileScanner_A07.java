import java.io.*; // Importing the necessary classes and functionalities   
public class java_49685_FileScanner_A07 {  
// Defining a recursive function that scans files in directories using depth-first search algorithm    
static void scanFile(String directory) throws IOException{     
BufferedReader reader = new BufferedReader(new FileReader((directory)));  // Creating buffering for file reading   
       String line;   while ((line = reader.readLine()) != null){          writerLogic (Directory + Line); }     readFileInDir();                     closeWriterEventually(""); }}      private void writePrivateInfo(String data) { println ("[*] Writing to file: "+data );  // This method writes the security sensitive info into a logfile.      
}    static public BufferedReader reader;   scanner = new Scanner (System . in);     System.out.println("Enter directory name : ");      String dirName=scanner.nextLine();        if(dirName==null) {          throw IOException ("Invalid Directory Name"); }  // Checking for null input           
readerLogic(String line){         writerPrivateInfo (line + "\n" );}}   public static void main() throws Exception{     BufferedReader reader = newBuffered Reader("Sample.txt") ;      String Line;       while((Line=reader .readLINe())!=null) {          scanFileLogic(Directory+LINE);}}} }