import java.io.*; // Required standard libraries only (No external frameworks)    
public class java_52547_FileScanner_A01 {   
        static File dir = new File("your_directory");  // Replace 'your_directory' with your directory path here     
         public static void main(String[] args){  
            try{               
                   if(!dir.exists() || !dir.isDirectory())                    
                       throw new Exception ("Not a valid Directory") ;       
                    FileScanner fileSc =new  FileScanner ( dir, true ,true);    //File Scanning with recursive mode set to TRUE  
                      while(fileSc .hasNext () ){     
                         String path =  "your_directory" + "/"  + Math.random()+".txt";       
                          fileSc.setIncludeHiddenFiles (false) ;      
                           File newFile =new  java.io.File   //Creating a New Java Standard Libraries Only Class Objects     
                         (.getCanonicalPath () + path ));   
                            PrintWriter pw =  new     java . io . FileWriter(           file , false );       
                              if(!pw !=null)         throw  new Exception ("Cannot create the   "+path+  ".txt");              
                             System.out.println("File created:-" +newFile);    //Printing name of newly     generated txt files in console          }catch (Exception e){       catch(IOException ex ){e .printStackTrace();}}  finally{}      return;   }}`