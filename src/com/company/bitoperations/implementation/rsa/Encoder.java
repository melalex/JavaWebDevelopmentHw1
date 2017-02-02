package com.company.bitoperations.implementation.rsa;

import com.sun.istack.internal.NotNull;

import java.math.BigInteger;
import java.util.function.Function;

/**
 * Created by alexander on 01/02/17.
 */
public class Encoder {
    private PublicKey key;

    Encoder(PublicKey key) {
        this.key = key;
    }

    public Chunks encode(@NotNull byte[] source) {
        int chunkSize = Integer.highestOneBit(key.getN().bitCount()) >> 3;

        Function<? super byte[], ? extends byte[]> function = b -> {
            BigInteger target = new BigInteger(b);
            return target.modPow(key.getE(), key.getN()).toByteArray();
        };

        return Chunks.createChunks(source, chunkSize, function);
    }
}
