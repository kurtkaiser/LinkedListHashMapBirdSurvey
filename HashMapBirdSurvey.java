/*
Kurt Kaiser
CTIM 168
08.02.2018
Homework: Bird Survey Linked List
Chapter 12 Practice Problem 13
*/

import java.util.HashMap;

public class HashMapBirdSurvey
{
    private ListNode head;

    public HashMapBirdSurvey() {
        head = null;
    }

    /**
     * Displays the data on the list.
     */
    public void showList() {
        ListNode position = head;
        while (position != null) {
            System.out.println(position.data);
            position = position.link;
        }

    }

    /**
     * Returns the number of nodes on the list.
     */
    public int length() {
        int count = 0;
        ListNode position = head;
        while (position != null) {
            count++;
            position = position.link;
        }
        return count;
    }

    /**
     * Adds a node containing the data addData at the
     * start of the list.
     */
    public void addANodeToStart(String addData) {
        head = new ListNode(addData, head);
    }

    /**
     * Deletes the first node on the list.
     */
    public void deleteHeadNode() {
        if (head != null)
            head = head.link;
        else {
            System.out.println("Deleting from an empty list.");
            System.exit(0);
        }
    }

    public void getReport() {
        ListNode position = head;
        position.createReport();
    }

    public void getCount(String bird) {
        ListNode position = head;
        position.searchBirdCount(bird);
    }


    /**
     * Sees whether target is on the list.
     */
    public boolean onList(String target) {
        return (find(target) != null);
    }

    //Returns a reference to the first node containing the
    //target data. If target is not on the list, returns null.
    private ListNode find(String target) {
        boolean found = false;
        ListNode position = head;
        while ((position != null) && !found) {
            String dataAtPosition = position.data;
            if (dataAtPosition.equals(target)){
                found = true;
            } else {
                position = position.link;
            }
        }
        return position;
    }

    private class ListNode {
        private String data;
        private ListNode link;
        private String[] array;
        private HashMap<String, Integer> countBirds;

        public ListNode() {
            link = null;
            data = null;
        }

        public ListNode(String newData, ListNode linkValue) {
            data = newData;
            link = linkValue;
        }


        public void toArray() {
            String[] anArray = new String[length()];
            ListNode position = head;
            int i = 0;
            while (position != null) {
                anArray[i] = position.data;
                i++;
                position = position.link;
            }
            array = anArray;
        }

        public void toHashMap() {
            countBirds = new HashMap<>();
            for (int j = 0; j < array.length; j++) {
                Integer count = countBirds.get(array[j]);
                if (count == null) {
                    count = 1;
                } else {
                    count++;
                }
                countBirds.put(array[j], count);
            }

        }

        public void searchBirdCount(String bird){
            toArray();
            toHashMap();
            Integer c = countBirds.get(bird);
            if (c == null) c = 0;
            System.out.println("Count: " + c);
        }

        public void createReport(){
            toArray();
            toHashMap();
            countBirds.forEach((key, value) -> System.out.println(key + ":" + value));
        }
    }

}

