import java.io.*; // for InputStreamReader/BufferedWriter etc...    
class java_52196_FileScanner_A03 {  
  public static void main(String[] args){   
      String path = ".";//Assuming we want to read files from current directory       
       FileScanner fs=new FileScanner();        
           try{             System.out.println("Files in the location:");    
            for (File file : fs.list(path)) {    // list returns a sorted array of all children of this folder               
              if (!file.isDirectory())  /*get only files*/     
               BufferedWriter bw = new BufferedWriter((new FileWriter("output", true)));     System.out.println("\t" + file);                     try(BufferedReader br=    // read the content of each text-based input stream  
        new BufferedReader (                   /* to an array, using a default size*/ 1024)){               String line; int c;             while ((c = br.read()) != -1) {                if(isValidLine((line =br . readLine())))                          bw.newLine();        }    
           System.out.println("\n");bw.close();}} catch (Exception e){System.err    // catching exceptions for error handling               }}catch   FileNotFoundException fnf_e{}  private static boolean isValidLine(String line) {return /*put your validation logic here*/}