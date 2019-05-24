package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    Entry<String> root;
    ArrayList<Entry> entries = new ArrayList<>();
    int size = 0;

    public CustomTree() {
        root = new Entry<>("first element");
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(String elementName) {
        Entry entry = new Entry<>(elementName);
        Queue<Entry> queue = new LinkedList<>();
        queue.offer(root);

        Entry thisEntry = null;

        while (!queue.isEmpty()) {
            thisEntry = queue.poll();
            if (thisEntry.isAvailableToAddChildren()) {
                if (thisEntry.availableToAddLeftChildren) {
                    thisEntry.leftChild = entry;
                    thisEntry.availableToAddLeftChildren = false;
                    entry.setParent(thisEntry);
                    size++;
                    entries.add(entry);
                    break;
                } else {
                    thisEntry.rightChild = entry;
                    thisEntry.availableToAddRightChildren = false;
                    entry.setParent(thisEntry);
                    size++;
                    entries.add(entry);
                    break;
                }
            } else if (thisEntry.leftChild.availableToAddRightChildren) {
                queue.offer(thisEntry.leftChild);
            } else if (thisEntry.rightChild.availableToAddRightChildren) {
                queue.offer(thisEntry.rightChild);
            } else {
                queue.offer(thisEntry.leftChild);
                queue.offer(thisEntry.rightChild);
            }
        }

        return true;
    }

    @Override
    public int size() {
        return size;
    }

    public String getParent(String elementName) {
        String parentName = null;

        for (Entry entry : entries) {
            if (entry.elementName.equals(elementName)) {
                parentName = entry.parent.elementName;
                break;
            }
        }

        return parentName;
    }


    static class Entry<T> implements Serializable {
        String elementName;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;

        }

        public boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren || availableToAddRightChildren;
        }

        public void setParent(Entry<T> parent) {
            this.parent = parent;
        }
    }
}
