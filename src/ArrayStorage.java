import java.util.Arrays;

public class ArrayStorage extends AbstractArrayStorage{
    public void save(Resume res) {
        int result = getIndex(res.getUuId());
        if (result != -1) {
            System.out.println("Error. Resume is already exist");
        } else if (count != storage.length) {
            storage[count] = res;
            count++;
        } else {
            System.out.println("Error.ArrayIndexOutOfBounds");
        }
    }

    public Resume get(String uuid) {
        int result = getIndex(uuid);
        if (result != -1) {
            return storage[result];
        }
        System.out.println("Error. Resume with this uuid is not in the storage");

        return null;
    }

    public void update(Resume res) {
        int result = getIndex(res.getUuId());
        if (result != -1) {
            storage[result] = res;
        } else {
            System.out.println("\nImpossible to update.Resume is not found");
        }

    }

    public void delete(String uuid) {
        int result = getIndex(uuid);
        if (result != -1) {
            storage[result] = storage[count - 1];
            storage[count - 1] = null;
            count--;
        } else {
            System.out.println("\nError. Resume with this uuid is not in the storage");
        }
    }

    public int size() {
        return count;
    }

    public void clear() {
        Arrays.fill(storage,0,count,null);
        count = 0;
    }

    public Resume[] getAll() {
        Resume[] result = new Resume[count];
        System.arraycopy(storage, 0, result, 0, count);
        return result;
    }

    private int getIndex(String uuid) {
        for (int i = 0; i < count; i++)
            if (storage[i].getUuId().equals(uuid)) {
                return i;
            }
        return -1;
    }
}
