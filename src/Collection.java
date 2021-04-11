import java.util.Objects;

public class Collection implements CustomCollection {
    private Element first;
    private int size;

    public Collection() {
        first = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    @Override
    public boolean add(String str) {
        Element newElement = new Element(str);
        newElement.next = first;
        first = newElement;
        size++;
        return true;
    }

    @Override
    public boolean addAll(String[] strArr) {
        if (strArr == null) {
            return false;
        }
        for (String s : strArr) {
            if (s != null) {
                Element newElement = new Element(s);
                newElement.next = first;
                first = newElement;
                size++;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection strColl) {
        if (strColl == null) {
            return false;
        }
        Element currentStrColl = strColl.first;
        while (currentStrColl != null) {
            Element newElement = new Element(currentStrColl.string);
            newElement.next = first;
            first = newElement;
            size++;
            currentStrColl = currentStrColl.next;
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Collection that = (Collection) o;
        return size == that.size && first.equals(that.first);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, size);
    }

    @Override
    public boolean delete(int index) {
        if (index < size || !isEmpty()) {
            int indexTemp = size - 1;
            Element current = first;
            Element previous = first;
            while (indexTemp-- != index) {
                if (current.next == null) {
                    return false;
                } else {
                    previous = current;
                    current = current.next;
                }
            }
            if (current == first) {
                first = first.next;
            } else {
                previous.next = current.next;
                size--;
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String str) {
        if (!isEmpty()) {
            Element current = first;
            Element previous = first;
            while (!Objects.equals(current.string, str)) {
                if (current.next == null) {
                    return false;
                } else {
                    previous = current;
                    current = current.next;
                }
            }
            if (current == first) {
                first = first.next;
            } else {
                previous.next = current.next;
                size--;
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(String str) {
        if (!isEmpty()) {
            Element current = first;
            while (!Objects.equals(current.string, str)) {
                if (current.next == null) {
                    return false;
                } else {
                    current = current.next;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean compare(Collection coll) {
        if (!isEmpty() || coll.first == null) {
            Element current = first;
            Element currentStrColl = coll.first;
            while (current != null) {
                if (Objects.equals(current.string, currentStrColl.string)) {
                    currentStrColl = currentStrColl.next;
                    current = current.next;
                } else return false;
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean clear() {
        if (!isEmpty()) {
            first = null;
        } else return false;
        size = 0;
        return true;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean trim() {
        return false;
    }

    @Override
    public String get(int index) {
        if (index < size || !isEmpty()) {
            int indexTemp = size - 1;
            Element current = first;
            while (indexTemp-- != index) {
                if (current.next == null) {
                    return null;
                } else {
                    current = current.next;
                }
            }
            return current.string;
        }
        return null;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "Collection is empty." + "\n";
        }
        int index = size - 1;
        Element current = first;
        StringBuilder sb = new StringBuilder("\nList (first-->last): ");
        while (current != null) {
            sb.append("\nIndex: ").append(index--).append(" Element: ").append(current.string);
            current = current.next;
        }
        sb.append("\nElements in collection (size): ").append(size).append("\n");
        return String.valueOf(sb);
    }


    private static class Element {
        private final String string;
        private Element next;

        public Element(String string) {
            this.string = string;
        }
    }
}

