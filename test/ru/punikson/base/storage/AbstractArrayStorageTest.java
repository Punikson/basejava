package ru.punikson.base.storage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.punikson.base.exception.ExistStorageException;
import ru.punikson.base.exception.NotExistStorageException;
import ru.punikson.base.exception.StorageException;
import ru.punikson.base.model.Resume;

import static org.junit.Assert.*;

public abstract class AbstractArrayStorageTest {
    private static final String UUID_1 = "uuid1";
    private static final Resume RES_1 = new Resume(UUID_1);
    private static final String UUID_2 = "uuid2";
    private static final Resume RES_2 = new Resume(UUID_2);
    private static final String UUID_3 = "uuid3";
    private static final Resume RES_3 = new Resume(UUID_3);
    private static final String UUID_4 = "uuid4";
    private static final Resume RES_4 = new Resume(UUID_4);
    private Storage storage;

    protected AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(RES_1);
        storage.save(RES_2);
        storage.save(RES_3);
    }

    @Test
    public void save() {
        storage.save(RES_4);
        assertEquals(4, storage.size());
        assertEquals(RES_4, storage.get(UUID_4));
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

    @Test(expected = ExistStorageException.class)
    public void saveExist() {
        String UUID_5 = "uuid3";
        Resume RES_5 = new Resume(UUID_5);
        storage.save(RES_5);
    }

    @Test
    public void size() {
        assertEquals(3, storage.size());
    }

    @Test
    public void update() {
        Resume RES_5 = new Resume(UUID_3);
        storage.update(RES_5);
        assertSame(storage.get(RES_3.getUuId()), RES_5);
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() {
        storage.update(RES_4);
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() {
        storage.delete(UUID_3);
        assertEquals(2, storage.size());
        storage.get(UUID_3);
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() {
        storage.delete(UUID_4);
    }

    @Test
    public void clear() {
        storage.clear();
        assertEquals(0, storage.size());
    }

    @Test
    public void get() {
        assertEquals(RES_1, storage.get(UUID_1));
        assertEquals(RES_2, storage.get(UUID_2));
        assertEquals(RES_3, storage.get(UUID_3));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get(UUID_4);
    }

    @Test
    public void getAll() {
        Resume[] stor = storage.getAll();
        assertEquals(3, storage.size());
        assertArrayEquals(storage.getAll(), stor);
    }
}