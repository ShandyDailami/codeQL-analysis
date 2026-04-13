import java.io.*;
import java.nio.file.*;
import java.security.*;
import java.util.*;

public class java_50741_FileScanner_A08 {  
    private static final String DIRECTORY_TO_SCAN = "/path_to_directory/"; // change it to your own directory path if not using Spring or Hibernate libraries 
    
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {       
       Set<String> uniqueHashes =  scanDirectoryAndIdentifyUniqueFiles();        
       printResults("unique hashed files", uniqueHashes);               
   }            
      ...  // rest of your code omitted for brevity.   
     private static void deleteMatchedFile(Path file) throws IOException {        FileSystem fs = Files.getFileSystem(file), matched;         HashSet<String> hashedContentInDisk =  getHashesOfAllFilesFromDirectory(), contentToMatch, toDelete= new HashSet<>();         
       try (InputStream is  = Files.newInputStream( file )) {              SHA256 digest = DigestUtils.getSha256Digest();           byte[] bytes = new byte[1024];                int n; Long size = 0L, toBeDeleted= filesInDiskCount-uniqueHashesFilesFound_count), matchedSize=  matchedContentToMatchFile==null? 
         (long)file.getFileName().toString(Locale.US).length() :matchedContentLengths[i];                  if ((size += bytesRead = is .read(bytes)) >= 0 ) {                          while((n=is.available()) > 0){                             size+=  n ;                                contentToMatch =  new String (Arrays.copyOfRange
         (contents, 8 + MatcherLengths[i], contents + 12));                      if(!matchedContentInDisk .add(contentTocopy)) {                            File toBeDeleted_file = matched;                     System.out.println("Unable To Match"+toBeDeleter); return;}                  }                 contentToMatch=null ;
         try{  //try/catch block for deleting file if it matches and successfully hashed, or throws an exception otherwise} catch (Exception e){System.err .print(e-getMessage );}}        deleteMatchedFile = matched;                      System..println("Deleting Matches"); }                    return uniqueHashes;}                 
  ... // rest of your code omitted for brevity  
    private static Set<String> scanDirectoryAndIdentifyUniqueFiles() throws IOException {         FileSystem fs =  Files.getFileSystem(DIRECTORY_TO_SCAN);        try (Stream < Path > paths =            if (!fs .isReadable ( DIRECTORY_TO_SCAN )) throw new IllegalArgumentException ("Check your permissions or the path is invalid");   return    
       // Stream over all entries in this directory and its sub-directories         Files.newDirectoryStream(DIRECTORY_TO_SCAN, ".*\\.java$", Level.SECONDARY).parallel().forEach (p ->          if (!Files .getFileAttribute( p , FileAttributes.class ).equals
        (( SimpleFileAttributes ) null)) {                            // Check for integrity failures on files            try  withScope newInstanceOf   ()->  scanDirectoryAndIdentifyUniquefiles((Path)null, (SimpleFileAttributes)-> Files    .getLastModifiedTime(p));}};}}});