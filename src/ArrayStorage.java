public class ArrayStorage extends AbstractArrayStorage {
    @Override
    protected int getIndex(String uuid) {
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
    protected void fillDeletedPosition(int result) {
        storage[result] = storage[count - 1];
    }
}
