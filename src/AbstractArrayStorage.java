import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10_000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int count = 0;

    public void save(Resume res) {
        int index = getIndex(res.getUuId());
        if (index >= 0) {
            System.out.println("Error. Resume is already exist");
        } else if (count != storage.length) {
            insertElement(res, index);
            count++;
        } else {
            System.out.println("Error.ArrayIndexOutOfBounds");
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
            System.out.println("\nImpossible to update.Resume is not found");
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
            System.out.println("Error. Resume with this uuid is not in the storage");
            return null;
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




