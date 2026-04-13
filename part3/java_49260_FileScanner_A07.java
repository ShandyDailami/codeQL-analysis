import java.io.*; // Standard IO Libraries

public class java_49260_FileScanner_A07 {  
    public static void main(String[] args) throws IOException{    
        String folderPath = "/path/to/directory";           
        
        try (FileScanner fileScnr =  new FileFilteringFSR((new File(folderPath))).asCustDirIter()) { // Using custom Directory Iterator     
             while (fileScnr.hasNext()){                
                System.out.println("Security risk: "+   ((java.io.File) fileScnr.next()).getAbsolutePath()); 
            }             
        } catch(Exception ex ) {                    // Exception Handling   
           if (ex instanceof SecurityException && !((fileExclusionCondition)(new FileFilteringFSR())).accept("")){         
                System.out.println ("Permission denied to access: " + ((File) fileScnr .next()).getAbsolutePath());      // Prints permission denined error message if any security issue found             } catch (Exception e){System.err.format("%s",e);}     }); 
        }}    private static class FileFilteringFSR implements java.io.FileVisitor<java.lang.String>{   public Iterator iterator() {return null;}      @Override default boolean visitDir(final Path dir, final BasicFileAttributes attr){if (dir==null) throw new AssertionError(); return true;}}