public class ArrayStorage {
    public int count = 0;
    public Resume[] storage = new Resume[10000];

    public void save(Resume res) {
        /*if (storage[0] == null)
            storage[0] = res;
        else {
            count++;
            storage[count] = res;
        }*/
        int size = size();
        if (size == 0) {
            storage[0] = res;
        }
        storage[count] = res;
        count++;

    }

    Resume get(String uuid) {
        int size = size();
        for (int i = 0; i < size; i++)
            if (storage[i].getUuId().equals(uuid)) {
                return storage[i];
            }
        return null;
    }

    void delete(String uuid) {
        int i = 0;
        int size = size();
        for (; i < size; i++) {
            if (storage[i].getUuId().equals(uuid))
                break;
        }
        for (int j = i; j < size; j++) {
            storage[j] = storage[j + 1];
            //storage[j + 1] = null;
        }

    }

    int size() {
        int c = 0;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null)
                c++;
        }
        return c;
    }

    void clear() {
        int size = size();
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        count = 0;
    }

    Resume[] getAll() {
        Resume[] result = new Resume[size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = storage[i];
        }
        return result;
    }
}
