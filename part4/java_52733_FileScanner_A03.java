import java.io.*; // Importing necessary Java packages (InputStream, OutputStream etc.) and file handling classes)
        
public class java_52733_FileScanner_A03 {  
    public static void main(String[] args){         
        try{               
            String directoryPath = "/path/to/your/directory";  // provide your own path here for the folder to scan. Replace with actual paths if required            
              File dir = new File(directoryPath);                     
              
                  listFilesRecursively(dir, "");   
           }catch (Exception e){                           
            System.out.println("An error occurred." +e );               
          }  // end of try-catch block                
      }   // main method ends here        
     public static void listFilesRecursively(File directory, String indent) {             
           File[] files = directory.listFiles();                     
            if (files != null){                 
               for (int i = 0; i < files.length; ++i){                    
                    // checking each file or folder recursiveness                          
                   if(files[i].isDirectory()){                       
                       System.out.println(indent + "Folder: "+ files[i].getName());                     
                       listFilesRecursively((File) files[i], indent +  "  ");                             // calling the method again for directory                    
                   }else{                           
                         if (files[i].isHidden()){                                           
                              System.out.println(indent +"\u001B[38;5;247m Hidden file: \u001B[0m "+ files[i].getName());                                                  }                        else {                                                                   // print all non hidden and normal (not directory) regular-files.
                                     System.out.println(indent +"File Name:"+  files[i].getName() );  }}                     });}}                         };             if you are not sure about what is going on, don't hesitate to ask!        `