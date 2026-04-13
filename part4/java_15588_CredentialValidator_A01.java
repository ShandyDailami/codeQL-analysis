import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_15588_CredentialValidator_A01 {

    private static final String SALT = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static void main(String[] args) {
        String password = "password";
        System.out.println(validate(password));
    }

    public static boolean validate(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }
        for (int i = 0; i < password.length(); i++) {
            if (!Character.isLetterOrDigit(password.charAt(i))) {
                return false;
            }
        }
        if (containsDigitButNotSix(password)) {
            return false;
        }
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] thedigest = md.digest(password.getBytes().toString().getBytes());
            return toHex(thedigest) .substring(0,8).equals(md5(password));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static String md5(String md5) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        byte[] messageDigest = md.digest(md5.getBytes());
        return toHex(messageDigest);
    }

    private static String toHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            hexString.append(Integer.toHexString(0xFF & bytes[i]));
        }
        return hexString.toString();
    }

    private static boolean containsDigitButNotSix(String string) {
        for (int i = 0; i < string.length(); i++) {
            if (Character.isDigit(string.charAt(i)) && string.charAt(i) != '6') {
                return true;
            }
        }
        return false;
    }
}