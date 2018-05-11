package id.ac.ubharajaya.algo.semester2.tugas1;

public class Main {
    public static void main(String[] args) {

        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

        binary_search BS = new binary_search();

        System.out.println(BS.search(array, 9));;
    }
}

class binary_search {

    int search(int[] array, int find){
        int found = 0;
        int high = array.length-1;
        int low = 0;

        while (low < high) {
            int mid = (high+low) / 2;
            if (find == array[mid]) {
                found = array[mid];
                break;
            } else if (find > array[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return found;
    }
}