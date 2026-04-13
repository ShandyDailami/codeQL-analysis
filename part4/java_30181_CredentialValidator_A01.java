public class java_30181_CredentialValidator_A01 {

    // Predefined credentials in the format: username:password
    private static final String[] AUTHORIZED_USERS = {
        "admin:admin",
        "user1:user1",
        "user2:user2",
        "user3:user3"
    };

    public boolean validate(String username, String password) {
        // Convert the username and password into a format that can be compared to the AUTHORIZED_USERS
        String[] creds = (username + ":" + password).split(":");

        // Check if the converted credentials match any of the authorized users
        for (String auth : AUTHORIZED_USERS) {
            if (auth.equals(creds[0] + ":" + creds[1])) {
                return true;
            }
        }

        return false;
    }

}