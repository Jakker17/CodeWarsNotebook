import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //System.out.println(overTheRoad(23633656673L, 310027696726L));
        //System.out.println(getMiddle("A"));
        sortArray(new int[]{  5, 3, 1, 8, 0 });


    }


    public static long overTheRoad(long adress, long length){
        if (adress<=0||length<=0||adress>length*2)return -1;

        long[][] street = getStreet(length);
        if (adress%2!=0){
            for(int i=0;i<street.length;i++){
                if (street[i][0]==adress)return street[i][1];
            }
        }
        else{
            for(int i=0;i<street.length;i++){
                if (street[i][1]==adress){
                    return street[i][0];}
            }
        }
        return -1;
    }

    public static String getMiddle(String word) {
        if (word.length()%2==0)return word.substring(word.length()/2-1,word.length()/2+1);
        else return word.substring((word.length())/2,(word.length()+1)/2);
    }

    public static long[][] getStreet(long length){
        long[][] street = new long[(int)length][2];
        int k = 0;
        for (int i=0;i<length;i++){
            street[i][0]=(i*2)+1;
            street[i][1]=(length*2)-k;
            k+=2;
        }
        return street;
    }

    public static int[] sortArray(int[] array) {
        int[] even = new int[array.length];
        List<Integer> odd = new ArrayList<Integer>();

        for (int i =0;i<array.length;i++){
            if (isEven(array[i])) even[i]=array[i];
            else {
                even[i]=-1;
                odd.add(array[i]);
            }
        }
        Collections.sort(odd);
        int counter=0;
        for (int i =0; i<even.length;i++){
            if (even[i]==-1){
                even[i]=odd.get(counter);
                counter++;
            }
        }
        return even;
    }

    private static boolean isEven(int number){
        return number % 2 == 0;
    }



}
