package com.company;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyMap<K, V> implements Map<K, V> {
    private Map<K, V> map = new HashMap<>();
    private static final Lock lock = new ReentrantLock();

    @Override
    public int size() {
        lock.lock();
        int size = map.size();
        lock.unlock();
        return size;
    }

    @Override
    public boolean isEmpty() {
        lock.lock();
        boolean isEmpty = map.isEmpty();
        lock.unlock();
        return isEmpty;
    }

    @Override
    public boolean containsKey(Object key) {
        lock.lock();
        boolean containsKey = map.containsKey(key);
        lock.unlock();
        return containsKey;
    }

    @Override
    public boolean containsValue(Object value) {
        lock.lock();
        boolean containsValue = map.containsValue(value);
        lock.unlock();
        return containsValue;
    }

    @Override
    public V get(Object key) {
        lock.lock();
        V get = map.get(key);
        lock.unlock();
        return get;
    }

    @Override
    public V put(K key, V value) {
        lock.lock();
        V put = map.put(key, value);
        lock.unlock();
        return put;
    }

    @Override
    public V remove(Object key) {
        lock.lock();
        V remove = map.remove(key);
        lock.unlock();
        return remove;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        lock.lock();
        map.putAll(m);
        lock.unlock();

    }

    @Override
    public void clear() {
        lock.lock();
        map.clear();
        lock.unlock();

    }

    @Override
    public Set<K> keySet() {
        lock.lock();
        Set<K> keySet = map.keySet();
        lock.unlock();
        return keySet;
    }

    @Override
    public Collection<V> values() {
        lock.lock();
        Collection<V> values = map.values();
        lock.unlock();
        return values;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        lock.lock();
        Set<Entry<K, V>> entrySet = map.entrySet();
        lock.unlock();
        return entrySet;
    }
}
