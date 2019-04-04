public class ArrayStorage {
    private int count = 0;
    private Resume[] storage = new Resume[10_000];

    private Resume checkStorage(String uuid){
        for (int i = 0; i < count; i++)
            if (storage[i].getUuId().equals(uuid)){
                return storage[i];
            }
        return null;
    }

    public void save(Resume res) {
        int i =0;
        for (; i < count; i++) {
            if (storage[i].getUuId().equals(res.getUuId())) {
                System.out.println("Error. Resume are already exist");
                break;
            }
        }

        if (i == count) {
            storage[count] = res;
            count++;
        }
    }

    public Resume get(String uuid) {
            return checkStorage(uuid);
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
        for (int i = 0; i < count; i++) {
            if (storage[i].getUuId().equals(uuid)){
                storage[i] = storage[count-1];
                storage[count-1] = null;
                count--;
            }
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
