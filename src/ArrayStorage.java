public class ArrayStorage {
    public static int count = 0;
    public Resume[] storage = new Resume[10000];

    public void save(Resume res) {
        if (storage[0] == null)
            storage[0] = res;
        else {
            ArrayStorage.count++;
            storage[count] = res;
        }
    }

    Resume get(int i) {

        return storage[i];
    }

    void delete(String uuid) {
        int i = 0;
        for (; i < storage.length; i++) {
            if (storage[i].getUuId().equals(uuid))
                break;
        }

        for (int j = i; j < storage.length - 1; j++) {
            storage[j] = storage[j + 1];
            storage[j + 1] = null;
        }

    }

    void clear() {
        for (int i = 0; i < storage.length; i++) {
            storage[i] = null;
        }
    }

    void getAll() {
        for (Resume elems : storage) {
            System.out.println(elems);
        }
    }


}
