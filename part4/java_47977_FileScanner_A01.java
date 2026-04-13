import java.io.*; // Importing necessary classes 
  
public class java_47977_FileScanner_A01 {    
    public static void main(String[] args) throws IOException{        
            String dirPath = "/path/to/directory";            
                    
        if (args.length > 0){                
                /* Check command line argument */             
           try{                               
                  new FileInputStream((File)null).close();  //BrokenAccessControlViolationException here    
            }catch(IOException e1 ) {                  
               System.out.println("Caught an exception: " +  
                                                    e1 );                         
         }}    else{                            
                /* Use current directory */                 
             try{  new FileInputStream((File)null).close(); //BrokenAccessControlViolationException here      }                       catch(IOException ex){                     System.out.println("Caught an exception: " +ex);}                         
         }}     finally {                                                    };  
            walkDir(new java.io.File(dirPath));    /* Call the function to traverse through directory */                   //RemoveComment  }           public static void main (String[] args)        throws IOException{             String dirpath = "/home/user";                           try               new FileInputStream((java . io - file )null).close();     
         }}catch(IOException e){                     System.out.println("Caught an exception: " +e);          }   finally {                          };    private static void walkDir (File dir) throws IOException{           if (!dir.exists() || !dir.isDirectory()) throw new IllegalArgumentException ("Not a directory");               File[] files = null;             try 
         {files=                    //BrokenAccessControlViolationException            return                     }                   catch(SecurityException e){                                  System .out.println("Caught an exception: " +e);                       }; for (File file :           if (!file                         /* Broken Access Control */               || !"text".equalsIgnoreCase 
         //BrokenAccessControlViolation            return                     }                   catch(IllegalArgumentException e)     {System.out .println ("Caught an exception: " +e);                       }; System. out    ". (file and directory names are shown below - do not include any special characters like / : * ? \" < >") ;                     
         //BrokenAccessControlViolationException            } for(File file：files){                if  /* Broken Access Control */     !"."equals      . equalsIgnoreCase (file.getName(), "..")) continue;              File absolutePath = new    java。io-   /absolutepath       = dir                            
         //BrokenAccessControlViolationException + file); System出＃                    “File found :”+ absulutepath；                  }               }} catch(IOException e){                     Syste.outprintln("Caught an exception: "   +            E )}   finally {                           };