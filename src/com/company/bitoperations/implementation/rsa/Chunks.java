package com.company.bitoperations.implementation.rsa;

import com.sun.istack.internal.NotNull;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by alexander on 02/02/17.
 */
public class Chunks {
    private int chunkSize;
    private List<byte[]> chunks;

    private Chunks() {

    }

    public byte[] getChunk(int index) {
        byte[] chunk = chunks.get(index);
        return Arrays.copyOf(chunk, chunk.length);
    }

    public byte getByte(int chunkNumber, int byteNumber) {
        return chunks.get(chunkNumber)[byteNumber];
    }

    public int getByteCount() {
        return chunks.stream().mapToInt(b -> b.length).reduce(0, (a, b) -> a + b);
    }

    public static Chunks createChunks(@NotNull byte[] source, int chunkSize) {
        return createChunks(source, chunkSize, b -> b);
    }

    public static Chunks createChunks(@NotNull byte[] source,
                                      int chunkSize,
                                      @NotNull Function<? super byte[], ? extends byte[]> function) throws IllegalArgumentException{
        if (chunkSize <= 0)
            throw new IllegalArgumentException("chunkSize must be greater then 0. Got " + chunkSize);

        Chunks newChunk = new Chunks();
        int sourceLength = source.length;
        int chunksCount = (source.length + chunkSize - 1) / chunkSize;

        newChunk.chunkSize = chunkSize;
        newChunk.chunks = IntStream.
                range(0, chunksCount).
                mapToObj(n -> {
                    byte[] result;

                    if (sourceLength > (n + 1) * chunkSize) {
                        result = Arrays.copyOfRange(source, n * chunkSize, (n + 1) * chunkSize);
                    } else {
                        result = Arrays.copyOfRange(source, n * chunkSize, sourceLength);
                    }

                    return function.apply(result);
                }).
                collect(Collectors.toList());

        return newChunk;
    }

    public Chunks applyFunction(@NotNull Function<? super byte[], ? extends byte[]> function) {
        Chunks result = new Chunks();
        LinkedList<byte[]> newChunks = new LinkedList<>();
        result.chunks = newChunks;

        chunks.forEach(b -> newChunks.addLast(function.apply(b)));

        return result;
    }

    public byte[] asByteArray() {
        ByteOutputStream stream = new ByteOutputStream(getByteCount());
        chunks.forEach(stream::write);
        return stream.getBytes();
    }
}
