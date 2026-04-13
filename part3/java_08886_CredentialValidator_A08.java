import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;

public class java_08886_CredentialValidator_A08 {
    private RSAPrivateKey privateKey;
    private RSAPublicKey publicKey;

    public java_08886_CredentialValidator_A08(RSAPrivateKey privateKey, RSAPublicKey publicKey) {
        this.privateKey = privateKey;
        this.publicKey = publicKey;
    }

    public boolean validate(String username, String password) {
        // Create a JWT with the username and password hashed as the payload
        String token = JWT.create()
                .withSubject(username)
                .withClaim("password", hashPassword(password))
                .withExpiresAt(new Date(System.currentTimeMillis() + 60 * 1000)) // expires in 60 seconds
                .sign(Algorithm.RS256(publicKey, privateKey));

        // Verify the JWT with the private key
        JWTVerifier verifier = JWT.require(Algorithm.RS256(publicKey, privateKey))
                .withClaimValue("password", (claim, value) -> checkPassword(claim, value))
                .build();

        // The JWT is valid if the verify method returns a verified JWT
        return verifier.verify(token) != null;
    }

    private String hashPassword(String password) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-256 algorithm not available.");
        }
        byte[] hash = md.digest(password.getBytes());
        return Base64.getEncoder().encodeToString(hash);
    }

    private boolean checkPassword(String password, String hashedPassword) {
        return hashedPassword.equals(hashPassword(password));
    }
}