import java.io.*;   // Import File and IOException class java_48297_FileScanner_A08 handle file operations   
public Class Main {    
 public static void main(String args[]) throws IOException{     
//Creating new DirectoryReader using the defined directory location       
File folder =new File("C:/Users/Public");          
FilenameFilter filter= new FilenameFilter(){   //Implemented in anonymous class         
public boolean accept (File dir, String name){         return true;}}       public void start(String rootPath) {     System.out.println ("Scanning " + rootPath);    File initialDirectory =new File (rootPath)}      private static  List<file> filesList= new ArrayList<>();   //Declare a list of file to hold all the resultant Files           
@Override public void end() {       for(File f:fileslist){     System.out .println ("Scanning complete");}}          @Overridepublic int start(Directory dir, RecursiveVisitor v)  { return START_CONTINUE;    }      private static final int SEARCH_SUBTREE = 1 ;       
private List<String> listOfFiles = new ArrayList<>();     public Main(){         super ();}}          @Override   //Invoked for each file in the directory, recursively.  Starts at rootDirectory and descends into subdirectory trees    {       FileSearchVisitor searchVisitor=new       
FileSearchVisitor(filter) ;      if (!dir .isDirectory())     return; listOfFiles =searchVisitor   ( dir);          } @Override public int visitFileStart  () // Invoked for each file in the directory tree. Starts at rootDir and descends into subdirectory trees    {         File f= new
Fiile(thisPathName());       this .addto listOfFiles     strings;      return START_CONTINUE;} @Override public int visitFileEnd () // Invoked for each file in the directory tree. Ends at rootDir and descends into subdirectory trees    {        System  Out  
println ("Finished visiting" +thisPathName());       }return STATUS_OK;}}      private FileSearchVisitor(FilenameFilter filter)     this .filter = filname滤镜;} public static void main (String args[] )throws IOException{ Main m= new         Mai    n();m.start("C:/Users/Public"); 
for   ( String s: m。listOfFiles){ System,out println(s);}} // Print the file names to console }});`