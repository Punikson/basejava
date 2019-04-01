public class ArrayStorage {
    public int count = 0;
    public Resume[] storage = new Resume[10000];

    public void save(Resume res) {
        storage[count] = res;
        count++;
    }

    Resume get(String uuid) {
        for (int i = 0; i < count; i++)
            if (storage[i].getUuId().equals(uuid)) {
                return storage[i];
            }
        return null;
    }

    void delete(String uuid) {
        int i = 0;
        for (; i < count; i++) {
            if (storage[i].getUuId().equals(uuid))
                break;
        }
        for (int j = i; j < count; j++) {
            storage[j] = storage[j + 1];
        }
        count--;

    }

    int size() {
        return count;
    }

    void clear() {
        for (int i = 0; i < count; i++) {
            storage[i] = null;
        }
        count = 0;
    }

    Resume[] getAll() {
        Resume[] result = new Resume[count];
        for (int i = 0; i < result.length; i++) {
            result[i] = storage[i];
        }
        return result;
    }
}
