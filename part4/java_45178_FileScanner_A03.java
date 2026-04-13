import java.io.*; // For FileNotFoundException, IOException    
public class java_45178_FileScanner_A03 {      
    public static void main(String[] args) throws IOException{       
		// Create a file scanner for the specified directory and its subdirectories: "/path/to/directory"         
	    try (FileScanner scn = new FileWalkBasedDirFilter().newInstance("/dir_containing_files")) {  //1   
	        while(scn.hasNext())        /* Iterate through all files */      
            {      System.out.println("Reading file: " + scn.next());        
                try (InputStream is = new FileInputStream(new java.io.File(scn.file().getPath())))    //2  Security Operation          
                    while((b=is.read()) !=  -1)       /* Read the bytes */          {              System.out.print ((char) b));         }      catch (Exception e){e.printStackTrace();}     }}   Catch block for exceptions is not necessary here, but added to keep it simple and clear on code flow   
        scn.close();       // Always remember close the file scanner after use          System.out.println("Done"); }  catch (Exception e){e.printStackTrace()}     }} });   End of main method}}      Catch block for exceptions is not necessary here, but added to keep it simple and clear on code flow