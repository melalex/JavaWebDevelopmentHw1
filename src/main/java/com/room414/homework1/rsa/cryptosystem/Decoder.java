package com.room414.homework1.rsa.cryptosystem;

import com.room414.homework1.rsa.datastructures.Chunks;
import com.room414.homework1.rsa.datastructures.PublicKey;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.function.Function;

/**
 * Provides functionality of RSA cryptosystem
 *
 * Created by alexander on 01/02/17.
 */
public class Decoder {
    private BigInteger d;
    private PublicKey publicKey;

    public Decoder(BigInteger p, BigInteger q) {
        BigInteger fi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        BigInteger e = getE(fi);

        d = e.modInverse(fi);
        publicKey = new PublicKey(e, p.multiply(q));
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }

    /**
     * Decode source encoded by RSA algorithm
     *
     * @param source encoded message
     * @return decoded bytes
     * @see Encoder#encode(byte[])
     */
    public byte[] decode(Chunks source) {
        Function<? super byte[], ? extends byte[]> function = b -> {
            BigInteger target = new BigInteger(b);
            return target.modPow(d, publicKey.getN()).toByteArray();
        };

        return source.applyFunction(function).asByteArray();
    }

    private BigInteger getE(BigInteger fi) {
        SecureRandom random = new SecureRandom();
        BigInteger e;

        do  {
            e = BigInteger.probablePrime(fi.bitCount(), random);
        } while (!e.gcd(fi).equals(BigInteger.ONE) || (fi.compareTo(e) < 0));

        return e;
    }
}
