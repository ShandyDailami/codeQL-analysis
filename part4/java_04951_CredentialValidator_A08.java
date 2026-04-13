public class java_04951_CredentialValidator_A08 implements CredentialValidator {

    private static final String SALT = "A08_IntegrityFailure";

    private MessageDigest messageDigest;

    public java_04951_CredentialValidator_A08() {
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean validate(Credential credential) {
        String inputPassword = credential.getPassword();
        String hashedPassword = getHashedPassword(inputPassword);
        return hashedPassword.equals(credential.getPasswordHash());
    }

    private String getHashedPassword(String password) {
        messageDigest.update(password.getBytes());
        byte[] bytes = messageDigest.digest();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }
}