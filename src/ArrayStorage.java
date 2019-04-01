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

    Resume get(String uuid) {
        int size = size();
        Resume result = null;
        for (int i = 0; i < size; i++)
            if (storage[i].getUuId().equals(uuid))
                result = storage[i];
            return result;


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

    int size(){
        int c = 0;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i]!=null)
                c++;
        }
        return c;
    }

    void clear() {
        for (int i = 0; i < storage.length; i++) {
            storage[i] = null;
        }
        count = 0;
    }

    Resume[] getAll() {
        Resume[] result = new Resume[size()];
        for (int i = 0; i < result.length; i++) {
            result[i]=storage[i];
        }
        return result;
    }


}
