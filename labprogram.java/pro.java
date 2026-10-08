public class program1 {
    public static void main(String[] args) {

        int number = 10;

        
        if (number % 2 == 0) {
            System.out.println(number + " is an even number.");
        } else {
            System.out.println(number + " is an odd number.");
        }

        
        System.out.println("Numbers from 1 to 10:");

        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
        }
    }
}