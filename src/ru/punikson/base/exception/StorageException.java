package ru.punikson.base.exception;

public class StorageException extends RuntimeException {
    private final String uuid;

    public StorageException(String message, String uuId) {
        super(message);
        this.uuid = uuId;
    }

    public String getUuid() {
        return uuid;
    }
}
