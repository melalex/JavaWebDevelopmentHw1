package com.company.bitoperations.implementation.rsa;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

/**
 * Created by alexander on 01/02/17.
 */
public class Decoder {
    private BigInteger d;
    private PublicKey publicKey;

    Decoder(BigInteger p, BigInteger q) {
        BigInteger fi = p.subtract(BigInteger.ONE).multiply(q.add(BigInteger.ONE));
        BigInteger e = getE(fi);

        d = e.modInverse(fi);
        publicKey = new PublicKey(e, p.multiply(q));
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }

    public byte[] decode(byte[] source) {
        BigInteger target = new BigInteger(source);
        return target.modPow(d, publicKey.getN()).toByteArray();
    }

    private BigInteger getE(BigInteger fi) {
        SecureRandom random = new SecureRandom();
        BigInteger e = BigInteger.valueOf(2);

        int fermatNumber = random.nextInt(10);
        do  {
            e = e.pow(((int) Math.pow(2, fermatNumber))).add(BigInteger.ONE);
        } while (fi.gcd(e).equals(BigInteger.ONE) && (fi.compareTo(e) > 0));

        return e;
    }
}
