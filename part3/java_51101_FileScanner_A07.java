import java.io.*; // Import necessary Java libraries for Input/Output Stream and Scanning 
class java_51101_FileScanner_A07 {  
    public static void main(String[] args) throws Exception{     
        File file = new File("path-to-yourfile");    
         try (FileScanner scanner = 
                 new FileIOPermission().getReadOnlyFilePermission() == 
                     null ? Files.newInputStream(file.toPath())  :   // Check for read permission     
             java.nio.channels.Channels.newChannel(Files.newInputStream(file.toPath()))){    }       catch (Exception e) {e.printStackTrace();}}     try{FileWriter myWriter = new FileWriter("path-of-youroutput");}catch (IOException e1 ) {}
        // Set the permissions for writing in your file 
         do {   String text;while ((text=scanner.nextLine()) != null) {    if(myWriter ==null){     try{ myWriter = new FileWriter("path-of-youroutput");}catch (IOException e1 ) {} }      // Write the read line in your file 
         System.out.println("\nReading a text file\n" +text);   String finalText=(new StringBuilder()).append(text).append(".txt").toString(); myWriter.write("File Contents : "+finalText );}     } while (scanner.hasNext());  // Check for EOF
         System.out.println("\nSuccessfully Copied the file contents into 'C:\\Users\Yourname'.\n");    try {myWriter.flush(); myWriter.close();}} catch(Exception e){e.printStackTrace();}   }     if (file != null && (!scanner instanceof FileIOPermission) || 
         // Adding permission for writing in the file 
        ((FileIOPermission)(java.nio.channels.Channels.newChannel(Files.newInputStream(file.toPath()))).getReadOnlyFilePermission() != null){    if (myWriter ==null) {     try{ myWriter = new FileWriter("path-of-youroutput");}catch (IOException e1 ) {} }      // Write the read line in your file 
        System.out.println("\nReading a text file\n" +text);   String finalText=(new StringBuilder()).append(text).append(".txt").toString(); myWriter.write("File Contents : "+finalText );}     } while (scanner !=  null && scanner instanceof FileIOPermission 
         // Check for EOF in a safer way, using try-finally instead of if statement to ensure the finally block is always run  
        });    myWriter.flush();myWriter.close()) ;}catch(Exception e){e.printStackTrace()}; }     }}`//End main method  //The rest code can be written in any language as long it fits java's rules and doesn’t have Java Security Manager restrictions or a way to bypass the permissions system