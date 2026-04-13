import java.io.*; // Importing FileScanner class java_48015_FileScanner_A01 class Main {   
       static void fileSearch(String path, String extension)     
        {        
            try    
                {             
                    File initialDirectory = new File(path);         
                      if (initialDirectory.exists())            
                          for (File f : initialDirectory.listFiles((dir, name) -> name.endsWith("." + extension)))  // Filters files based on given extensions                    
                              System.out.println(f.getAbsolutePath());               else    printf ("No such directory exists");     }       catch   (Exception e){printf("\n Error occurred: %s",e);}        };          public static void main(String[] args) { fileSearch("/Users/user/, ".txt") ;  }}