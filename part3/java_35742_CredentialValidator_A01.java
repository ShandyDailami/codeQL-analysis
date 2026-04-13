import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.security.Key;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class java_35742_CredentialValidator_A01 {

    @InjectMocks
    private CredentialValidator credentialValidator;

    @Test
    public void testValidate() {
        Key key = Keys.hmacShaKeyFor(org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class.getDeclaredField("SECRET").getType().newInstance()).genKeyToSign(org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class.getDeclaredField("ALGORITHM").getType().newInstance()));

        String token = Jwts.builder()
                .setSubject("testUser")
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .signWith(SignatureAlgorithm.HS256, key)
                .compact();

        assertTrue(credentialValidator.validateCredentials(token));

        // Add a token with a past expiration date
        token = Jwts.builder()
                .setSubject("testUser")
                .setIssuedAt(new Date(System.currentTimeMillis() - 100000)) // 100 seconds
                .signWith(SignatureAlgorithm.HS256, key)
                .compact();

        assertFalse(credentialValidator.validateCredentials(token));
    }
}