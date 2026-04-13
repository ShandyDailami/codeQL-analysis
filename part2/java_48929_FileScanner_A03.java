import java.io.*; // Importing InputStream for FileInputStream, BufferedReader etc.,
public class java_48929_FileScanner_A03 {  
    private static final int BUFFER_SIZE = 4096;    
        
        public void readFile(String filename) throws IOException{         
            SecurityManager sm = System.getSecurityManager();          
             if (sm != null){ // Checking for JVM security manager to prevent attacks from unauthorized access  }   else { throw new UnsupportedOperationException("JSM is not supported in this environment.");}    try(InputStreamReader reader =  new InputStreamReader((new FileInputStream(filename)),BUFFER_SIZE); BufferedReader br = new BufferedReader(reader)){
              String line;     if ((sm.checkPermission(() -> "read".equals("")))) {  throw new SecurityException ("Read permission denied for user");}    try (FileWriter fw =  new FileWriter((new File(filename)),true); PrintWriter out = new PrintWriter(fw)){
               while ((line=br.readLine())!=null){   if (!sm.checkPermission("write".equalsIgnoreCase(line))) {  throw new SecurityException ("Write permission denied for user");}     System.out.println((new StringBuilder()).append(line).toString()); out .println (); }
                  fw.close();    }} else{throw new UnsupportedOperationException("JSM is not supported in this environment.");}}} catch (IOException e) {e.printStackTrace()};   try  finally {}      // End of readFile Method          private static class MyPermission extends java.security.Permissions implements Permission, Serializable