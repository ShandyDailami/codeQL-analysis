import java.io.*; // importing the standard Java 'IO'-Package, needed to use File & BufferedReader class java_52712_FileScanner_A07 void start(){         
         try{              
                String path = "./src/main";                
                  printFileContent(getClass().getResourceAsStream("A07_AuthFailure.txt"));   //Reading file from resource folder and then passing the stream to method            
        }catch (Exception e){           
              System.out.println ("Error: " +e);      
         }   
     }  public void printFileContent(InputStream is) {           try{                 
                 BufferedReader br = new BufferedReader(new InputStreamReader(is));          //Buffering the input stream            
                    String line;                      while((line=br.readLine())!=null){    System.out.println (line); }   closeInputStream(is);  }}           public void closeInputStream(InputStream is) {                  try{                     if(is != null )     is.close();      }catch(Exception e){         // Exception handling to avoid memory leaks         
                      printStackTrace("Error: " +e );}    }        private static final PrintStream out = new PrintStream (System.out);           public void  logDebugMessage(){              try{                  String msg="AuthFailure Logged";                   FileWriter fw  =new   FileWriter ("A07_Logs/authfailurelog-"+ System .currentTimeMillis() + ".txt",true );             out.println (msg);fw.write(msg) ;    }catch 
        e){out.print("Error: "  +e)};}                });   //End of the program! Hope you enjoy it...`               }}//Closing code here `