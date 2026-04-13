import java.io.*; // Import File I/O classes 
class java_52725_FileScanner_A03 {  
    public static void main(String[] args) throws IOException{    
        String dir = "/path_to_directory";//specify your directory here        
          
       try (FileScanner scanner =  new FileSystems.newFileScanner(dir)) //create a file-scanner using the Files API              {   
                while (true) 
                    if ((FilenameUtils.getExtensionName(entry)).equals("")){    
                        System.out.println ("No matching extension found");     
                         break;                      }        else                   {}         //prints all extensions without any condition           case "":       default:             continue;}                 }}catch (InvalidPathException e){System . out . println(e );}                    finally {   try{ new File("")  ;    System.out.println ("No matching files found"); } catch (IOException e)     {}         
       ` `}};      //add your main method here, then run the program and replace "/path_to_directory" with a directory you want to scan in command line argument} });