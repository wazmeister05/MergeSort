import java.util.Arrays;
import java.util.Comparator;

public class SortApp {

    public static void main(String[] args) {
        int[] ints = {9,5,4,2,10,17,1};

        for(int i = 0; i < ints.length; i++){
            System.out.print(ints[i] + " ");
        }
        System.out.println();

        Comparator<Integer> comp = new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                if(a.equals(b)){
                    return -1;
                }
                else{
                    return 1;
                }
            }
        };

        mergeSort(ints, comp);
        for(int i = 0; i < ints.length; i++){
            System.out.print(ints[i] + " ");
        }
        System.out.println();
    }

    public static <K> void merge(int[] s1, int[] s2, int[] s, Comparator<Integer> comparator){
        int i = 0, j = 0;
        while(i + j < s.length){
            if(j == s2.length || (i < s1.length && comparator.compare(s1[i], s2[i]) < 0)){
                s[i+j] = s1[i++];
            }
            else{
                s[i+j] = s2[j++];
            }
        }
    }

    public static void mergeSort(int[] s, Comparator<Integer> comparator){
        int n = s.length;
        if(n < 2){
            return;
        }

        int mid = n/2;
        int[] s1 = Arrays.copyOfRange(s, 0, mid);
        int[] s2 = Arrays.copyOfRange(s, mid, n);

        //figuring out if array needs to be sorted. If so, we're splitting it in half and sorting each half independently
        mergeSort(s1, comparator);
        mergeSort(s2, comparator);

        merge(s1, s2, s, comparator);
    }

}
