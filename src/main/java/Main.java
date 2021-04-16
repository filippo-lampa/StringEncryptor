import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        Encrypt provaEncrypt = new Encrypt("Lorem ipsum dolor sit amet, consectetur adipiscing elit");
        BigInteger encryptionResult = provaEncrypt.encrypt();
        System.out.println("Encrypted text: "+encryptionResult);
        Decrypt provaDecrypt = new Decrypt(encryptionResult, provaEncrypt.getKey(), provaEncrypt.getCharactersInfo());
        System.out.println("Decrypted text: "+provaDecrypt.decrypt());
    }
}
