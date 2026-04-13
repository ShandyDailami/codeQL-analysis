import java.io.*; //for handling I/O operations 

public class java_45052_FileScanner_A03 {  
    public static void main(String[] args) throws IOException{     
        File file = new File("/path_to_directory");      
        
        if (file.exists()){            
            String currentDirPath;              // Declare a string variable for the full path of directory 
                                                   
           // Iterate over each object in this directory  
          do {                          
                File[] listFile = file.listFiles();    /* List all files and directories */    
                 if (listFile != null)                  /** Check whether there are more than one element*/       
                      for(int i = 0;i < listFile.length;i++){   //Loop through each item in this array          
                            currentDirPath = listFile[i].getAbsolutePath();  /* Get full path */      
                             if (listFile[i].isFile() &&        /** Check whether it is a file or not, then only proceed*/     
                                     ((currentDirPath.endsWith(".txt")))) {     //Check for .text files   
                                      FileReader reader = new FileReader(file);  /* Create the Reader */      
                                           BufferedReader br =new BufferedReader (reader );/* Buffer reading and storing text*/     
                                            String line;             /** Declare a string variable to hold each read file content.     */           
                                             while ((line=br.readLine()) != null) {  /*Read one lines from the File */   //Continue until no more files are left         
                                                  System.out.println(line);      /** Print out Each line of text Read*/      
                                            }                     br.close();    reader.close();     }}                    while (i < listFile.length );  /* end looping through */   //end the do..while block               };                        if (!file.canRead()) { System.out.println("Unable to read file " + currentDirPath); }
         else{System.out.printf("%s does not exist.", path_to_directory );}}  /* The directory passed in was incorrect*/;                  //end of the main method                   };   }} catch (Exception e){ System . out . println ("Error :"+e) ;};}}}