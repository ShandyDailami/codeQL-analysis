import com.google.api.client.auth.Credential;
import com.google.api.client.auth.CredentialProvider;
import com.google.api.client.auth.CredentialProviderChain;
import com.google.api.client.auth.oauth2.CredentialUtils;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public class java_14104_CredentialValidator_A01 {

    public static void main(String[] args) throws Exception {
        // Define the credentials
        Credential credential = getCredentials();

        // Initialize Sheets API
        HttpTransport httpTransport = new NetHttpTransport();
        JacksonFactory jsonFactory = new JacksonFactory();
        Sheets sheetsService = new Sheets.Builder(httpTransport, jsonFactory, credential)
                .setApplicationName("Google Sheets API Java Example/1.0")
                .build();

        String spreadsheetId = "your_spreadsheet_id";
        String range = "Sheet1!A:B";

        // Read from the spreadsheet
        Sheets.Spreadsheets.Values response = sheetsService.spreadsheets().values()
                .get(spreadsheetId, range)
                .setValueResultFormat(Sheets.Values.ValueResultFormat.FULL);
        List<List<Object>> values = response.execute().getValues();

        if (values.isEmpty()) {
            System.out.println("No data found.");
        } else {
            for (List<Object> row : values) {
                for (Object obj : row) {
                    System.out.printf("%s ", obj);
                }
                System.out.println();
            }
        }
    }

    private static Credential getCredentials() throws Exception {
        // Define the scopes
        List<String> scopes = Collections.singletonList(SheetsScopes.SPREADSHEETS_READONLY);

        // Create the credential provider
        CredentialProvider provider = new CredentialProviderChain() {
            @Override
            public Credential getCredential(HttpTransport httpTransport) throws Exception {
                // Use your own login logic here, e.g. use Google login with the user's email
                return new Credential() {
                    @Override
                    public String getAuthUrl() {
                        throw new UnsupportedOperationException();
                    }

                    @Override
                    public Credential refreshCredential(String refreshToken) throws Exception {
                        throw new UnsupportedOperationException();
                    }

                    @Override
                    public InputStream getResourceStream() throws Exception {
                        throw new UnsupportedOperationException();
                    }

                    @Override
                    public String getAccessToken() throws Exception {
                        return "your_access_token";
                    }

                    @Override
                    public void storeCredentials(String accessToken, String refreshToken) throws Exception {
                        // Not used in this example
                    }
                };
            }
        };

        // Get the user's credentials
        return CredentialUtils.newCredential(provider, scopes);
    }
}