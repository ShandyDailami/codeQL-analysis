import javax.security.auth.*;
import java.rmi.RemoteException;   // For Remote Exception handling in Java RMI   
public class java_45461_CredentialValidator_A03 implements java.security.AuthProvider {    
// the method that will actually perform authentication...     
@Override           public boolean validate(AuthenticationToken arg0) throws RemoteException, javax.security.auth.login.LoginException  {            // ...with this token....       }        catch (javax.security.sasl.SaslException e){         System.out.println("Error: " +e);     return false;      }}