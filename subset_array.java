import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subset_array {
    public static void main(String[] args) {
        int[] arr={1,2,2};
        List<List<Integer>> ans = subsetDuplicate(arr);
        for(List<Integer> list : ans){
            System.out.println(list);
        }

    }

    static List<List<Integer>> subset (int[] arr) {
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        // adding empty arraylist bc that is universal subset

        for (int num : arr) {
            int n = outer.size();
            for (int i = 0; i < n; i++) {
                List<Integer> internal = new ArrayList<>(outer.get(i));
                /*
                this will create a new arraylist which will be the copy of the outer one , it retreivs i subset from the outer list
                outer.get(i): Retrieves the subset at index i from the outer list.
                new ArrayList<>(outer.get(i)): Creates a new ArrayList called internal which is a copy of the subset retrieved.
                 This is necessary because we want to modify internal without affecting the original subset in outer.
                */

                internal.add(num);
                outer.add(internal);
                //outer.add(internal): Adds the modified subset internal back to the outer list
            }
        }
        return outer;
    }

        //output
        //[]
        //[1]
        //[2]
        //[1, 2]
        //[3]
        //[1, 3]
        //[2, 3]
        //[1, 2, 3]

    static List<List<Integer>> subsetDuplicate (int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        // adding empty arraylist bc that is universal subset
        int start =0;
        int end =0;
        for (int i = 0; i <arr.length ; i++) {
            //if your current element is same as previous one then start = end + 1
            if(i>0 && arr[i]==arr[i-1]){
                start = end + 1;
            }
           end = outer.size()-1;
            int n = outer.size();
            for (int j = start; j < n; j++) {
                List<Integer> internal = new ArrayList<>(outer.get(j));
                internal.add(arr[i]);
                outer.add(internal);
            }
        }
        return outer;
    }


}
