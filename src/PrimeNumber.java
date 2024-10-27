import java.util.ArrayList;
import java.util.List;

public class PrimeNumber {

    public List<Integer> generatePrimeNumber(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(2);
        if(n < 3) return result;
        for (int i = 3; i <= n; i++) {
            if (isPrimeR(i, i-1)) {
                result.add(i);

            }
        }
        return result;
    }

    public boolean isPrime(int n){
        if(n <= 1) return false;
        for(int i = 2; i < Math.sqrt(n); i++) {
            if(n % i == 0) return false;
        }
        return true;

    }
    public boolean isPrimeR(int n, int i){
       /* if(i <= 1) return false;
        if (i % index == 0) return false;
        return isPrime(i, index -1);*/
        // Base cases
       // reach here then none divide it.
        if(i == 1 ) return true;
        if (n <= 2)
            return (n == 2) ? true : false;
        if (n % i == 0)
            return false;
        // Check for next divisor
        return isPrimeR(n, i - 1);
    }



    public static void main(String[] args){
        PrimeNumber prime = new PrimeNumber();
        System.out.println(prime.generatePrimeNumber(100));

    }
}
