import java.io.*;  // Import File and IOException classes  
class java_47807_FileScanner_A08 {   
     public static void main(String[] args){     
        String dir = "/path/to/directory";      
         try{           System.out.println("Searching for files in "+dir);         
                      fileScanner108IntegrityFailureOnlyStandardLibsAndNoSprings (new File(dir));   }   
             catch(Exception e){e.printStackTrace();}        // exception handling        
     }}//Main class  End       System.out.println("Searching for files in "+ dir);           fileScanner108IntegrityFailureOnlyStandardLibsAndNoSprings (new File(dir));   }    catch Exception e){e.printStackTrace();}      // exception handling        
     /* This function will scan the directory */  void fileScanner108IntegrityFailureOnlyStandardLibsAndNoSprings(File dir) {          try{           String[] files = dir.list ();   for (String filename :files){             File f=new java.io.File(dir+"/" +filename );              if(!f.isDirectory())      
            System .out.println ("FILE: " +  //file found, print it out  }, printed name of file ->          {PrintWriter pw = new PrintWriter (System .out);           BufferedReader in  =new BufferedReader(new FileReader   ((File) f)); String line; boolean integrityFailure=false ; try{
            while((line =  in.readLine()) !=  null ) // read the file, one row at a time  }, this is for A08_Integrity Failure: Adding checksum to each textual data ->   {pw .println ( line ); pw.flush();
            if(!integrityFailure){          integrityFailure=validateChecksums(f);} else{ System.out.print ("File " + f+" has a Checksum Mismatch, skipping."); return;}}catch{}finally { in .close ()}// handling file close  }, check the checksu and print error message ->    }
         for files read from directory if not integrity failure continue scanning of other directories.      catch(Exception e){e.printStackTrace();}       // exception catching             }}