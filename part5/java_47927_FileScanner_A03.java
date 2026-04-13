import java.io.*; // for InputStream, OutputStream classes & FileScanner class java_47927_FileScanner_A03 final class Main {    
    private static boolean isFileReadable(final String path) throws IOException{      
        try (InputStream in = new FileInputStream(path)){         return true; }          catch (IOException e){           /* file not readable */            throw e;}  //return false or handle the exception appropriately.  
     }    public static void main(String[] args )throws Exception {      System.out.println("Is it safe to go ahead? " + isFileReadable("/path_to/file")); }}`