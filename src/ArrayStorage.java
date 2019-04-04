public class ArrayStorage {
    private int count = 0;
    private Resume[] storage = new Resume[10_000];

    private int checkStorage(String uuid) {
        for (int i = 0; i < count; i++)
            if (storage[i].getUuId().equals(uuid)) {
                return i;
            }
        return -1;
    }

    private int checkStorage(Resume r) {
        for (int i = 0; i < count; i++) {
            if (storage[i].getUuId().equals(r.getUuId())) {
                return i;
            }
        }
        return -1;
    }

    public void save(Resume res) {
        int result = checkStorage(res);

        if (result != -1) {
            System.out.println("Error. Resume are already exist");
        }
        else {
            storage[count] = res;
            count++;
        }
    }

    public Resume get(String uuid) {
        int result = checkStorage(uuid);
        if (result != -1) {
            return storage[result];
        }
        return null;
    }

    public void update(Resume res) {
        int i = 0;
        for (; i < count; i++)
            if (storage[i].getUuId().equals(res.getUuId())) {
                storage[i] = res;
                break;
            }
        if (i == count) {
            System.out.println("\nImpossible to update.Resume are not found");
        }

    }

    public void delete(String uuid) {
        int result = checkStorage(uuid);
        if (result != -1) {
            storage[result] = storage[count - 1];
            storage[count - 1] = null;
            count--;
        }
    }

    public int size() {
        return count;
    }

    public void clear() {
        for (int i = 0; i < count; i++) {
            storage[i] = null;
        }
        count = 0;
    }

    public Resume[] getAll() {
        Resume[] result = new Resume[count];
        for (int i = 0; i < result.length; i++) {
            result[i] = storage[i];
        }
        return result;
    }
}
