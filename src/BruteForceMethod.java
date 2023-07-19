import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BruteForceMethod {
    private static final String ALPHABET = getAllUnicodeCharacters();
    private static final int ALPHABET_SIZE = ALPHABET.length();
    private boolean isValidDecryption(String decryptedText) {
        return decryptedText.matches("^[A-Z].*[ ,.?!]$");
    }
    private static String getAllUnicodeCharacters() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = Character.MIN_VALUE; i <= Character.MAX_VALUE; i++) {
            stringBuilder.append((char) i);
        }
        return stringBuilder.toString();
    }

    public String bruteForceDecrypt(String inputFile) {
        UI ui = new UI();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String encryptedText = reader.readLine();

            for (int key = 0; key < ALPHABET_SIZE; key++) {
                StringBuilder decryptedText = new StringBuilder();

                for (int i = 0; i < encryptedText.length(); i++) {
                    char encryptedChar = encryptedText.charAt(i);
                    int alphabetIndex = ALPHABET.indexOf(Character.toLowerCase(encryptedChar));

                    if (alphabetIndex != -1) {
                        int decryptedIndex = (alphabetIndex - key + ALPHABET_SIZE) % ALPHABET_SIZE;
                        char decryptedChar = ALPHABET.charAt(decryptedIndex);

                        if (Character.isUpperCase(encryptedChar)) {
                            decryptedChar = Character.toUpperCase(decryptedChar);
                        }
                        decryptedText.append(decryptedChar);
                    } else {
                        decryptedText.append(encryptedChar);
                    }
                }
                if (isValidDecryption(decryptedText.toString())) {
                    return decryptedText.toString();
                }
            }
            ui.failedDecrypt();

        } catch (IOException e) {
            e.printStackTrace();
        } return null;
    }

}




