
public class CryptoChar {

    private int codeLength;
    private boolean isDivider;

    public CryptoChar(int codeLength, boolean isDivider){
        this.codeLength = codeLength;
        this.isDivider = isDivider;
    }
    public int getCodeLength(){
        return codeLength;
    }

    public boolean getIsDivider(){
        return isDivider;
    }
}
