package com.indra.passwordchecker;
import org.bouncycastle.crypto.digests.KeccakDigest;
import org.bouncycastle.util.encoders.Hex;


public class Keccak512Hasher {

    public static String generateKECCAK512Hash(String input) {
        KeccakDigest digest = new KeccakDigest(512);
        byte[] inputBytes = input.getBytes();
        byte[] hashBytes = new byte[digest.getDigestSize()];

        digest.update(inputBytes, 0, inputBytes.length);
        digest.doFinal(hashBytes, 0);

        return Hex.toHexString(hashBytes);
    }


}
