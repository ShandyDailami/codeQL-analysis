import java.io.*;  // Import required Java libraries   
  
class java_48018_FileScanner_A03 {    
       public static void main(String[] args) throws IOException{     
           if (args.length == 0){         
               System.out.println("Usage : filename <directory>");        
               return;        }            
                   String directory = args[0];   // Directory to be scanned   
                     File f= new File(directory);  /*for file and dir*/     if (!f.exists()){     
                         System.out.println("Directory does not exist.");      
                         return ;         }}           else {             
                       Scanner s =new   // New scan input stream               for (File files : f .listFiles())    {             String name=files.getName();          if(name	.endsWith(".txt")){                  System.out.println("Scanning text file: " +         name);            }                   else 
                            /*if we get here, it's a directory */       //directory*/      }}               f = new File (args[0]);             s=new Scanner(f.listFiles());              while (s .hasNext()){                 String fileNameWithDir  =   s    .next();                  System.out.println("Scanning Directory: " +fileNameWithDir);           }       }}