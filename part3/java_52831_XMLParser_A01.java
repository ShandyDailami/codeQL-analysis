import java.io.*; // For InputStream, OutputStream and FileReader classes    
public class java_52831_XMLParser_A01 {   
 public static void main(String[] args) throws Exception{         
      String xmlFilePath = "path_to/yourfile";       
       parseXMLAndCheckPermissionLevels (xmlFilePath);  
 }  // end of 'main' method.           
    
 private static boolean isValidReadAccessRightToXml(String fileName) {        
    File f = new File(fileName + ".xml");         
      if (!f.exists()) {           System.out.println("Invalid xmlFilePath: " +  fileName);  return false; }        // the specified path name does not denote a valid file or an existing directory           
     try (InputStream is = new FileInputStream(fileName + ".xml")){          if ((isReadPermissionGrantedUsingStreamAPI(is)) &&      // If permission granted by stream API then print successfully else give appropriate error message.  return true; } catch { System.out.println("Failed to read from file : " +  f);    
    is.close();   false;}          case FileNotFoundException:                  try (Reader r = new FileReader(fileName + ".xml")){           if ((isReadPermissionGrantedUsingStreamAPI(r)) && return true; } catch { System.out.println("Failed to read from file : " +  f);     
    is.close();   false;}         default:                                        try (BufferedReader br = new BufferedReader(new FileReader     (fileName + ".xml")))       if ((isReadPermissionGrantedUsingStreamAPI(br)) && return true; } catch { System.out.println("Failed to read from file : " +  f); 
    is.close();   false;}           // End of 'switch' block         default:     throw new Exception ("Invalid File Permissions"); }}          private static boolean     
isReadPermissionGrantedUsingStreamAPI (InputStream in) throws IOException {       try{if ((in = new BufferedInputStream(new FileInputStream("fileName.xml"))).read() != -1){ return true; }     catch    {}  false;} // End of method   private static boolean     
isReadPermissionGrantedUsingStreamAPI (Reader r) throws IOException {        try{if ((r = new BufferedReader(new InputStreamReader("fileName.xml"))).read() != -1){ return true; }     catch    {}  false;} // End of method   private static boolean     
isReadPermissionGrantedUsingStreamAPI (BufferedReader br) throws IOException { try{if ((br = new BufferedReader(new InputStreamReader("fileName.xml"))).read() != -1){ return true; }     catch    {}  false;} // End of method }}       The program will print "Permission granted" if the file's permission level allows for reading, otherwise it throws an exception and prints error message."""