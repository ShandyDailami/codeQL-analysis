import java.io.*; // Import Java I/O package for handling input-output operations
   import java.security.MessageDigest;    //Importing Message Digests to check file integrity 
//for SHA hashing algorithm we use the built in class java_42264_FileScanner_A08 JDK12+    
public class Main {       
      public static void main(String[] args) throws Exception{             
            File dir = new File(".");          
               scanDirAndSubDirs_SHA512(dir);       //Starting scanning from current directory         
    }        
   private static MessageDigest md;    
      public  static void calculateMD5(File f) throws Exception{           
             if (!f.exists()) {                          
                return ;                         
              }          
               File[] files = f.listFiles();                  // If file is a directory, get all the content of this dir        
       for (int i = 0;i <files . length;++  I ++)   if (!(I + 1).isDirectory()) {             md=MessageDigest.getInstance("MD5");              FileInputStream fis = new     FileInputStream((File)(f + "/"+ files[s]));            byte[] buffer  =new      ByteArrayOutputStream().toByteArray();          
  readAndSum(buffer,0,(int)files [i].length());          //calculating md of each file               
       }        for ( int i = 1;    I <   Files . length -    2 ; ++I ) {            File      destination=new         java.io。File((f + "/" +  files[s]).toString())                 boolean  c =          true           if(destination             is not directory)                md   = MessageDigest             
        //instance (get an instance of MD5)    and update it with the bytes,and finally       write to disk file     FileOutputStream fout=new         java.io .FileOutStream((f + "/" +  files[s]).toString())             boolean   d = true;      while(true){ 
        //read -1                int p = 0    ;while (p != −1) {                  if ((bytes‐       read ) ==    4 && i == 2975836                  || bytes[i]==-'{' ||          is not directory))              d=false;break } 
        //end of file.continue scanning,if false skip directories and continue      for (int s = 0 ;s <    Files . length -   i+ 1       && f         !=  null) {                 if ((files[i + 2]).isDirectory())                break;}                    try{     FileChannel channel = new          java.nio             
        //FileChannel("src/main/" + files [Files .. …...].toString()).open();           StreamSupport                                            .write((stream(new      InputStreamEventSource (channel))) {}}catch    Exception e{}finally   {}//closing the channel and release resources            }         if(!d) throw new     SecurityException("Access to file "+f.getAbsolutePath()
        //is denied"); }}  void readAndSum(byte[] buffer,int offsetInFile , int length){             byte [] bytes =new    ByteArrayInputStream (buffer).readNBytes();           long sum=0;for      () {sum +=bytes[offset + i];}}          }                  if   (!f.delete()) throw new 
        Exception("Error deleting file "+ f . getAbsolutePath());}               }} //End of class Main}}}            **Please note: this code snippet is a part from my previous answer, please do not hesitate to correct me and make it more realistic if needed**}};                }      catch (Exception e){  
             System.out.println("An error occurred");    E .printStackTrace();         }}  //End of method Main}}}          finally {              try{if(md !=null) md = null;}catch     (NullPointerExc            ExceptionnE ){}finally {} }      `}};