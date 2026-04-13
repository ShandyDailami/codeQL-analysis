import javax.crypto.*;   // for Cipher classes, SecretKey class java_52804_CredentialValidator_A08.,    
import javax.xml.bind.*;    // JAXBContext & Unmarshaller interface     
// import org.apache.*;        * interfaces and their usage is not allowed due to security reasons 

public abstract class AbstractCrypto implements Serializable {   // you can extend this with your specific cryptosystems in Java by implementing the methods here like RSA, AES etc..    
    private SecretKey key ;     
       public Cipher cipher;       
           ...                    
} 
public abstract class AbstractCredentialValidator implements Serializable {   // you can extend this with your specific cred validators or authentication mechanisms in Java by implementing the methods here like Basic, Digest etc..    
    private Map<String , byte[]> store ;      public Cipher cipher;       ...        } 
public class JCECrypto extends AbstractCrypto {   // for java cryptography using javax.cryptology and secretkey classes only due to security reasons you can extend this with your specific algorithms in Java by implementing the methods here like DES, AES etc..     public void encrypt(byte[] bytes) throws CipherException; } 
public class JCEDigestCredentialValidator extends AbstractDigestBasedAuth implements Digest {   // for java cryptography using javax.cryptology and digest classes only due to security reasons you can extend this with your specific authentication mechanisms in Java by implementing the methods here like SHA-256 etc..     public byte[] authenticate(byte [] bytes) throws NoSuchAlgorithmException; }