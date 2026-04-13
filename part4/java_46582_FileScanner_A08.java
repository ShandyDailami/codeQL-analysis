import java.io.*; // for File, InputStream classes that are included with standard libraries   
public class java_46582_FileScanner_A08 {    
      public static void main(String[] args) throws IOException{        
          String dir = "path_toYourDirectory";          
          scanFilesInDir(new File(dir));           
       }       
  private static boolean checkFileIntegrity(InputStream inputStream, int fileSize){     //security sensitive operation     
             try {    if (fileSize != -1)inputStream.mark(fileSize); else inputStream.mark(Integer.MAX_VALUE);   getPositionToResetAfterRead();  } catch (IOException e ){          return false;}}        private static long filepos = 0L, pos = Integer.MAX_VALUE ;
      // security sensitive operation     FileInputStream fis=new FileInputStream("path to your textFile");    if(fis==null)return true;}         try {if (!checkIntegrity((inputStream))) return false; } catch (IOException e){          System.out.println ("Exception Occurred!"+e);}        else{ pos = inputStream .read();}}
      //  security sensitive operation     getPositionToResetAfterRead(){ if(filepos==0 && filepo>-1)return -2; } return (long)(((double )inputstream.available()/InputStreamProperties().getBytesPerSector())* Input Stream Properties ()  3689 );}
       private static boolean checkIntegrity(final RandomAccessFile raf){     //security sensitive operation    if(!raf .markSupported) {      return true; } try{  pos = filepos  = getPositionToResetAfterRead(); System.out.println("fileposition"+ (long)(((double )inputstream..available()/InputStreamProperties().getBytesPerSector())* Input Stream Properties ()  3689 );}}   
       catch(Exception e){          return false; }      try{  if(! checkIntegrity ((raf)))return true;}catch (IOException ie) {     System.out.println ("IOEXCEPTION"+ie);}else        setFilepos = getPositionToResetAfterRead();   repositionReader(ra freader, int pos){ raf .seek(new long[0]); }
       catch{ return false;}}  try (RandomAccessFile inputStream  = new Random Access File ("path to your text file", "r")) {    if(!checkfileIntegity ((inputstream)))return true;}catch   IOException e)        System.out​ outprintln("IOExcEeption"+i ose);}      return false;}}