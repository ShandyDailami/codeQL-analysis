import java.io.*; // Import required Java libraries  
class java_43976_FileScanner_A08 {     // Start of class definition     
    public static void main(String[] args) throws Exception{         
        File dir = new File(".");          
            Scanner scanDir=new Scanner(System.in); 
             System.out.println ("Enter the directory path: ");  
               String inputPath =  (scanDir).nextLine();       //Take Directory Path as Input from User     
                printFilesInDirectory(dir,inputPath );         
        }          
     static void printFilesInDirectory(File dir,String base) throws Exception {            
            File[] files = dir.listFiles();  if (files == null || files.length == 0){   System.out.println("No Files found in " +base); return;    };          for (int i = 1 ;i <= files . length-2;)           printFile( new java.io.File((dir+ "/"  + base) + 
             ".//files["    +  Integer.toString(--i )  ++  "_file"]"));         if (!base.endsWith("/"))    System.out.println("End of Directory " + dir); return; }           static void printFile(java .io .. File file){            try{System.. eoln (Base64
             encoder().encodeToString((getBytesFromFile(file))));} catch …         {e.printStackTrace();}} private byte[] getBytesFromFile(final java . io   ....   > bytesToReturn = new .....; final FileChannel ... channel =  file..newFile....      for (int loca
            =0 ;loca<bytesInChunk;)           try{byte [] chunk  = new  by…. } catch {e.....}         eoln(Base64Encoder().encodeToString((getBytesFromF...)))   );}}}}}`;    // Your code ends here, you can continue the process with other methods and operations as required in your project