package com.room414.homework1.rsa.datastructures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by alexander on 02/02/17.
 */
class ChunksTest {
    static private final int CHUNK_SIZE = 2;
    static private final byte[] EVEN_ARRAY = new byte[] {0, 1, 2, 3, 4, 5, 6, 7};
    static private final byte[] ODD_ARRAY = new byte[] {0, 1, 2, 3, 4, 5, 6, 7, 8};

    @Test
    void createChunksEven() {
        Chunks chunks = Chunks.createChunks(EVEN_ARRAY, CHUNK_SIZE);

        for (int i = 0; i < EVEN_ARRAY.length; i++) {
            assertEquals(EVEN_ARRAY[i], chunks.getByte(i / CHUNK_SIZE, i % CHUNK_SIZE));
        }
    }

    @Test
    void createChunksOdd() {
        Chunks chunks = Chunks.createChunks(ODD_ARRAY, CHUNK_SIZE);

        for (int i = 0; i < EVEN_ARRAY.length; i++) {
            assertEquals(EVEN_ARRAY[i], chunks.getByte(i / CHUNK_SIZE, i % CHUNK_SIZE));
        }
    }

    @Test
    void createChunksThrows() {
        byte[] array = new byte[] {0, 1, 2, 3, 4, 5, 6, 7, 8};
        assertThrows(IllegalArgumentException.class, () -> Chunks.createChunks(array, -1));
        assertThrows(IllegalArgumentException.class, () -> Chunks.createChunks(array, 0));
    }

    @Test
    void createChunksWithFunction() {
        Chunks chunks = Chunks.createChunks(EVEN_ARRAY, CHUNK_SIZE, b -> {
            b[0] = 0;
            b[1] = 0;
            return b;
        });

        for (int i = 0; i < EVEN_ARRAY.length; i++) {
            assertEquals(0, chunks.getByte(i / CHUNK_SIZE, i % CHUNK_SIZE));
        }
    }

    @Test
    void applyFunction() {
        Chunks chunks = Chunks.createChunks(EVEN_ARRAY, CHUNK_SIZE);
        chunks = chunks.applyFunction(b -> {
            b[0] = 0;
            b[1] = 0;
            return b;
        });

        for (int i = 0; i < EVEN_ARRAY.length; i++) {
            assertEquals(0, chunks.getByte(i / CHUNK_SIZE, i % CHUNK_SIZE));
        }
    }

    @Test
    void asByteArray() {
        Chunks chunks = Chunks.createChunks(EVEN_ARRAY, CHUNK_SIZE);
        byte[] array = chunks.asByteArray();

        for (int i = 0; i < EVEN_ARRAY.length; i++) {
            assertEquals(EVEN_ARRAY[i], array[i]);
        }
    }

    @Test
    public void getChunkEven() {
        Chunks chunks = Chunks.createChunks(EVEN_ARRAY, CHUNK_SIZE);
        byte[] buffer;

        for (int i = 0; i < (EVEN_ARRAY.length + CHUNK_SIZE - 1) / CHUNK_SIZE; i++) {
            buffer = chunks.getChunk(i);
            for (int j = 0; j < buffer.length; j++ ) {
                assert EVEN_ARRAY[i * CHUNK_SIZE + j] == buffer[j];
            }
        }
    }

    @Test
    public void getChunkOdd() {
        Chunks chunks = Chunks.createChunks(ODD_ARRAY, CHUNK_SIZE);
        byte[] buffer;

        for (int i = 0; i < (ODD_ARRAY.length + CHUNK_SIZE - 1) / CHUNK_SIZE; i++) {
            buffer = chunks.getChunk(i);
            for (int j = 0; j < buffer.length; j++ ) {
                assert ODD_ARRAY[i * CHUNK_SIZE + j] == buffer[j];
            }
        }
    }

    @Test
    void getByte() {
        Chunks chunks = Chunks.createChunks(EVEN_ARRAY, CHUNK_SIZE);

        for (int i = 0; i < EVEN_ARRAY.length; i++) {
            assert EVEN_ARRAY[i] == chunks.getByte(i / CHUNK_SIZE, i % CHUNK_SIZE);
        }
    }

    @Test
    void getByteCount() {
        Chunks chunks = Chunks.createChunks(EVEN_ARRAY, CHUNK_SIZE);

        assert chunks.getByteCount() == EVEN_ARRAY.length;
    }
}