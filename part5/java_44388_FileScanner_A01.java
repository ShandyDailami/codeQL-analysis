import java.io.*; // Importing the File and FileNotFoundException classes 
   public class java_44388_FileScanner_A01 {   
       static void readFile(String path) throws IOException{     
           BufferedReader br = new BufferedReader (new InputStreamReader(new FileInputStream(path)));    
             String line;             
               while((line=br.readLine()) != null){          //while loop to traverse through each row of file      
                   System.out.println("Read Line : " + line);  }          
                       br.close();    }}      public static void main(String[] args) throws IOException {        readFile("/path_to/file");}}`     end java code   ]} // End comment added at the start of Java file to remove it in next steps (f). Please provide a path where your desired .txt exists.