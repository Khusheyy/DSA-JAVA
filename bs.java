public class bs {
        public static int[] Buble(int arr[]){ //{3,1,5,4,2}
            int n= arr.length;
            for(int i=0; i<n; i++){
                for(int j=1; j<n; j++){
                    if(arr[i]>arr[j]){
                        int temp=arr[i];
                        arr[i]=arr[j];
                        arr[j]=temp;
                    }
                }
            }
            return arr;
        }
        public static void main(String[] args) {
            int arr[]={3,1,5,4,2}  ;
            int k[]= Buble(arr);
            for(int i=0; i<k.length; i++){
                System.out.print(k[i] + " ");
            }
        }

}
