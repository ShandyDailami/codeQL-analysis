import java.io.*;    // for InputStream, OutputStream & IOException classes  
     import javax.activation.*;   //for MimetypesFileMap (to detect mime type) and FileDataSource(read file as bytes from disk).      
      public class java_52909_FileScanner_A01 { 
           private static final String TMP_DIR = "C:\\Temp";    //Temporary Directory. You can use any temp directory of your choice    
          BufferedInputStream bis;  
            byte[] buffer ;        /* create a buffering character */       public void readFileIntoMemory(String fileName) {  System.out.println("Reading "+fileName);      InputStream inputstream=null; try{ // open the source image for reading in binary mode    bis = new BufferedInputStream (new FileInputStream ("C:\\Users//Desktop/test1234567890_aerospike")); buffer =  new byte[bis.available()];   int length ;
        /* read and decode the jpeg into a image */     bis .read(buffer);  for (int i=0;i<buffer.length;i++) { System.out.print((char)(buffer [i])); }    // Print out all text written to standard output   try{inputstream = new BufferedInputStream
       ("C:\\Users//Desktop/test1234567890_aerospike"); inputStreamReader=new InputStreamReader(bis);  for (int i = 0;i< bis.available();++i) { char cchar[] = new   character[2];cchar [0]= 
       ((Character)(buffer    [i])).getClass().getName() .substring(((Character)( buffer     [i])).hashCode());  System.out.print (new String (cchar)); } bis。close(); inputstreamReader！=null?inputStreamreader   !println("Closing the streams"):System    .. out打印ln "The stream was not opened");}catch(IOException e){e . printStackTrace () ; 
       System.out..print ("An I/O error has occurred: "); } catch (Exception ex) {ex ... PrintStream   Stream("C:/Temp//logFileErrorLogs" + File    Descriptor   Lookup."+System Clock"))} //to log the exception in a .txt file 
       /* to handle all checked exceptions */     public static void main(String[] args){ BrokenAccessControlExample obj = new       
BrokenAccessControlExample(); try{obj.readFileIntoMemory("C:\\Users//Desktop/test1234567890_aerospike"); } catch (Exception e) {e...PrintStream Stream  ("logfile")}{ //to log the exception in a .txt file}