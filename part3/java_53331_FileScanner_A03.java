import java.io.*; // for File and IOException  
public class java_53331_FileScanner_A03 {    
    public static void main(String[] args) throws Exception{      
        try(FileSystem fs = FileSystems.newFileSystem(Paths.get("./"), null))     
           {         
                Files.walkFileTree(fs.getRootDirectories(), new SimpleFileVisitor<Path>(){  // Walk directory tree    
                    @Override    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException{   /* Called for each regular (non-directory) file */       if(!fileNameContainsUnwantedWordInJarManifestOrMavenPomFiles((String)null))    
                        {          System.out.println("Discovered vulnerable JAR or MAVEN POM: " + file);}           }      });  // Walk the directory tree */    }}   catch (IOException e){ /* Handle I/O exceptions properly, maybe not necessary here but good practice in general*/ throw new ExceptionInInitializerError(e)};
        System.out.println("Done.");}}          @Shadowed class SimpleFileVisitor<Path> {      private static final Set < String > SHADOWED_WORDS =    Collectors .toSet (Arrays .asList ("exec", "delete-this")) ; public FileVisitResult visitFile( Path file, BasicFileAttributes attrs) throws IOException 
        {{throw new UnsupportedOperationException();}}          @Shadowed class Main {         private static final Pattern UNWANTED_WORDS =   // Shows use of a regex for pattern matching. It's not intended to be used in real life, but demonstrates the principle!     public 
        /*...(trimmed)...]*/ }}};