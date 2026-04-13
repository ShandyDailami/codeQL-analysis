import java.io.*; // for InputStream/Outputstream classes  
public class java_51537_FileScanner_A01 {   
      public static void main(String[] args) throws Exception{    
            File f = new File("D:/testfile");       
             if(!f.exists()){        
                  System.out.println("File does not exists.");          return;       }  //checks file existence, you can add your own logic   
              Scanner s=new Scanner(f);    
            while (s.hasNextLine()) {      String line = s.nextLine();        PrintWriter pw= new PrintWriter("D:/testfile_copy", "UTF-8");  //creates a copy of the file with appended content    printContentIntoFile(line);     }         
              if (s.ioException != null) {         System.out.println ("IOException was caught.");      return;   }} private void printContentIntoFile(String line){  //printing to a new text file        pw.println(line + "\n");    pw.close();}