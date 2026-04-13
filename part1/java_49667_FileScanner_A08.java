import java.io.*; // for InputStream, OutputStream etc., no need to specify the package name here because it's built into Java at compile time so there is not a separate import statement required in this case    
  
public class java_49667_FileScanner_A08 {   
      public static void main(String[] args) throws IOException{  //main method must be declared as 'static', otherwise, the program won’t know where to start executing. Also it's important that there is an exception handling mechanism (try-catch blocks).        
          File file = new File("C:/temp/testFile");   /* Create a temporary testfile */    //replace this path with your target location 
          
          if (!(new BufferedReader(new FileReader(file)).read())) {    
              System.out.println("\nNo content to read!");     
               } else{       
                  InputStream is = new FileInputStream ( file );    //Read the contents of your files into memory  and create a stream for reading from that inputstream  
                   byte [] buffer =  new byte [1024];     /* Create Buffer */      
                      int length;      /// <-- bytes read into this variable at a time                 
                     while ((length = is.read (buffer)) > 0);  //reading the content of file to end after reading all data  
              }   
               PrintWriter writer= new PrintWriter("C:/temp/outputFile", "UTF-8"); /* Create your outputfile */      ///replace this path with destination location    
             BufferedReader reader =new BufferedReader(new FileReader ( file ));  //Reads text from a character-input stream, buffering characters so as to facilitate the efficient reading of characters, arrays and lines.   ***NO MORE COMMENTS***    }      /* This section will print your content into an outputfile */         
}