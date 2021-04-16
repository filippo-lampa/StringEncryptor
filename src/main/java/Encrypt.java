import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class Encrypt {

    private String stringToEncrypt;
    private BigInteger key;
    private byte[]stringToByteArray;
    CryptoChar[]charactersInfo;

    public Encrypt(String stringToEncrypt){
        if(stringToEncrypt == null)
            throw new NullPointerException("Stringa nulla");
        this.stringToEncrypt = stringToEncrypt;
        this.generateKey();
    }

    private void generateKey (){
        int keyLength = this.stringToEncrypt.length() * 16;
        Random ran = new Random();
        this.key = new BigInteger(keyLength,ran);
    }

    public BigInteger getKey (){
        return this.key;
    }

    public CryptoChar[] getCharactersInfo(){
        return charactersInfo;
    }

    private void stringToByte (){
        StringBuilder builder = new StringBuilder();
        for(int i=0; i<stringToEncrypt.length(); i++) {
            if (stringToEncrypt.charAt(i) == ' '){
                builder.append('/');
                continue;
            }
            builder.append(stringToEncrypt.charAt(i));
        }
        this.stringToByteArray = builder.toString().getBytes(StandardCharsets.UTF_8);
    }

    public BigInteger encrypt (){
        this.stringToByte();
        StringBuilder builder = new StringBuilder();
        charactersInfo = new CryptoChar[stringToByteArray.length];
        for (int i=0; i<stringToByteArray.length; i++) {
            charactersInfo[i] = new CryptoChar(String.valueOf(stringToByteArray[i]).length(),stringToByteArray[i] == 47);
            builder.append(stringToByteArray[i]);
        }
        BigInteger stringToInt = new BigInteger(builder.toString());
        return this.key.xor(stringToInt);
    }
}