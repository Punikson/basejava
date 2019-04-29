package ru.punikson.base.storage;
import ru.punikson.base.exception.ExistStorageException;
import ru.punikson.base.exception.NotExistStorageException;
import ru.punikson.base.exception.StorageException;
import ru.punikson.base.model.Resume;
import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10_000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int count = 0;

    public void save(Resume res) {
        int index = getIndex(res.getUuId());
        if (index >= 0) {
            throw new ExistStorageException(res.getUuId());
        } else if (count != storage.length) {
            insertElement(res, index);
            count++;
        } else {
            throw new StorageException("Storage overflow",res.getUuId());
        }
    }

    public int size() {
        return count;
    }

    public void update(Resume res) {
        int index = getIndex(res.getUuId());
        if (index >= 0) {
            storage[index] = res;
        } else {
            throw new NotExistStorageException(res.getUuId());
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            fillDeletedPosition(index);
            storage[count - 1] = null;
            count--;
        } else {
            System.out.println("\nError. Resume with this uuid is not in the storage");
        }
    }

    public void clear() {
        Arrays.fill(storage, 0, count, null);
        count = 0;
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            return storage[index];
        } else {
            throw new NotExistStorageException(uuid);
        }
    }

    public Resume[] getAll() {
        Resume[] result = new Resume[count];
        System.arraycopy(storage, 0, result, 0, count);
        return result;
    }

    protected abstract int getIndex(String uuid);

    protected abstract void insertElement(Resume res, int index);

    protected abstract void fillDeletedPosition(int index);
}




