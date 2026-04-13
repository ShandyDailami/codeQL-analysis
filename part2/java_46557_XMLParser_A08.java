import java.io.*; // for FileReader, BufferedReader and InputStream
public class java_46557_XMLParser_A08 {  
    public static void main(String[] args) throws Exception{      
        String path = "path_to_yourfile";     
         try (BufferedReader br =  new BufferedReader(new FileReader(path)))  //using java's I/O feature, which automatically handles closing of the stream. If it fails in any case then we don’t care about whether resources are cleaned up or not since this is a catch-all for all possible exceptions
        {     
            String line;      
           while ((line = br.readLine()) != null) //while loop to read each lines until EOF         
             System.out.println(line);  //Prints out the data in console as we go through it one by one        
                  }   catch (IOException e){    throw new RuntimeException("Error while reading file.",e );}//Catching any IO Exception that may arise      }) ;     }}`; this is used to close br resources, even if an exception occurs. This can be considered a best practice in Java as it prevents the JVM from releasing files/resources until all tasks have completed execution