import java.io.*;  // File I/O class(es)  
public class java_47691_FileScanner_A03 {    
    public static void main (String[] args){     
        String directoryPath = "/path-to-directory";      
          try{           
             BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));  // Reading from standard input  
           File dir = new File(directoryPath);              
                 if (dir.isDirectory()){                       
                    String[] childrens= dir.list();                  
                     for (String child :childrens) {                        
                       System.out.println("Absolute path of file:" +child );    //Printing absolute paths  
                      }                                                                 
                FileScanner(new java.io.File((directoryPath+"/"+child)));      
             }} else{                                            
              throw new IllegalArgumentException ("Not a valid directory");       
            System.out.println("Please enter the correct path for your directories: ");   //Error message           }  catch (Exception e){ println(e);}     });