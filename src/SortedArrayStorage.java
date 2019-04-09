import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {


    @Override
    public Resume[] getAll() {
        Resume[] result = new Resume[count];
        System.arraycopy(storage, 0, result, 0, count);
        return result;
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume(uuid);
        searchKey.setUuID(uuid);
        return Arrays.binarySearch(storage, 0, count, searchKey);
    }

    @Override
    protected void insertElement(Resume res, int result) {
        int insertIndx = -result - 1;
        System.arraycopy(storage, insertIndx, storage, insertIndx + 1, count - insertIndx);
        storage[insertIndx] = res;
    }

    @Override
    protected void insertInDeletedPosition(int result) {
        int num = count - result - 1;
        if (num > 0) {
            System.arraycopy(storage, result + 1, storage, result, num);
        }
    }

}
