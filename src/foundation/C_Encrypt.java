package foundation;

import util.CryptoTools;

public class C_Encrypt
{
    public static void main(String[] args) throws Exception
    {
        int key = 19;

        byte [] raw = CryptoTools.fileToBytes("data/MSG1.pt");
        byte [] pt = CryptoTools.clean(raw);
        byte [] ct = new byte[pt.length];
        CryptoTools.bytesToFile(pt, "data/MSG1.clean");

        for(int i = 0; i < pt.length; i++)
        {
            ct[i] = (byte) ((pt[i] - 'A' + key) % 26 + 'A');
        }
        CryptoTools.bytesToFile(ct, "data/MSG1.ct");
        System.out.println("MD5 = " + CryptoTools.getMD5(ct));
        if(CryptoTools.getMD5(ct).equals("2C422B741EF90FD4424EBC83692398B0"));
        {
            System.out.println("TRUE");
        }

        double pt_IC = CryptoTools.getIC(pt);
        double ct_IC = CryptoTools.getIC(ct);

        System.out.println("pt IC = " + pt_IC +
                "\n" + "ct IC = " + ct_IC);

    }
}
