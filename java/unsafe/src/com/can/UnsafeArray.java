package com.can;

import sun.misc.Unsafe;
import java.lang.reflect.Field;

class UnsafeArray<T> implements AutoCloseable {
    private final long GENERIC_BYTE_SIZE;
    private Class<T> type;
    private long capacity;
    private long startPtr;
    private Unsafe UNSAFE;
    private boolean isDestructed = false;

    public UnsafeArray(long capacity, Class<T> type) {
        this.capacity = capacity;
        this.type = type;
        UNSAFE = getUnsafe();

        GENERIC_BYTE_SIZE = getGenericSize();
        startPtr = UNSAFE.allocateMemory(capacity * GENERIC_BYTE_SIZE);
    }

    public void set(long idx, T value) {
        if (isDestructed) {
            throw new RuntimeException("Array is destructed");
        }
        if (idx >= capacity || idx < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }

        var offset = startPtr + (idx * GENERIC_BYTE_SIZE);
        long objectAddress = addressOf(value);

        // Rapid usage of UNSAFE.putAddress() causes malloc error
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        UNSAFE.putAddress(offset, objectAddress);
    }

    public T get(long idx) {
        if (isDestructed) {
            throw new RuntimeException("Array is destructed");
        }
        if (idx >= capacity || idx < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }

        var offset = startPtr + (idx * GENERIC_BYTE_SIZE);

        var byteVal = UNSAFE.getByte(offset);

        if (byteVal == -1) {
            return null;
        }

        @SuppressWarnings("unchecked")
        var obj = (T) UNSAFE.getObject(null, offset);

        return obj;
    }

    public long size() {
        return capacity;
    }

    public void destruct() {
        if (isDestructed) {
            return;
        }

        capacity = 0;
        for (long i = 0; i < capacity; i++) {
            UNSAFE.putByte(startPtr + (i * GENERIC_BYTE_SIZE), (byte) -1);
        }
        UNSAFE.freeMemory(startPtr);
        isDestructed = true;
    }

    @Override
    public void close() {
        destruct();
    }

    private long getGenericSize() {
        return UNSAFE.arrayIndexScale(java.lang.reflect.Array.newInstance(type, 1).getClass());
    }

    private Unsafe getUnsafe() {
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            return (Unsafe) f.get(null);
        } catch (Exception e) {
            throw new RuntimeException("Unable to load unsafe", e);
        }
    }

    private long addressOf(T o) {
        Object[] array = new Object[] { o };

        long baseOffset = UNSAFE.arrayBaseOffset(Object[].class);
        int addressSize = UNSAFE.arrayIndexScale(Object[].class);
        long objectAddress;
        switch (addressSize) {
            case 4:
                objectAddress = UNSAFE.getInt(array, baseOffset);
                break;
            case 8:
                objectAddress = UNSAFE.getLong(array, baseOffset);
                break;
            default:
                throw new RuntimeException("unsupported address size: " + addressSize);
        }

        return objectAddress;
    }

}
