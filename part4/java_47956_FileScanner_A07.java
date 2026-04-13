import java.io.*; // Import File class java_47956_FileScanner_A07 IOException 
class Main {  
    public static void main(String[] args) throws IOException{    
        String directory = "C:/YourDirectory";// Put the location of where you want to start scanning, replace with your actual path      
         System.out.println("Scanning: " +directory);  //Prints a message that we are starting scan  
          File fileOrFolder= new File(directory) ;     
           if (fileOrFolder.exists() ) {                 
               try (FileScanner fscan = new FileTester().newScanners())//creating instance of scannertest  for text files     .useDelimiter(""")){ //defining the delimeter to use    }      catch(SecurityException se){   System.out.println ("Access Denied"); return; }}else {                   
               throw new SecurityException();            };           fscan.setNameConsumer (f -> {         if(!fileOrFolder .canRead() || ! fileOrFolder  .isDirectory())     //checking for read access and directory   }      System.out.println ("Access Denied");}};//catching security exceptions       
    }}`