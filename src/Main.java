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
        //System.out.println(createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
        //System.out.println(validate("891"));

        //System.out.println(Arrays.toString(wave(" gap ")));
        //System.out.println(solution(0));
        //System.out.println(greedy(new int[]{1,1,1,3,1}));
        //System.out.println(greedy(new int[]{5,5,5,3,5}));

        //System.out.println(greedy(new int[]{2,4,4,5,4}));
        System.out.println(find(new int[]{Integer.MAX_VALUE, 0, 1}));

    }

   public static int find(int[] integers){
        if (isOdd(integers)){
            for (Integer i:integers) {
                if (i%2==0)return i;
            }
        }
        else
        {
            for (Integer i:integers) {
                if (i%2!=0)return i;
            }
        }
        return 0;
    }

    public static boolean isOdd(int[] integers){
        int odds=0;
        int evens=0;

        for (int i =0;i<3;i++){
            if (integers[i]%2==0)evens++;
            else odds++;
        }

        if (odds>evens)return true;
        else return false;
    }


    public static int greedy(int[] dice){
        int score = 0;

        int tmp=numberOfOccurrence(dice,1);
        if (tmp>2){
            score+=1000;
        tmp-=3;
        tmp-=tmp;
        }
        score+=tmp*100;

        tmp=numberOfOccurrence(dice,5);
        if (tmp>2){
            score+=500;
            tmp-=3;
            score+=tmp*50;
            tmp-=tmp;
        }
        score+=tmp*50;

        if (numberOfOccurrence(dice,2)>=3) score+=200;
        if (numberOfOccurrence(dice,3)>=3) score+=300;
        if (numberOfOccurrence(dice,4)>=3) score+=400;
        if (numberOfOccurrence(dice,6)>=3) score+=600;

        return score;
    }

    public static int numberOfOccurrence(int[] dice, int numberSearched){
        int counter =0;
        for (Integer i:dice) {
            if (i==numberSearched)counter++;
        }
        return counter;
    }

    public static int solution(int number) {
        if (number<0)return 0;
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i=0;i<number;i++){
            if (i%3==0 || i%5==0){
                arrayList.add(i);
            }
        }
        int counter=0;

        for (Integer i:arrayList) {
            counter+=i;
        }


        return counter;
    }


    public static String[] wave(String str) {
        if (str.equals(""))return new String[] {};
        ArrayList<String> arrayList = new ArrayList<>();

        for (int i =0; i<str.length();i++){
            if (str.charAt(i) != ' ')

            {
                if (i==0)
                {
                    arrayList.add(str.substring(0,1).toUpperCase()+str.substring(1));
                }
                else
                    {
                        arrayList.add(str.substring(0,i)+str.substring(i,i+1).toUpperCase()+str.substring(i+1));
                    }
            }

        }

        return arrayList.toArray(new String[0]);
    }


    public static int getNumberOfSpaces(String str){
        int numberOfspaces=0;
        for (int i =0;i<str.length();i++){
            if (str.charAt(i) == ' ')numberOfspaces++;
        }
        return numberOfspaces;
    }

    public static boolean validate(String number){
        int[] array = new int[number.length()];
        for (int i =0;i<number.length();i++){
            array[i]=Integer.parseInt(number.substring(i,i+1));
        }

        int counter = 0;

        if (array.length%2==0){
            counter=0;
        }
        else{counter=1;}

        for (int i = counter;i<array.length;i+=2){
            array[i]*=2;
        }

        int sum=0;
        for (int i =0;i<array.length;i++)
        {

            if (array[i]>9){
                array[i]-=9;
            }
            sum+=array[i];
        }

        if (sum%10==0 )return true;
        return false;
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
