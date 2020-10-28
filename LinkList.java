import java.util.*;

public class LinkList {

    private Link first = null;

    public void add(int data) {
        // make a new link with the data
        Link n = new Link();
        n.data = data;
        n.next = null;

        // find the last link which means next = null
        if (first == null) {
            // list is empty
            first = n;
        } else {
            Link current = first;
            while (current.next != null) {
                current = current.next;
            }
            current.next = n;
        }
        // then add there
    }

    public void push(int n) {
        add(0, n);
    }

    public int pop() {
        if (size() > 0) {
            return remove(0);
        }
        return 0;
    }

    public String stackPrint() {
        String ret = "";
        for (int count = 0; count < size(); count++) {
            ret = ret + get(count) + "\n";
        }
        return ret;
    }

    public void clear() {
        first = null;
    }

    public int get(int index) {
        try {
            Link current = first;
            for (int count = 0; count < index; count++) {
                current = current.next;
            }
            return current.data;

        } catch (Exception e) {
            IndexOutOfBoundsException bad = new IndexOutOfBoundsException(index);
            throw (bad);
        }
    }

    public int indexOf(int lookup) {
        int ret = -1;
        int count = 0;
        Link i = first;
        while (i != null) {
            if (i.data == lookup) {
                ret = count;
                break;
            }
            i = i.next;
            count++;
        }
        return ret;
    }

    public int size() {
        int ret = 0;
        Link i = first;
        while (i != null) {
            ret++;
            i = i.next;
        }
        return ret;
    }

    public int set(int element, int index) {
        try {
            Link current = first;
            for (int count = 0; count < index; count++) {
                current = current.next;
            }
            int ret = current.data;
            current.data = element;
            return ret;
        } catch (Exception e) {
            IndexOutOfBoundsException bad = new IndexOutOfBoundsException(index);
            throw (bad);
        }
    }

    public String toString() {
        // get data from first and print it
        // if next is null set first = next
        String ret = "";
        Link i = first;
        while (i != null) {
            ret += i.data + "\n";
            i = i.next;
        }
        return ret;
    }

    private class Link {
        public int data;
        public Link next = null;

        public String toString() {
            return data + "";
        }
    }

    /*
     * private class MyIterator implements Iterator { Link current = null; Link prev
     * = null; public MyIterator(Link first) { prev = first; current = first; }
     * public boolean hasNext() { boolean ret = false; //if current == null then if
     * first != null retrun true if (prev == null && current != null) { ret = true;
     * } else if (current.next != null) { ret = true; } return ret; } public Link
     * next() { Link ret = null; //if first return first make prev first and current
     * first.next
     * 
     * //if current == null then return first and make current = first.next if (prev
     * == null) { prev = current; ret = current; } //else make current =
     * current.next and then return current else { Link temp = current; prev =
     * current; current = temp.next; ret = current; } return ret;
     * 
     * } public void remove() { //System.out.println("Removed this " + current);
     * //System.out.println("Hook this " + prev + " to " + current.next); if (prev
     * != null) { prev.next = current.next; current = prev; prev = null; } if (prev
     * == null && current == first) { first = first.next; } } }
     */

    public void add(int index, int element) {
        try {
            Link current = first;
            Link n = new Link();
            n.data = element;
            if (index == 0) {
                n.next = first;
                first = n;
            } else {
                for (int count = 0; count < index - 1; count++) {
                    current = current.next;
                }
                n.next = current.next;
                current.next = n;
            }
        } catch (Exception e) {
            IndexOutOfBoundsException bad = new IndexOutOfBoundsException(index);
            throw (bad);
        }
    }

    public int remove(int index) {
        int ret = first.data;
        try {
            Link current = first;
            if (index == 0) {
                first = first.next;
            } else {
                for (int count = 0; count < index - 1; count++) {
                    current = current.next;
                }

                ret = current.next.data;
                current.next = current.next.next;
            }

        } catch (Exception e) {
            IndexOutOfBoundsException bad = new IndexOutOfBoundsException(index);
            throw (bad);
        }
        return ret;
    }

    public boolean removeElement(int element) {
        boolean ret = false;
        int index = indexOf(element);
        if (index != -1) {
            remove(index);
            ret = true;
        }
        return ret;
    }

    public static void main(String[] args) {

        LinkList test = new LinkList();
        test.push(10);
        test.push(20);
        test.push(30);

        System.out.println(test.stackPrint());

        System.out.println(test.pop());
        System.out.println("");

        System.out.println(test.stackPrint());

        /*
         * test.add(10); test.add(20); test.add(30); test.add(40); test.add(50);
         */

        /*
         * System.out.println(test); System.out.println(test.get(2));
         * System.out.println(test.indexOf(20)); System.out.println(test.size());
         * System.out.println(test); System.out.println("Set Test" + test.set(100, 0));
         */

        /*
         * System.out.println(test); test.add(1, 15); System.out.println(test);
         * test.remove(10); System.out.println(test);
         */

        /*
         * MyIterator i = test.getIterator(); System.out.println(test);
         * System.out.println(i.next()); System.out.println(i.next()); i.remove();
         * System.out.println(test);
         * 
         * i = test.getIterator(); i.next(); i.remove(); System.out.println(test);
         */
    }
}