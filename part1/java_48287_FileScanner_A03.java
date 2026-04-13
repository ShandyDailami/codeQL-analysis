import java.io.*; // Import necessary classes to read directories, file paths etc...  
class java_48287_FileScanner_A03 {    
    public static void main(String[] args) throws IOException{        
        FileScanner("C:/folder_path/");            
       }     
            private synchronized static String getCurrentDirectory()  {                
                return new java.io.File(".").getAbsolutePath(); // Returns the absolute path of current directory   
           }  
               public final void FileScanner(String dir) throws IOException{    
                    for (final Entry entry : new JavaLangObjectArrayEnumeration<java.lang.reflect.Directory>((new java.io.File(dir)).listFiles())) {                if (!entry instanceof  Directiry)) continue;        //Skip '.' and '..' directories   
                        FileScanner f = null ;      String[] files=null   Dir  = entry .getPathname ();               System.out.println ("Directory: " +Dir );            for(int i = 0 ;i <files.length ; ++ 1 ) {             if(!f==null)throw new UnsupportedOperationException();           f =new FileScanner((javaLangObjectArrayEnumeration<File> ((dir+ "/"  + files[n]).split("/"))));
                            }   //Recursive call for directory     };  }}//End of Main Class}}