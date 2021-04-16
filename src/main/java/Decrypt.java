import java.math.BigInteger;

public class Decrypt {

    private CryptoChar[] charactersInfo;
    private BigInteger integerToDecrypt;
    private BigInteger key;

    public Decrypt(BigInteger integerToDecrypt, BigInteger key, CryptoChar[]charactersInfo){
        this.charactersInfo = charactersInfo;
        this.integerToDecrypt = integerToDecrypt;
        this.key = key;
    }

    public String decrypt (){
        StringBuilder builder = new StringBuilder();
        String bigIntToString = String.valueOf(integerToDecrypt.xor(key));
        int i=0;
        int j=0;
        while(i<this.charactersInfo.length){
            char currentChar = (char)Integer.parseInt(bigIntToString.substring(j,(j+charactersInfo[i].getCodeLength())));
            j=j+charactersInfo[i].getCodeLength();
            i++;
            if (currentChar == '/'){
                builder.append(" ");
                continue;
            }
            builder.append(currentChar);
        }
        return builder.toString();
    }
}
