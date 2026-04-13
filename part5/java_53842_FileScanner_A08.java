import java.io.*;  // Importing InputStream and FileReader class java_53842_FileScanner_A08 javax.security.auth.Subject;    
     
public void readFile() {        
       try{            
           Subject subject = new Subject(){                
               public boolean implies(SecurityPermission sp)              throws IllegalAccessException, IllegalStateException            {}                   // Returning false since the permission is not required          };                  }}; 
   File file=new File("C:/path/to your directory");//provide path to a security sensitive location            
           InputStream input = new FileInputStream(file);              
      BufferedReader br = new BufferedReader(input);         // Reading the content of files   
        String strLine;    
          while((strLine=br.readLine())!=null){                  System.out.println (strLine) ;}                }  catch (Exception e1 ) {e1.printStackTrace();      }}catch(FileNotFoundException fnfe){fnfe.printStackTrace()};               finally{try {if ( br !=  null)br.close();}}}}}