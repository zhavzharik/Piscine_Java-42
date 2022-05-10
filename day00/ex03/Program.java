import java.util.Scanner;

public class Program {

    private static final int MAX_WEEKS_COUNT = 18;

    private static final String TEMPLATE = "Week ";

    private static final String END_PROGRAM = "42";

    private static int getMinGrade(Scanner sc){

        int minGrade = 0;

        if (sc.hasNextInt()){
            minGrade = sc.nextInt();
            if (minGrade < 1 || minGrade > 9){
                System.err.println("IllegalArgument");
                System.exit(-1);
            }
        } else {
            System.err.println("IllegalArgument");
            System.exit(-1);
        }

        int currGrade;

        for (int i=0; i < 4; i++){
            if (sc.hasNextInt()){
                currGrade = sc.nextInt();
                if (currGrade < 1 || currGrade > 9){
                    System.err.println("IllegalArgument");
                    System.exit(-1);
                }
                if (minGrade > currGrade){
                    minGrade = currGrade;
                }
            } else {
                System.err.println("IllegalArgument");
                System.exit(-1);
            }
        }

        sc.nextLine();

        return (minGrade);
    }

    private static long getCounterWeek(int numberWeek){

        int i = 1;

        long counterWeek = 1;

        while (i < numberWeek){
            counterWeek *= 10;
            i++;
        }

        return (counterWeek);
    }

    private static long writeGrades(int minGrade, long allMinGrades, int numberWeek){

        long result;

        long placeGrade = 1;

        long counterWeek;

        counterWeek = getCounterWeek(numberWeek);
        result = allMinGrades + (minGrade * counterWeek);

        return (result);
    }

    private static void  printGrade(int minGrade, int index){
        System.out.print(TEMPLATE + index + " ");

        while (minGrade > 0){
            System.out.print("=");
            minGrade -= 1;
        }

        System.out.println(">");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String inputStr = sc.nextLine();

        int numberWeek = 1;

        long allMinGrades = 0;

        int minGrade;

        while (numberWeek <= MAX_WEEKS_COUNT && !inputStr.equals(END_PROGRAM)){
            if (!inputStr.equals(TEMPLATE + numberWeek)){
                System.err.println("IllegalArgument");
                System.exit(-1);
            }
            minGrade = getMinGrade(sc);
            allMinGrades = writeGrades(minGrade, allMinGrades, numberWeek);
            numberWeek += 1;
            inputStr = sc.nextLine();
        }

        for (int i=1; i < numberWeek; i++){
            minGrade = (int) (allMinGrades % 10);
            printGrade(minGrade, i);
            allMinGrades /= 10;
        }
    }
}