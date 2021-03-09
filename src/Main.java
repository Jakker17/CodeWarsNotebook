import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //System.out.println(overTheRoad(23633656673L, 310027696726L));
        //System.out.println(getMiddle("A"));
        //sortArray(new int[]{  5, 3, 1, 8, 0 });
        //System.out.println(dontGiveMeFive(1,9));
        //System.out.println(countBits(10));

        //System.out.println(bouncingBall(30.0, 1, 1.5));
        System.out.println(createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
    }

    public static String createPhoneNumber(int[] numbers) {
        return "("+numbers[0]+numbers[1]+numbers[2]+") "+numbers[3]+numbers[4]+numbers[5]+"-"+numbers[6]+numbers[7]+numbers[8]+numbers[9];
        //return String.format("(%d%d%d) %d%d%d-%d%d%d%d",numbers[0],numbers[1],numbers[2],numbers[3],numbers[4],numbers[5],numbers[6],numbers[7],numbers[8],numbers[9]);
    }

    public static int bouncingBall(double h, double bounce, double window) {
        if (h<=0)return -1;
        else if (bounce<=0||bounce>=1)return -1;
        else if (window>=h)return -1;
        int counter=0;
        double bh=h;
        do {
            counter++;
            bh = bh*bounce;
            if (bh>=window)counter++;
        }while (bh>=window);
        return counter;
    }


    public static int countBits(int n){
        String binary = Integer.toBinaryString(n);
        int counter=0;
        for (int i= 0; i<binary.length();i++){
            if (binary.substring(i,i+1).contains("1"))
            counter++;
        }
        return counter;
    }

    public static int dontGiveMeFive(int start, int end)
    {
        int counter=0;
        for (int i=start;i<=end;i++){
            if (!String.valueOf(i).contains("5"))counter++;
        }
        return counter;
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
