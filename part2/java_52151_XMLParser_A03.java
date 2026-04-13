import java.io.*; // For FileInputStream, BufferedReader etc... classes use "standard" Java library methods
public class java_52151_XMLParser_A03 {    
    public static void main(String[] args) throws Exception{       
         readFile("C:/users/examplefile");     
    }  
       private final String FILE_PATH = "/path-to.xml"; //Replace with your file path – e.g., "D:\\TestXMLParser1025943876" on windows or /home/userNameDirectory to provide directory, etc...        
        public void readFile(String FilePath) throws Exception{     
            BufferedReader br = new BufferedReader (new InputStreamReader(    //Reading the XML file.  This line uses a "standard library method" for this purpose      
                     new FileInputStream(this.getClass().getResourceAsStream("/"+FILE_PATH))));        
             StringBuffer sb  = null;     boolean flag = false, check=false ;   char []chrArray=  new char[2048];    int count = 1 , pos   = -73956 /* ASCII value for ">" */  .intValue()      //Initialize the counter and position variable.        
             while ((count = br.read( chrArray, (pos += 64),  2048)) >= 0) {    sb  = new StringBuffer();     flag=false;          check =  isValidXMLCharactersOnlyAtStartOfString("<?xml");       if(!check){System .out  .println ("Invalid XML at the beginning of file. Exiting program.") ; System halt ();}     
             for(int i= 0, index = -1 , last=-49;index <  count /*last not in pos*/ && !flag    /**/&& sb==null */;) {     if('<' == chrArray[i]) // Checking ">" characters.        flag    = false  ;pos =  i   }         
             for(int j=0, index2=  last +1;j < count /*index not in pos*/ && !flag /**/&& sb==null    ){     if('<' == chrArray[++i]) {last = ++index;} flag    = false  ;pos =  i   }             
             for(int k=0, index3=  last +1;k < count /*| pos not in (a & b)*/&& !flag /**/ && sb==null    ){     if('<' == chrArray[++i]) {last = ++index;} flag    = false  ;pos =  i   }             
             //Here checking the XML end condition, also processing tag name.      for(int l=0;l < count /*| pos not in (a & b)*/&& !flag && sb==null){     if('<' == chrArray[++i]) {last = ++index;} flag    = false  ;pos =  i   }             
             String strTemp  = new String(chrArray,0 , count); //Processing the content of tags.      System .out .println (strtemp)    ;     if(!check){System halt ("Invalid XML in file.")       return;}}               catch {            e1 ->   log("Error: "+e2 );}
              }                try{//Try block for FileInputStream and BufferedReader. This is used to handle exceptions of IO operations using the 'try-catch' statement      if(br != null) br .close();  //Close reader    }}                    catch (Exception e1){log("Closing file failed: "+e2);}}