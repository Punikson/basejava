package ru.punikson.base.storage;

import ru.punikson.base.exception.StorageException;
import ru.punikson.base.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10_000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int count = 0;

    @Override
    protected boolean isExist(Object searchKey) {
        return (int) searchKey >= 0;
    }

    @Override
    protected void doSave(Object searchKey, Resume r) {
        if (count != storage.length) {
            insertElement(r, (Integer) searchKey);
            count++;
        } else {
            throw new StorageException("Storage overflow", r.getUuId());
        }
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    protected void doUpdate(Object searchKey, Resume r) {
        storage[(int) ((Integer) searchKey)] = r;
    }

    @Override
    protected void doDelete(Object searchKey) {
        fillDeletedPosition((Integer) searchKey);
        storage[count - 1] = null;
        count--;
    }

    @Override
    public void clear() {
        Arrays.fill(storage, 0, count, null);
        count = 0;
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return storage[(int) searchKey];
    }

    @Override
    public Resume[] getAll() {
        Resume[] result = new Resume[count];
        System.arraycopy(storage, 0, result, 0, count);
        return result;
    }

    protected abstract void insertElement(Resume res, int index);

    protected abstract void fillDeletedPosition(int index);
}




