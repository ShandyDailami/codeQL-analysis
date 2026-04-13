import javax.security.auth.Subject;   // (A) Import Subject class java_45534_FileScanner_A01 java auth package 
// imports for all permissions and roles, not just file system access permission which is covered by the next line     
    
public void startSecurityDemo(String path){    // define a method that starts this demo with given directory as argument  
Subject subject = new Subject.publicInstance();          /* (B) Create an instance of public Instance from java security package */ 
// Use our custom permission, add permissions here     
subject.getPrincipals().add(new SecurityPermission("file.read"));        // Add file read and write operations to subject  
    
File folder = new File(path);    /* (C) Create an instance of the given path */ 
// Use filter() method from java io package, create a FilenameFilter that only accepts txt files     
File[] listOfFiles = folder.listFiles((dir, name) ->name.endsWith(".txt"));   //(D-E): use it to get all .txt file names    and then convert them into File object  for further processing    
for (final File file : Optional.ofNullable(listOfFiles).orElse(new File[0])) { /* Make sure list of files is not null */   // Start a loop over the filtered txt Files     
if (!file.canRead()) throw new SecurityException("File cannot be read by current user");    /** (F) Throw an exception if file can't be opened for reading, which should never happen in normal circumstances due to permission checks at security level above */  // If our subject does not have sufficient permissions it will stop here
System.out.println(file);   /* Print the name of each .txt files found on directory*/    }      end loop     try-catch block for file read operation would be useful in case when a program might crash due to insufficient permission, but that's not included as part A */  }}