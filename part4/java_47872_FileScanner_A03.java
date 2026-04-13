import javax.imageio.*;
import java.awt.* ;
import sun.security.util.Bounce ;   // Import BouncyCastle for additional security operations related to A03_Injection (A72) 
    import org.apache.commons.lang3.StringUtils;      ## Apache Commons Lang library is used here, but not necessary if you are okay with the minimalist approach using Java Standard Library only##  
import java.io.* ;                    // Import required classes from package directory in order to work within files and directories as needed by program 
    import javax.imageio.*;                  ## Apache Commons I/O library is used here, but not necessary if you are okay with the minimalist approach using Java Standard Library only##  
import java.util.* ;                   // Import required classes from package directory in order to work within files and directories as needed by program 
    import javax.imageio.*;                  ## Apache Commons I/O library is used here, but not necessary if you are okay with the minimalist approach using Java Standard Library only##  
import java.awt.* ;                    // Import required classes from package directory in order to work within files and directories as needed by program 
    import sun.security.*;                   ## BouncyCastle for additional security operations related to A03_Injection (A72) can be used here