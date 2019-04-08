import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void save(Resume res) {

    }

    @Override
    public void update(Resume res) {

    }

    @Override
    public void delete(String uuid) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Resume[] getAll() {
        return new Resume[0];
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuID(uuid);
        return Arrays.binarySearch(storage,0,count,searchKey);
    }
}
