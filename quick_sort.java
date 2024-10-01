import java.util.Arrays;

public class quick_sort {
    public static void main(String[] args) {
       int[] arr = {5,4,3,2,1};
       sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
    }
    static void sort(int[] arr, int low , int high){
        if(low > high){
            return;
        }

        int s = low;
        int e = high;
        int mid = s + (e-s)/2;
        int pivot = arr[mid];

        while(s <= e){
            // if you have a violation
            while(arr[s] < pivot){
                s++;
            }
            while(arr[e] > pivot){
                e--;
            }

            // we will swap only if we get the true condition
            if(s <= e){
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++;
                e--;
            }
        }

        // now my pivot is at the coreect index , now please sort the 2 halfes
        sort(arr,low,e);
        sort(arr,s,high);
    }
}
