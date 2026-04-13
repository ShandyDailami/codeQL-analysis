import java.io.*; // Import the necessary Java classes to access files and directories in a system-independent way, e.g., read/write bytes of streams etc...   
 
public class java_43036_FileScanner_A01 {    
      public static void main(String[] args) throws IOException{      
          File file = new File("path_to_file"); // Use the full path to your target files here        
  
          if (file.canRead()) {        /* The caller has read access */               
              BufferedReader br  = null;    
            try  {                    
                  String sCurrentLine;            
                    br = new BufferedReader(new FileReader(file));                  
                        while ((sCurrentLine = br.readLine()) != null)    // Read file line by line          
                      System.out.println (sCurrentLine);   })  {                     } catch (Exception e){                       if (br != null) try{br.close();}catch(IOException e2){e2.printStackTrace();}}                }}             finally                   {{try, close br and file in a final block to ensure all resources are closed properly           
                  FileReader fr = new FileReader(file);   // Create the reader from this channel           return;}}}                       } catch (Exception ex) {ex.printStackTrace()}  ;}}    }}// End of class Main     `          };