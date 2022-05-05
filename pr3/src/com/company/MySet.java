package com.company;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Semaphore;

public class MySet<E> implements Set<E> {
    private Set<E> set = new HashSet<E>();
    private Semaphore semaphore = new Semaphore(1, true);
    @Override
    public int size() {
        int size = -1;
        try {
            semaphore.acquire();
            size = set.size();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        boolean isEmpty = false;
        try {
            semaphore.acquire();
            isEmpty = set.isEmpty();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
        return isEmpty;
    }

    @Override
    public boolean contains(Object o) {
        boolean contains = false;
        try {
            semaphore.acquire();
            contains = set.contains(o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
        return contains;
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> iterator = null;
        try {
            semaphore.acquire();
            iterator = set.iterator();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
        return iterator;
    }

    @Override
    public Object[] toArray() {
        Object[] toArray = null;
        try {
            semaphore.acquire();
            toArray = set.toArray();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
        return toArray;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        T[] toArray = null;
        try {
            semaphore.acquire();
            toArray = set.toArray(a);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
        return toArray;
    }

    @Override
    public boolean add(E e) {
        boolean add = false;
        try {
            semaphore.acquire();
            add = set.add(e);
        } catch (InterruptedException x) {
            x.printStackTrace();
        }finally {
            semaphore.release();
        }
        return add;
    }

    @Override
    public boolean remove(Object o) {
        boolean remove = false;
        try {
            semaphore.acquire();
            remove = set.remove(o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
        return remove;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        boolean containsAll = false;
        try {
            semaphore.acquire();
            containsAll = set.containsAll(c);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
        return containsAll;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean addAll = false;
        try {
            semaphore.acquire();
            addAll = set.addAll(c);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
        return addAll;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean retainAll = false;
        try {
            semaphore.acquire();
            retainAll = set.retainAll(c);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
        return retainAll;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean removeAll = false;
        try {
            semaphore.acquire();
            removeAll = set.removeAll(c);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
        return removeAll;
    }

    @Override
    public void clear() {
        try {
            semaphore.acquire();
            set.clear();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }

    }
}
