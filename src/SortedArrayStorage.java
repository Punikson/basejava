import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {
    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume(uuid);
        searchKey.setUuID(uuid);
        return Arrays.binarySearch(storage, 0, count, searchKey);
    }

    @Override
    protected void insertElement(Resume res, int index) {
        int insertIndx = -index - 1;
        System.arraycopy(storage, insertIndx, storage, insertIndx + 1, count - insertIndx);
        storage[insertIndx] = res;
    }

    @Override
    protected void fillDeletedPosition(int index) {
        int num = count - index - 1;
        if (num > 0) {
            System.arraycopy(storage, index + 1, storage, index, num);
        }
    }
}
