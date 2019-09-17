package foundation;

import util.CryptoTools;

public class C_Exhaustive
{
    public static void main(String[] args) throws Exception
    {
        byte [] ct = CryptoTools.fileToBytes("data/MSG2.ct");
        byte [] pt = new byte[ct.length];
        int [] freq;

        for(int i = 0; i < ct.length; i++)
        {
            pt = CryptoTools.c_decrypt(ct, i);
            freq =  CryptoTools.getFrequencies(pt);
            System.out.println(CryptoTools.dotProduct(freq));
        }
    }
}
