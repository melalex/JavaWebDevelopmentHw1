package com.company.bitoperations.test;

import com.company.bitoperations.implementation.rsa.Chunks;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by alexander on 02/02/17.
 */
class ChunksTest {
    static private final int CHUNK_SIZE = 2;
    static private final byte[] ARRAY = new byte[] {0, 1, 2, 3, 4, 5, 6, 7};

    @Test
    void createChunksEven() {
        byte[] ARRAY = new byte[] {0, 1, 2, 3, 4, 5, 6, 7};

        Chunks chunks = Chunks.createChunks(ARRAY, CHUNK_SIZE);

        for (int i = 0; i < ARRAY.length; i++) {
            assertEquals(ARRAY[i], chunks.getByte(i / CHUNK_SIZE, i % CHUNK_SIZE));
        }
    }

    @Test
    void createChunksOdd() {
        byte[] array = new byte[] {0, 1, 2, 3, 4, 5, 6, 7, 8};

        Chunks chunks = Chunks.createChunks(array, CHUNK_SIZE);

        for (int i = 0; i < ARRAY.length; i++) {
            assertEquals(ARRAY[i], chunks.getByte(i / CHUNK_SIZE, i % CHUNK_SIZE));
        }
    }

    @Test
    void createChunksWithFunction() {
        Chunks chunks = Chunks.createChunks(ARRAY, CHUNK_SIZE, b -> {
            b[0] = 0;
            b[1] = 0;
            return b;
        });

        for (int i = 0; i < ARRAY.length; i++) {
            assertEquals(0, chunks.getByte(i / CHUNK_SIZE, i % CHUNK_SIZE));
        }
    }

    @Test
    void applyFunction() {
        Chunks chunks = Chunks.createChunks(ARRAY, CHUNK_SIZE);
        chunks = chunks.applyFunction(b -> {
            b[0] = 0;
            b[1] = 0;
            return b;
        });

        for (int i = 0; i < ARRAY.length; i++) {
            assertEquals(0, chunks.getByte(i / CHUNK_SIZE, i % CHUNK_SIZE));
        }
    }

    @Test
    void asByteArray() {
        Chunks chunks = Chunks.createChunks(ARRAY, CHUNK_SIZE);
        byte[] array = chunks.asByteArray();

        for (int i = 0; i < ARRAY.length; i++) {
            assertEquals(ARRAY[i], array[i]);
        }
    }

}