import java.io.*; //for handling files, directories etc...  
public class java_47888_FileScanner_A01 {   
     public static void main(String args[]) throws Exception{     
          String dir = "/home/user";       if (args.length > 0){             dir += args[0];         }        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));   //for getting input from user  System.out.println("Please enter directory:");     String line = ""; while ((line=br.readLine()) !=  null){      if (!"exit".equalsIgnoreCase(line)){          File f  = new File(dir,line);   
          	if (!f.exists() || !f.canRead() ){            System.out.println("File not found or cannot be read: "+file );     }         else {               //print the file details      try (DirectoryStream<Path> dirs = Files.newDirectoryStream(Paths.get(dir), path -> 
              new File((String)path).isDirectory())){          System.out.println("DIRECTORY: " + f );           }         else {               //print the file details      try ( Stream<Path> files = 
                Files.newDirectoryStream(Paths.get(dir), path -> 
                  new File((String)path).isFile())){          System.out.println("FILE :"+f);    }}       }           else {         //exit the program      Environment.exit(-1)); }}}   catch (Exception ex){     ExceptionUtils.printStackTrace(ex );}}