import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        int[] original = new int[] { 1, 4, 3, 2 };
        int[] desired = new int[] { 1, 2, 4, 3 };
        Arrays.equals(original,desired);
    }

    public static int MinPieces(int[] original, int[] desired)
    {
        for (int i = original.length-1; i >=0; i--)
        {
            for (int j = 0;j<original.length+1-i;j++)
            {
                for (int k = 0;k<original.length+1-i;k++) {
                    int[] orgSlc = getSliceOfArray(original, j, j + i);
                    int[] desSlc = getSliceOfArray(desired, k, k + i);
                   if (Arrays.equals(orgSlc,desSlc))
                   {
                   }
                }
            }
        }
        return 1;
    }

    public static int[] getSliceOfArray(int[] arr, int start, int end)
    {

        int[] slice = new int[end - start];

        for (int i = 0; i < slice.length; i++) {
            slice[i] = arr[start + i];
        }

        return slice;
    }



    static void merge(int[] lArr,int[] rArr, int[] arr,int leftSize, int rightSize){

        int i=0,l=0,r = 0;

        while(l<leftSize && r<rightSize){

            if(lArr[l]<rArr[r]){
                arr[i++] = lArr[l++];
            }
            else{
                arr[i++] = rArr[r++];
            }
        }
        while(l<leftSize){
            arr[i++] = lArr[l++];
        }
        while(r<rightSize){
            arr[i++] = rArr[r++];
        }
    }

    static void mergSort(int [] arr, int len){
        if (len < 2){return;}

        int mid = len / 2;
        int [] leftA = new int[mid];
        int [] rightA = new int[len-mid];

        int k = 0;
        for(int i = 0;i<len;++i){
            if(i<mid){
                leftA[i] = arr[i];
            }
            else{
                rightA[k] = arr[i];
                k = k+1;
            }
        }

        mergSort(leftA,mid);
        mergSort(rightA,len-mid);

        merge(leftA,rightA,arr,mid,len-mid);
    }

    static int[] solution(int[] dataStream) {
        int[] arr = new int[dataStream.length];
        arr[0] = dataStream[0];
        if (dataStream[1]>dataStream[0])
        {
            arr[1]=dataStream[0];
        }else {
            arr[1] = dataStream[1];
        }
        for (int i = 3; i < dataStream.length; i++) {
            int[] sliceArray = sliceArray(dataStream, i);
            mergSort(sliceArray,sliceArray.length);
            arr[i-1]= sliceArray[i/2];
        }
        return arr;
    }

    static int[] sliceArray(int array[], int endIndex ){
        int size = endIndex;
        int part[] = new int[size];

        for(int i=0; i<part.length; i++){
            part[i] = array[i];
        }
        return part;
    }

    static boolean solution(String[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            oloop:
            for (int j = i + 1; j < numbers.length; j++) {
                String num1 = numbers[i];
                String num2 = numbers[j];
                if (num1.length() > num2.length()) {
                    String swap = num1;
                    num1 = num2;
                    num2 = swap;
                }
                boolean prefix = false;
                for (int k = 0; k < num1.length(); k++) {
                    if (num1.charAt(k) == num2.charAt(k)) {
                        prefix = true;
                    } else {
                      continue oloop;
                    }
                }
                if (prefix) {
                    return false;
                }
            }
        }
        return true;
    }
}
