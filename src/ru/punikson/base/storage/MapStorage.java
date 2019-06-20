package ru.punikson.base.storage;

import ru.punikson.base.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {
    private final Map<String,Resume> map = new HashMap<>();

    @Override
    protected boolean isExist(Object searchKey) {
        return map.containsKey(searchKey);
    }

    @Override
    protected void doSave(Object searchKey, Resume r) {
    map.put((String) searchKey,r);
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    protected void doUpdate(Object searchKey, Resume r) {
    map.put((String) searchKey,r);
    }

    @Override
    protected void doDelete(Object searchKey) {
    map.remove(searchKey);
    }

    @Override
    public void clear() {
    map.clear();
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return map.get(searchKey);
    }

    @Override
    public Resume[] getAll() {
        return new Resume[0];
    }

    @Override
    protected String getSearchKey(String uuid) {
        return uuid;
    }
}
