import javax.naming.AuthenticationException;
import javax.naming.CompoundName;
import javax.naming.Name;
import javax.naming.NamingException;

public class java_33212_CredentialValidator_A03 implements javax.naming.AuthenticationValidator {

    @Override
    public Name validate(Name name) throws AuthenticationException {
        CompoundName compoundName = null;
        if (name instanceof CompoundName) {
            compoundName = (CompoundName) name;
        }

        if (compoundName == null) {
            throw new IllegalArgumentException("Invalid name");
        }

        if (!compoundName.getPrimary().equals("user") ||
                !compoundName.getRelated("domain").equals("mycompany.com")) {
            throw new AuthenticationException("Invalid credentials");
        }

        return compoundName;
    }

    @Override
    public boolean validate(Object arg0) throws AuthenticationException {
        return false;
    }
}