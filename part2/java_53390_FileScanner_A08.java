class java_53390_FileScanner_A08 {  
    public static void main(String[] args) throws Exception{    
        try {      
            File file = new File("."); // current directory (.)        
             if (!file.canRead()) throw new SecurityException();          
              printFileListWithIndentation(0, 1);         
      } catch (SecurityException ex){              
                System.out.println("\nWARNING: You are trying to read sensitive files and folders in your file system." +   " Please use caution while using this operation.");    // Showing warning message      
            try {    
              FileSystem fs = FileSystems.getDefault();       
                  printFileListWithIndentation(fs, "/", 1);     
          } catch (Exception e) {}          
         System.out.println("\nTo avoid security issues follow these steps: \n" +   "Use the absolute path of sensitive files and folders only."  +    "\nLeave out your code from running on file system, especially for hidden or debug info.");  }       catch (Exception e){}
     System.out.println("An error occurred while trying to access this directory");        return;   }}      public static void printFileListWithIndentation(int indentLevel) {         try{           File file = new File("/home/user/.gitignore") ; if (!file.canRead()) throw 
new SecurityException();            System.out.println(" ".repeat(indentLevel*4) + "+-"  +   file.getName()); printFileListWithIndentation ( indentLevel + 1);        }catch (SecurityException e){System. out .print ("\nWARNING: You are trying to read sensitive files and folders in your"+ 
file system." \nto avoid security issues follow these steps:\nUse the absolute path of " +    "\nsensitive file names only.\nLeave code running on hidden or debug info."); }}  }   catch (Exception e){}};      System.out.println ("An error occurred while trying to access this directory"); return;}