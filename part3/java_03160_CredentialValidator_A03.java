import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.x500.X500Principal;
import javax.security.auth.x509.X509CertificateImpl;

import javax.security.auth.CredentialValidator;
import javax.security.auth.CredentialValidatorResult;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

public class java_03160_CredentialValidator_A03 implements CredentialValidator, CallbackHandler {

    private List<String> acceptedIssuers = new ArrayList<>();

    public java_03160_CredentialValidator_A03() {
        acceptedIssuers.add("CN=MyCompany, OU=MyDepartment, O=MyCompany, C=US");
    }

    @Override
    public CredentialValidatorResult validate(CallbackHandler callbackHandler, X509Certificate cert) {
        Callback callback = callbackHandler.getCallback();
        try {
            // Get issuer from certificate
            X500Principal issuer = new X500Principal(cert.getIssuerX500());
            // Validate issuer
            if (!acceptedIssuers.contains(issuer.getIssuerDN())) {
                callback.put(callbackHandler.getCallbackType(), "Issuer not accepted");
                return new CredentialValidatorResult("Issuer not accepted");
            }
            // If no validation errors, return success
            return new CredentialValidatorResult("Success");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean getRequestedCredentialIndication(String s) {
        return false;
    }

    @Override
    public List<X509Certificate> getAcceptedIssuers() {
        List<X509Certificate> list = new ArrayList<>();
        try {
            X509CertificateImpl cert = new X509CertificateImpl("");
            list.add(cert);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}