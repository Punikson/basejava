package ru.punikson.base.storage;

import ru.punikson.base.model.Resume;

public class ArrayStorage extends AbstractArrayStorage {
    @Override
    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < count; i++)
            if (storage[i].getUuId().equals(uuid)) {
                return i;
            }
        return -1;
    }

    @Override
    protected void insertElement(Resume res, int index) {
        storage[count] = res;
    }

    @Override
    protected void fillDeletedPosition(int index) {
        storage[index] = storage[count - 1];
    }
}
