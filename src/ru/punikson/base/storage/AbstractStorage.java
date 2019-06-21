package ru.punikson.base.storage;

import ru.punikson.base.exception.ExistStorageException;
import ru.punikson.base.exception.NotExistStorageException;
import ru.punikson.base.model.Resume;

public abstract class AbstractStorage implements Storage {

    public void save(Resume res) {
        Object searchKey = getSearchKey(res.getUuId());
        if (isExist(searchKey)) {
            throw new ExistStorageException(res.getUuId());
        } else doSave(searchKey, res);
    }

    public void update(Resume res) {
        Object searchKey = getSearchKey(res.getUuId());
        if (isExist(searchKey)) {
            doUpdate(searchKey, res);
        } else {
            throw new NotExistStorageException(res.getUuId());
        }
    }

    public void delete(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (isExist(searchKey)) {
            doDelete(searchKey);
        } else {
            throw new NotExistStorageException(uuid);
            //System.out.println("\nError. Resume with this uuid is not in the storage");
        }
    }
    
    public Resume get(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (isExist(searchKey)) {
            return doGet(searchKey);
        } else {
            throw new NotExistStorageException(uuid);
        }
    }

    protected abstract boolean isExist(Object searchKey);

    protected abstract void doSave(Object searchKey, Resume r);

    public abstract int size();

    protected abstract Resume doGet(Object searchKey);

    public abstract Resume[] getAll();

    protected abstract Object getSearchKey(String uuid);

    protected abstract void doUpdate(Object searchKey, Resume r);

    protected abstract void doDelete(Object searchKey);

    public abstract void clear();
}
