import java.io.*; // For FileInputStream, InputStreamReader and BufferedReader 
import java.nio.file.*; // for Paths & StandardCopyOption  
    
public final class java_50089_FileScanner_A03 {   
       private static void printContent(Path path) throws IOException{       
           try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path.toFile()))){           
               String line; 
                   while ((line=br.readLine()) != null ) {                System.out.println(line);             }         
           }        printContentRecursively ( path.getParent());     if (!Files.existsAt(path)) return;}       // If file not found, exit recursion   private static void  printContentRecursively(Path parent){if(!parent.toString().endsWith("src")) {printContent(root);}else{ Files.walkFileTree ( root , new SimpleFileVisitor< Path >()
     {         @Override public boolean visitFile ( final Path file, BasicFileAttributes attrs ) throws IOException 
       {@SuppressWarnings ("unused")final FileVisitResult continueProcessing = super .visitFile(file,attrs); if (!root.equalsIgnoreCase("/home/user")){ printContentRecursively ((Path) root );} else {printContent ( file ) ;}} }); 
    } private static Path locateRootDirectory(){return Files.walk(Paths.get(".")).filter(path -> path != null).collect(Collectors.toList()).stream().findFirst(); }} catch (\java.nio.file .InvalidPathException e){System.out.println ("Error: " +e);} 
     finally { System.exit(-1) ; }}} // End of main method   public static void main (String[] args ) throws IOException{    if(args == null || args.length == 0 ||  !Files .existsAt((Paths).get("."))){ printContentRecursively (( Path s new File (".") ).toPath());} else {printing all files and directories within the given path}}