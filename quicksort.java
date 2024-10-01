import java.util.Arrays;

public class quicksort {
    public static void main(String[] args) {
        int[] arr={5,4,3,2,1,0};
        //sort(arr,0, arr.length-1);
       // System.out.println(Arrays.toString(arr));

        Arrays.sort(arr);
    }
    static void sort(int[] arr , int low,int high){
        if(low >= high){
            return;
        }

        int s = low;
        int e = high;
        int mid =  s +(e-s)/2;
        int pivot = arr[mid];

        while(s <= e){

            // even if the start and end have the same element , IT WILL NOT SWAP unlike merge sort
            while(arr[s]<pivot){
                s++;
            }
            while(arr[e]>pivot){
                e--;
            }

            if(s <= e){
                int temp = arr[s];
                arr[s]=arr[e];
                arr[e] = temp;
                s++;
                e--;
            }
        }

        // now pivot is at the correct index ,sort the two halves please
        sort(arr,low,e);
        sort(arr,s,high);
    }
}
