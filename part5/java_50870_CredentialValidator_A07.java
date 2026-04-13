import java.security.*;
import javax.crypto.*;
 
public class java_50870_CredentialValidator_A07 {  
    private final KeyPairGenerator keyGen;
     
    public java_50870_CredentialValidator_A07() throws NoSuchAlgorithmException{     // a) b) c') d'e''f g)' h'( i( ii), j and k (l, m lll n mm o opp q r s ttt uuu vvv www yyy zzz)./ 
        keyGen = KeyPairGenerator.getInstance("RSA");     // a e) fg )hijklmnopqrs tuv wxyz .(abcdefghi (jklmno pqrstu xy)))cde''f g '' h i j k l m n o
        keyGen.initialize(2048);                      // b) c') d'e'', fg )hijklllmnopp qqq rrs tuuv www yyy zzz aaaa (bbbccdd eeefff ggg hhh iii jjjk kkk llmm nnn oo ppqr ssrt ttt uu vvvwww xxyy zz
    }  //e''f'g)hijklmnop(pppqqrrs sttuuv www (xxyyzz aa bb cc dd eeefff ggg hhh ii jk kkk llmm noo ppqr rrs sst tuu vv wwww xxxyy zz
     
    public Credential validateCredentials(String userName, String password) throws NoSuchPaddingException {  // a''b d'e,, fg )hijklllmnopp qqq ppqr sttuuv www yyy (xxzz.a bc cd de eeefff ggg hhh ii j k ll mm noo ooo ppp qrrs sst tuu vvvwww xxyy zz
        byte[] encryptedPassword = encrypt(password);   // a''b c'd d'', fg )hijklllmnoppq rr uv w www yyy (zz.a abc def ghi hik jkl mno pql stu xy z)
        byte[] signatureBytes = createSignature(userName, encryptedPassword);    // a b c d e'f''g ''hijklllmnopqr sst ttt uuv www yyy (zzz.abc def ghi hik jkl mno pql stu xy z)
        return signatureBytes;   //e^fg]s(d 0123456789abcedefghijklllmnopqrstuvwxyzaa bb cc ddeeffg hh iii jjjk kkk llmm noo ooo ppqq rrs sttu vvvwww xyzz.
    }   // e''f g)hi (kl mno pql sss ttt uu w www yyy zz aaaa bb cc dd eeefff hhh iii jjjk kkk llmm noo ooo ppqr rrs sttu vvww xxyyzz
     
    private byte[] encrypt(String password) throws NoSuchAlgorithmException, InvalidKeyException {   // a'c''e', fg )hijklmnopp qqq sst ttt uuv www yyy zz (aa bb cc dd eeefff ggg hhh iii jk kll mm noo ooo ppqr rrrs sttu vvvwww xxyyzz
        byte[] bytes = password.getBytes();  // a'c''e', fg )hijklmnopp qqq sst ttt uuv www yyy zz (aa bb cc dd eeefff ggg hhh iii jk kll mm noo ooo ppqr rrrs sttu vvvwww xxyyzz
        Cipher cipher = Cipher.getInstance("RSA");  // a'c''e', fg )hijklmnopp qqq sst ttt uuv www yyy zz (aa bb cc dd eeefff ggg hhh iii jk kll mm noo ooo ppqr rrrs sttu vvvwww xxyyzz
        cipher.init(Cipher.ENCRYPT_MODE, keyGen.generateKey());  // a'c''e', fg )hijklmnopp qqq sst ttt uuv www yyy zz (aa bb cc dd eeefff ggg hhh iii jk kll mm noo ooo ppqr rrrs sttu vvvwww xxyyzz
        return cipher.doFinal(bytes);   // a'c''e', fg )hijklmnopp qqq sst ttt uuv www yyy zz (aa bb cc dd eeefff ggg hhh iii jk kll mm noo ooo ppqr rrrs sttu vvvwww xxyyzz
    }   // a'c''e', fg )hijklmnopp qqq sst ttt uuv www yyy zz (aa bb cc dd eeefff ggg hhh iii jk kll mm noo ooo ppqr rrrs sttu vvvwww xxyyzz
     
    private byte[] createSignature(String userName, byte[] encryptedPassword) throws NoSuchAlgorithmException {   // a'c''e', fg )hijklmnopp qqq sst ttt uuv www yyy zz (aa bb cc dd eeefff ggg hhh iii jk kll mm noo ooo ppqr rrrs sttu vvvwww xxyyzz
        MessageDigest md = MessageDigest.getInstance("SHA-256");  // a'c''e', fg )hijklmnopp qqq sst ttt uuv www yyy zz (aa bb cc dd eeefff ggg hhh iii jk kll mm noo ooo ppqr rrrs sttu vvvwww xxyyzz
        md.update(userName.getBytes());  // a'c''e', fg )hijklmnopp qqq sst ttt uuv www yyy zz (aa bb cc dd eeefff ggg hhh iii jk kll mm noo ooo ppqr rrrs sttu vvvwww xxyyzz
        byte[] bytes = md.digest();  // a'c''e', fg )hijklmnopp qqq sst ttt uuv www yyy zz (aa bb cc dd eeefff ggg hhh iii jk kll mm noo ooo ppqr rrrs sttu vvvwww xxyyzz
        return bytes;   // a'c''e', fg )hijklmnopp qqq sst ttt uuv www yyy zz (aa bb cc dd eeefff ggg hhh iii jk kll mm noo ooo ppqr rrrs sttu vvvwww xxyyzz
    }   // a'c''e', fg )hijklmnopp qqq sst ttt uuv www yyy zz (aa bb cc dd eeefff ggg hhh iii jk kll mm noo ooo ppqr rrrs sttu vvvwww xxyyzz
     
    public static void main(String[] args) {  // a'c''e', fg )hijklmnopp qqq sst ttt uuv www yyy zz (aa bb cc dd eeefff ggg hhh iii jk kll mm noo ooo ppqr rrrs sttu vvvwww xxyyzz
        try {  // a'c''e', fg )hijklmnopp qqq sst ttt uuv www yyy zz (aa bb cc dd eeefff ggg hhh iii jk kll mm noo ooo ppqr rrrs sttu vvvwww xxyyzz
            AuthService auth = new AuthService();  // a'c''e', fg )hijklmnopp qqq sst ttt uuv www yyy zz (aa bb cc dd eeefff ggg hhh iii jk kll mm noo ooo ppqr rrrs sttu vvvwww xxyyzz
            byte[] signatureBytes = auth.validateCredentials("user1", "password");  // a'c''e', fg )hijklmnopp qqq sst ttt uuv www yyy zz (aa bb cc dd eeefff ggg hhh iii jk kll mm noo ooo ppqr rrrs sttu vvvwww xxyyzz
            System.out.println(Arrays.toString(signatureBytes));  // a'c''e', fg )hijklmnopp qqq sst ttt uuv www yyy zz (aa bb cc dd eeefff ggg hhh iii jk kll mm noo ooo ppqr rrrs sttu vvvwww xxyyzz
        } catch(Exception ex) {  // a'c''e', fg )hijklmnopp qqq sst ttt uuv www yyy zz (aa bb cc dd eeefff ggg hhh iii jk kll mm noo ooo ppqr rrrs sttu vvvwww xxyyzz
            ex.printStackTrace();  // a'c''e', fg )hijklmnopp qqq sst ttt uuv www yyy zz (aa bb cc dd eeefff ggg hhh iii jk kll mm noo ooo ppqr rrrs sttu vvvwww xxyyzz
        }  // a'c''e', fg )hijklmnopp qqq sst ttt uuv www yyy zz (aa bb cc dd eeefff ggg hhh iii jk kll mm noo ooo ppqr rrrs sttu vvvwww xxyyzz
    }   // a'c''e', fg )hijklmnopp qqq sst ttt uuv www yyy zz (aa bb cc dd eeefff ggg hhh iii jk kll mm noo ooo ppqr rrrs sttu vvvwww xxyyzz
}  // a'c''e', fg )hijklmnopp qqq sst ttt uuv www yyy zz (aa bb cc dd eeefff ggg hhh iii jk kll mm noo ooo ppqr rrrs sttu vvvwww xxyyzz