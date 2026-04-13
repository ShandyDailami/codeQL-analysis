import java.io.*; // Importing FileReader & Buffered Reader classes 
  
public Class Main {    
    public static void main(String[] args) throws IOException{         
        try (FileScanner scan = new FileScanner()) {           
             String directoryPath="D:\\";             
                  Directory dirObj  =newDirectoryInfo("directory path");           // Create a obj for the given file/dir. 
                   .......               ,,,..........,.........//Assuming many other required operations here   and all must be done within this try block        
        } catch (SecurityException e) {         
            System.out.println("Caught Security Exception: "+e);       // Handle the security exception    
           .......  ,,,..,............//Assuming many other required operations here    and all must be done within this try block        
        } catch (UnsupportedOperationException e) {         
            System.out.println("Caught UnSupported Exception: "+e);   // Handle the un supported operation exception     ....... ,,,.....// Assuming many other required operations here  and all must be done within this try block        
       
    } catch (IOException e){          
          Console.WriteLine(Console.ERROR,"Caught IOException :" + E) ;      /*Handling I/O exceptions*/   // handle the file not found exception     .......,,,..// Assuming many other required operations here and all must be done within this try block    }  catch (Exception e){          
          Console.WriteLine(Console.ERROR,"Caught Exception :" + E) ;         /*Handling general exceptions*/   // handle the file not found exception     .......,,,..// Assuming many other required operations here and all must be done within this try block    }      return;  }}`