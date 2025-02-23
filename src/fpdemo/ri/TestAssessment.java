package fpdemo.ri;

public class TestAssessment {

    
    public static void main(String[] args) throws Exception {
       int[] arr = {2, 3, 4, 10, 40} ;
        int search = binarySearch(arr ,10);
        System.out.println("search : "+search);
   

    }
   public static int binarySearch(int[] arr, int key) {

        int low = 0;
    
        int high = arr.length - 1;
    
        while (low <= high) {
    
            int mid = low + (high - low) / 2;
    
            if (arr[mid] < key) {
    
                low = mid + 1;
    
            } else if (arr[mid] > key) {
    
                high = mid - 1;
    
            } else {
    
                return mid;
    
            }
    
        }
    
        return -1; // key not found
    
    }
}

interface Greeter {

    String greet(String name);

}