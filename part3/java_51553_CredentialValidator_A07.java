import javax.security.auth.*;
// Importing AuthenticationException, BadCredentialsException from Security package to handle exceptions thrown by the credential validation process itself and its sub-exceptions: InvalidCredentialException when username or password is invalid in some way; DisabledException if a user account has been disabled via an auth provider after having enabled it.
import java.security.*;
// Importing MessageDigest, NoSuchAlgorithmException from Security package to handle exceptions thrown by the message digest and its sub-exceptions: InvalidKeySpecs when key length is less than required or if encryption algorithm not suitable for given context (like a symmetric cipher). 
import java.security.*;
// Importing Provider exception, NoSuchProviderException in case no provider could be found to create the cryptographic operations needed by this class java_51553_CredentialValidator_A07: CryptographyRequirementsUnavailableException when creating an instance of AES or DES algorithm requires requirements that are not met (like lacks a specific hardware support). 
import java.security.*;
// Importing InvalidAlgorithmParameterException, NoSuchPaddingException in case the padding method isn't available for this key provider and its sub-exceptions: InappropriateBlockCipherMode if mode is unknown or unsupported by associated cipher (like AES at CBC mode only). 
import javax.crypto.*;
// Importing InvalidKeyException, NoSuchAlgorithmException in case the algorithm isn't available for this key provider and its sub-exceptions: IllegalBlockSizeException if a block size is not appropriate given context like DES requires an odd number of blocks (4 bits/block). 
import javax.crypto.*;
// Importing InvalidKeySpecs, NoSuchAlgorithmException in case the algorithm isn't available for this key provider and its sub-exceptions: LengthInvalid if encrypted data has a length that is not accepted by encryption or decryption algorithms (length of input to authenticate must be correct). 
import javax.crypto.*;
// Importing IncorrectKeyException, NoSuchPaddingException in case padding method isn't available for this key provider and its sub-exceptions: WrongPasswordException if the password is incorrect when trying a cipher with wrong (or no) credentials or mismatched passphrase used. 
import javax.crypto.*;
// Importing UnsupportedAlgorithmParameterException, NoSuchPaddingException in case padding method isn't available for this key provider and its sub-exceptions: InvalidKey if the provided Key is invalid with respect to context (like a RSA private/public).