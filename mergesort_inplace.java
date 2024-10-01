import java.util.Arrays;

    public class mergesort_inplace {
    public static void main(String[] args) {
        int[] arr={5,4,3,2,1,0};
        mergesortinplace(arr,0,arr.length);
        System.out.println(Arrays.toString(arr));
    }
    static void mergesortinplace(int[] arr , int s , int e){
        //base case
        if(e-s== 1){
            return;
        }

        int mid = (s+e)/2;
         mergesortinplace(arr,0,mid);
         mergesortinplace(arr,mid,e);

        merge(arr,s,mid,e);
    }
    private static void merge(int[] arr,int s,int m,int e){
        // this function basically merges 2 arrays together
        int[] mix = new int[e-s];

        int i=s;
        int j=m;
        int k=0;

        while(i< m && j< e){
            if(arr[i] < arr[j]){
                mix[k] = arr[i];
                i++;
            }
            else{
                mix[k] = arr[j];
                j++;
            }
            k++;
        }

        //it may be possible that one of the arrays is not complete then ->
        // add all the remaining elements in the mix arr

        while(i< m){
            mix[k] = arr[i];
            i++;
            k++;
        }
        while(j< e){
            mix[k] = arr[j];
            j++;
            k++;
        }
        for (int l = 0; l < mix.length; l++) {
            arr[s+l] = mix[l];
        }
    }


}
