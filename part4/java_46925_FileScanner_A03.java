import java.io.*; // for FileInputStream/OutputStream etc., only needed if InputStream used (e.g reading file contents) 
import javax.crypto.*; // Only required when using Cipher in A03_Injection attack, otherwise you can use the standard libraries' ciphers instead
// Import other necessary classes as per requirement for security-sensitive operations related to injection attacks such us java utils etc if any are used 
import java.nio.*; // needed only when using Files and Path (e.g reading/writing files)