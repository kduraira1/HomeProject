import java.util.Arrays;

public class FindHighestAltitude {
    public int largestAltitude(int[] gain) {
        int result =0;
        int interGain =0;
        for (int i=0; i < gain.length; i++) {

            interGain += gain[i];
            if (interGain > result)
                result = interGain;
        }
        return result;
    }
    public static void main(String[] args) {
        FindHighestAltitude cd = new FindHighestAltitude();
        int[] arr = new int[] { -5,1,5,0,-7};
        System.out.println(Arrays.toString(arr));
        int dup = cd.largestAltitude(arr);
        System.out.println(dup);
        System.out.println(Arrays.toString(arr));

    }
}
