package ru.punikson.base.storage;

import ru.punikson.base.exception.ExistStorageException;
import ru.punikson.base.exception.NotExistStorageException;
import ru.punikson.base.model.Resume;

public abstract class AbstractStorage implements Storage {

    public void save(Resume resume) {
        Object searchKey = getSearchKey(resume.getUuId());
        if (isExist(searchKey)) {
            throw new ExistStorageException(resume.getUuId());
        } else doSave(searchKey, resume);
    }

    public void update(Resume resume) {
        Object searchKey = getSearchKey(resume.getUuId());
        if (isExist(searchKey)) {
            doUpdate(searchKey, resume);
        } else {
            throw new NotExistStorageException(resume.getUuId());
        }
    }

    public void delete(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (isExist(searchKey)) {
            doDelete(searchKey);
        } else {
            throw new NotExistStorageException(uuid);
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

    protected abstract void doSave(Object searchKey, Resume resume);

    public abstract int size();

    protected abstract Resume doGet(Object searchKey);

    public abstract Resume[] getAll();

    protected abstract Object getSearchKey(String uuid);

    protected abstract void doUpdate(Object searchKey, Resume resume);

    protected abstract void doDelete(Object searchKey);

    public abstract void clear();
}
