package com.company.bitoperations.implementation.rsa;

import com.sun.istack.internal.NotNull;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created by alexander on 01/02/17.
 */
public class Decoder {
    private static int FERMAT_UPPER_BOUND = 15;

    private BigInteger d;
    private PublicKey publicKey;

    Decoder(@NotNull BigInteger p, @NotNull BigInteger q) {
        BigInteger fi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        BigInteger e = getE(fi);

        d = e.modInverse(fi);
        publicKey = new PublicKey(e, p.multiply(q));
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }

    public byte[] decode(@NotNull byte[] source) {
        BigInteger target = new BigInteger(source);
        return target.modPow(d, publicKey.getN()).toByteArray();
    }

    public BigInteger decode(BigInteger source) {
        return source.modPow(d, publicKey.getN());
    }

    private BigInteger getE(BigInteger fi) {
        SecureRandom random = new SecureRandom();
        BigInteger e;

        int fermatNumber;
        do  {
            fermatNumber = random.nextInt(FERMAT_UPPER_BOUND);
            e = BigInteger.valueOf(2).pow(((int) Math.pow(2, fermatNumber))).add(BigInteger.ONE);
        } while (!e.gcd(fi).equals(BigInteger.ONE) || (fi.compareTo(e) < 0));

        return e;
    }
}
