package ru.punikson.base.storage;

import org.junit.Assert;
import org.junit.Test;
import ru.punikson.base.exception.StorageException;
import ru.punikson.base.model.Resume;

public abstract class AbstractArrayStorageTest extends AbstractStorageTest {

    private Storage storage;

    protected AbstractArrayStorageTest(Storage storage) {
        super(storage);
        this.storage = storage;
    }

    @Test(expected = StorageException.class)
    public void saveOverflow() {
        try {
            for (int i = storage.size(); i < AbstractArrayStorage.STORAGE_LIMIT; i++) {
                storage.save(new Resume());
            }
        } catch (StorageException e) {
            Assert.fail("The overflow happened before the end of array");
        }
        storage.save(new Resume());
    }
}