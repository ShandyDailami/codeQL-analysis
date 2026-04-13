import java.io.*; // Import necessary Java libraries to handle files and folders in project
class java_51413_FileScanner_A08 {    
  public static void main(String[] args) throws Exception{  
    File folder = new File("path_to_your/directory");//replace with your directory path here     
       if (folder.exists()) { // check whether the specified file or directory exists       
           for (File file : folder.listFiles()){ 
               System.out.println(file);    //print all files and directories in this dir           
                try{  
                    FileReader fr = new FileReader(file);//try to read a text from the current item using reader         
                     int ch;        
                      while((ch=fr.read())!=-1){  /*while there are characters -1 is returned*/    //reading and printing each line in file  
                         System.out.print( (char) ch );        }    
                        fr.close();     
                    FileWriter fw = new FileWriter(file, true);//try to write into the same text using writer         
                     String txt="A08_IntegrityFailure";  //your string for integrity failure        
                      if(!textInFileExists(fw,txt)){          
                        System.out.println("Write failed");   }       else{             
                          System.out.println ("Successfully Written into: " + file);    }}             catch (Exception e) {                  // Catch exception        try-catch is used to handle any runtime errors         
                    continue;}}      finally {            FileWriter fw = new 
                    1FileReader(file, true),txt="A08_IntegrityFailure",eof()){}//cleanup operations before program exit   }     }}    catch (Exception e) {} // Catch exception.         In Java exceptions are handled using try-catch blocks           return;      
                                                    });  }) ;}}}                                                                                 `