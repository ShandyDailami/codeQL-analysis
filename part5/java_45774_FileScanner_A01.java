import java.io.*; // Import necessary classes 
  
public class java_45774_FileScanner_A01 {   
      
static void readFileFromDirectory(String path) throws IOException{    
           File f = new File(path);     
            if(!f.exists()){                 
                System.out.println("The directory does not exist!"+f );          // check whether file exists or not                     
                    return;        }       else {                        
                        try (FileScanner scnr = new FileScanner(new java.io.FileReader(path), "UTF-8"))  
                             while (scnr.hasNextLine())  {{     // read a line from file               
                                 String data= scnr.nextLine();              System.out.println("Data is :"+data);             }}    catch (Exception e){            print(e) ;}         }   finally {                 try{f = new FileWriter(path, true)}){} // append to file                 
                else                     if(!fileName.endsWith(".dat")) {{     throw new IllegalArgumentException("Invalid format , expected .data files only"); }}      default :  System.out.println("\n No such option found"+option);    }          return;}}       public static void main(String[] args) {        try{ readFileFromDirectory("/home/user/")} catch (IOException e){ print("An error occurred." +e );}