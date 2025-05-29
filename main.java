public class main{
    public static void main(String[] arg){
        int arr[] = {1,3,6,7,9,2};
        bubbleSort(arr);
        for(int i : arr){
            System.out.print(i + " ");
        }
    }
    private static void bubbleSort(int[] arr){
        for(int i = 0; i < arr.length - 1; i++){
            // Nested loop to compare the elements
            for(int j = 0; j < arr.length - i - 1; j++){
                // If the current element is greater than the next element
                if (arr[j] > arr[j + 1]){ 
                    // Swap the elements 
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }    
            }
        }  
    }
    
    private static void selectionSort(int[] arr){
        for(int i = 0; i < arr.length - 1; i++){
            int min = i;
            for(int j = i + 1; j < arr.length; j++){ //Nested loop to find the smallest element
                if(arr[min] > arr[j]){ //If the smallest element is greater than the current element
                    min = j; 
                }
            }
            // Swap the smallest element with the first element
            // This is done to move the smallest element to the front of the array 

            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;

        }
    }
}
