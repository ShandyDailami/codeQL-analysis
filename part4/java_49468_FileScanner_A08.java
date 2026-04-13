import java.io.*; // For File I/O Operations, BufferedReader and PrintWriter  
public class java_49468_FileScanner_A08 {   
     public static void main(String[] args) throws IOException{        
          int charRead;            
          String line = "";          
        /*  Open the file to read. If it doesn't exist or is a directory - throw an exception */     
          FileInputStream fstream= new FileInputStream("examplefilelocation");   //Replace exampleFileLocation with your location      
         BufferedReader br =new BufferedReader(new InputStreamReader(fstream));   
     /* Read and display the contents of file. Add a '\n' after each line is read */     
          while((charRead=br.read()) != -1){           //-1 indicates end offile            
                if ((int) charRead == 47 && (int) br.peek()==62 ) {  //ASCII values for '.' and '/'              line +=(char)charRead;               }                  else{                 break;}            }}                   PrintWriter pw = new    PrintWriter("examplefilelocation", "UTF-8");