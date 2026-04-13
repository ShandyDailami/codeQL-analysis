import java.io.*; // for File and IOException classes
import javax.activation.FileDataSource;  
    
public class java_44347_FileScanner_A07 { 
    public static void main(String[] args) throws Exception{         
        String dir = "C:/";             
       int i=0,sizeOfDir = 1572864; // size of directory in bytes     
          
         File file = new File (dir);  
             if (!file.exists()) {     System.out.println ("Directory does not exist."); return;}    else{         
              String[] children  = file.list();  for(String child :children){        //iterate over the list of files and directories        
                sizeOfDir += new File (child).length();       }     
             try {     BufferedInputStream buffIn = null;           DataSource ds   =null ;          int bytesRead = 0, bufferSize=8192;  byte[] bufs =new byte[bufferSize];   //initialize buf and set its size           
              File fileLoop  = new File(dir+child);    if(!fileLoop.isFile()) { continue;}     buffIn   =new BufferedInputStream(      fs, bufferSize ); ds= new javax.activation.FileDataSource (fs) ;       try   {        bytesRead =buffIn .read(bufs , 0 ,bufferSize ) ;          while ((bytesRead  = buffIn.read( bufs,   0/*offset*/ ,     /*length */ bufferSize)) != -1){ WriteStream ws=  System.out; for (int k = 0 ;k < bytesRead ; ++k) {ws .write((byte)(bufs[ 
             2] & ~3));} } // print out byte bye stream   fs , "bytes read");     buffIn  =null;} catch(Exception e){System.out.println("Error: "+    e);}}catch (IOException ex) {ex .printStackTrace();}}}        System.exit(-1);
               }}  finally{ if ((buffIn != null))   try { buffIn.close() ; }     catch ( IOException e ) {} fs =null; ds  =         null;}      //end of Finally block to close file streams and data sources          `};    return}}}}}//End Main Method)}