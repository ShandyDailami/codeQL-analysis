import java.io.*; // Import required Java packages for File I/O and Scanner class java_51843_FileScanner_A03 class Main {    
    public static void main(String[] args) throws IOException{        
        System.out.println("Enter file name:");         
           /* Create a BufferedReader to read the input */ 
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {    // Reading from keyboard using standard 'InputStream'  
            String line=reader.readLine();              System.out.println("Enter file path:");    
                File dir =  new File(line);                 if (dir.exists()){                      try 
                    (FileScanner scan = new FileFilteringFastScanner((new java.io.PrintWriter[]{null}))) {   //Using a custom 'java-only' Fast Scan    file filter     for scanning            dir, ".class",".jar"          } catch(Exception ex){System.out.println("Error : "+ex);}
                }} else  System.out.println ("Invalid path");                    while (!line.equalsIgnoreCase(".quit")) {                   // Main loop   String fileName = line; File theFile= new         java .io..       (fileDir, filename) ;    if(theFile !=  null){ try          
                ((java.util.zip.ZipEntry zipentry =  scan     .nextEntry())  ){System      }catch        // Catching all exception   catch { System。out．println ("Error: " + e); }} else         break;}}                    while (true)}            try            
                (.FileFilter fileF = new FileNameAndExtensionReverser(scan.acceptedFiles))              .process((java nio 2..filefilteringfast    scanner)      { @Override public void accept    1sitiveAction（finals Action action，final java  8...files files
                ){}}catch (Exception e){System out println( "Error: " +e);}}} catch           // Catch Exception and Print Error Message        } System.out .println ("Scanning complete");}  }}              `});