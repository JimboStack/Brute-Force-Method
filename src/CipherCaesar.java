import java.io.*;

public class CipherCaesar {
    public void decryptFile(String scrFilePath, String destFilePath, Integer offset) {
        UI ui = new UI();
        try (BufferedReader reader = new BufferedReader(new FileReader(scrFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                StringBuilder encryptedText = new StringBuilder();
                for (int i = 0; i < line.length(); i++) {
                    char currentChar = line.charAt(i);
                    char encryptedChar = (char) ((int) currentChar - offset);
                    encryptedText.append(encryptedChar);
                    writer.write(encryptedChar);
                }
            }
        } catch (IOException | RuntimeException e) {
            e.printStackTrace();
        } ui.successDecrypt();
    }
    public void encryptFile(String scrFilePath, String destFilePath, Integer offset) {
        UI ui = new UI();
        try (BufferedReader reader = new BufferedReader(new FileReader(scrFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                StringBuilder encryptedText = new StringBuilder();
                for (int i = 0; i < line.length(); i++) {
                    char currentChar = line.charAt(i);
                    char encryptedChar = (char) ((int) currentChar + offset);
                    encryptedText.append(encryptedChar);
                    writer.write(encryptedChar);
                }
            }
        } catch (IOException | RuntimeException x) {
            x.printStackTrace();
        } ui.successEncrypt();
    }
}


