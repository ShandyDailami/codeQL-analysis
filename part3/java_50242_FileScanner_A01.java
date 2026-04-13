import java.io.*; // Import Java File related classes 
class java_50242_FileScanner_A01 {  
    public static void main(String[] args) throws IOException{    
        String directoryPath = "/path/to/directory"; /// Provide the path of your target folder here     
        
        traverseDirectory(new File(directoryPath)); // Start from a certain file or dir.      
    }  
 
/* A recursive method to list all files in given directory */    
static void traverseDirectory(File directory) throws IOException {            
          if (directory == null || !directory.exists()) return;           
           File[] contents = directory.listFiles();              // Get the content of this folder              
        for (int i = 0, size = contents.length ; i < size  ; ++i){               
                 traverseDirectory(contents[i]);             /* If it's a Directory then call recursive method */                  if ((size-1) == i ) break;              // end loop when we reach the last one            }           set default encoding for read and write files        FileReader fileReader = new FileReader("/path/to/.file");              
          try (BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(             System.out, "UTF-8"))) {                // Use buffering by wrapping the Streams in a BufferedWriter           for     ((Base64.Decoder decoder = Base64.getMimeDecoder(fileReader))){              StringBuilder buf    = new   
          StringBuilder();               while ( true ){                  int c;                do {c=decoder .ne   x()) ? -1 : 0;}while((char)buf_.appendCodePointOfBase64( decoded , start_index, end))            ==-2 && buf__.length() > 
          //end of file      }              bw.__writeLinesFromBuf(__lines);            System..println("File content:" + new String (decoder .decodeBuffer     “UTF -8”));}}catch(IOException e){e._printStackTrace();}   catch    {// Handle other types exception here.}}}