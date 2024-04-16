/*
Created by Aayush Sharma.
Website: aayushsharma.remotikal.com 
Github: https://github.com/aayushsharma-io/
*/
import java.io.*;

public class FileEncryptorDecryptor {

    // Function to encrypt the contents of a file
    public static void encryptFile(String inputFile, String outputFile, int key) {
        try (FileReader fileReader = new FileReader(inputFile);
             FileWriter fileWriter = new FileWriter(outputFile)) {

            int character;
            while ((character = fileReader.read()) != -1) {
                // Shift the character by the key value
                char encryptedChar = (char) (character + key);
                fileWriter.write(encryptedChar);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Function to decrypt the contents of a file
    public static void decryptFile(String inputFile, String outputFile, int key) {
        // Decryption is just the reverse of encryption, so we use negative key
        encryptFile(inputFile, outputFile, -key);
    }

    public static void main(String[] args) {
        // Example usage:
        String inputFile = "input.txt";
        String encryptedFile = "encrypted.txt";
        String decryptedFile = "decrypted.txt";
        int encryptionKey = 3; // You can change this value as per your preference

        // Encrypt the input file
        encryptFile(inputFile, encryptedFile, encryptionKey);
        System.out.println("File encrypted successfully!");

        // Decrypt the encrypted file
        decryptFile(encryptedFile, decryptedFile, encryptionKey);
        System.out.println("File decrypted successfully!");
    }
}
