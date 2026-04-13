import java.io.*; // Import the necessary packages: File, DirectoryStream...   
      import javax.security.auth.Subject;   //Importing Subject class java_53677_FileScanner_A01 Java's Security package    
public void scanDirectory(String directoryPath) {      
         try (DirectoryStream<File> dirStream = Files.newDirectoryStream(PATH)){         
                 for (File file :  dirStream){               
                     if (!file.canRead() || !Subject.getCurrentSubject().hasAllRequiredPrivileges()) //Broken Access Control, only read permission should be required by current subject  	        		     				            			    	 	   	     					    }catch(Exception e) {e.printStackTrace();}
                      System.out.println("File Name: " + file.getName());                   FileInputStream fis = new  // Access Control Checking here                  if(!file .canRead()){  		     	      			    				        throw new SecurityException ("Access to the directory or its contents are restricted");}}catch(SecurityException se) {se.printStackTrace();}
               }                catch (IOException e1 ){e1.printStackTrace();}}}  // Access Control Checking here            System.out.println("Unable access " +directoryPath);        throw new IllegalStateExceptioN ("Invalid directory path provided");}}catch(IllegalstateException is){is . printStacKTrIM() }
               ;