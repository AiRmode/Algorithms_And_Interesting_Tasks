package rabbitAndTortoise;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alshevchuk on 12.12.2014.
 */
public class DataCollection<T> {
    private List<T> storage = new ArrayList<>();
    private Entry<T> thisEntry = null;

    public T getNext(Entry<T> o) {
        return null;
    }

    public Entry<T> add(T o) {
        storage.add(o);
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

    class Entry<T> {
        private T entry = null;
        private Entry<T> nextEntry = null;
        private Entry<T> prevEntry = null;

        public Entry(T entry) {
            this.entry = entry;
        }

        public void setNextEntry(Entry<T> nextEntry) {
            this.nextEntry = nextEntry;
        }

        public void setPrevEntry(Entry<T> prevEntry) {
            this.prevEntry = prevEntry;
        }

        public Entry<T> getNextEntry() {
            return nextEntry;
        }

        public Entry<T> getPrevEntry() {
            return prevEntry;
        }

        public T getEntry() {
            return entry;
        }

        @Override
        public String toString(){
            return entry.toString();
        }
    }
}
