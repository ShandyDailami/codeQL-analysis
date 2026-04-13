public class java_06517_CredentialValidator_A01 {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static class LegacyValidator implements CredentialValidator {

        @Override
        public boolean validate(InputStream credential) throws CredentialException {
            try {
                // Assume that the credential is a JSON object with fields "username" and "password"
                BufferedReader reader = new BufferedReader(new InputStreamReader(credential));
                JSONObject json = new JSONObject(reader.readLine());
                String providedUsername = json.getString("username");
                String providedPassword = json.getString("password");

                return USERNAME.equals(providedUsername) && PASSWORD.equals(providedPassword);
            } catch (IOException | JSONException e) {
                throw new CredentialException(e);
            }
        }

        @Override
        public String getChallenge(String origin, String action) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean supported(String scheme) {
            throw new UnsupportedOperationException();
        }

    }

    public static void main(String[] args) {
        CredentialValidator validator = new LegacyValidator();
        try {
            validator.validate(new ByteArrayInputStream("{username: 'admin', password: 'password'}".getBytes()));
            System.out.println("Authentication succeeded!");
        } catch (CredentialException e) {
            System.out.println("Authentication failed!");
        }
    }

}