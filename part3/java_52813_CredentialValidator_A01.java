import java.security.*;   // importing cryptographic classes for KeyPairGenerator, SecureRandom etc..    
public class java_52813_CredentialValidator_A01 {   
 public static void main(String[] args) throws NoSuchAlgorithmException{     
//Step1 : Create a key pair using the secure random source       
KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");          // getting an RSA-based keypair generator object      
kpg.initialize(512, new SecureRandom());   /*  Random number of bits for security */     
//Step3: get the key pair and print some details        Keys k = kpg .generateKey();     System.out.println("Private Key : " +    K .getPrivate().toString() );         // Print private part       return ;}          }                  public class CredentialValidator {     
//Step2:  create a credential using the key        Signature sig = k.sign(msg);     System.out.println("Signature created : " +   K .getPublic().toString() );         // Print signature    }} });`}                }                  public class CredentialValidator {     
//Step4:  validate if creds are valid using the key and signiture        boolean b = sig .verify(msg);     System.out.println("Signature Validation : " +   K .getPublic().toString() );         // Print signature validation    }} });`}                }                  public class CredentialValidator {     
//Step5:  create a creds for another user        KeyPair kp = null; try (KeyStore keystore =  Keys.createKeyStore(new File("keystor.jce"),"password".toCharArray(),null))    K .generateKey();             if (! ((KeyStore)k ).isKeyEntryValid((PrivateKey)K ))) {      //Print error   }}                  return;}}