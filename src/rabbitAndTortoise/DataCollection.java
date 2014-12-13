package rabbitAndTortoise;

/**
 * Created by alshevchuk on 12.12.2014.
 */
public class DataCollection<T> {
    private Entry<T> thisEntry = null;

    public Entry<T> add(T o) {
        Entry<T> newEntry = new Entry<>(o);

        if (thisEntry != null) {
            thisEntry.setNextEntry(newEntry);
            newEntry.setPrevEntry(thisEntry);
            thisEntry = newEntry;
        } else {
            thisEntry = newEntry;
        }

        return newEntry;
    }

    public Entry<T> addBrokenEntry(Entry<T> entryToBroke, Entry<T> forcePrevEntry, Entry<T> forceNextEntry) {
        entryToBroke.setNextEntry(forceNextEntry);
        entryToBroke.setPrevEntry(forcePrevEntry);

        return entryToBroke;
    }

    class Entry<V> {
        private V entry = null;
        private Entry<V> nextEntry = null;
        private Entry<V> prevEntry = null;

        public Entry(V entry) {
            this.entry = entry;
        }

        public void setNextEntry(Entry<V> nextEntry) {
            this.nextEntry = nextEntry;
        }

        public void setPrevEntry(Entry<V> prevEntry) {
            this.prevEntry = prevEntry;
        }

        public Entry<V> getNextEntry() {
            return nextEntry;
        }

        public Entry<V> getPrevEntry() {
            return prevEntry;
        }

        public V getEntry() {
            return entry;
        }

        @Override
        public String toString() {
            return entry.toString();
        }
    }
}