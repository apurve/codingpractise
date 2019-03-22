import java.util.Scanner;

class EditDistance {

    private static int editDistance = 0;

    public static int compute(String first, String second) {
        compute(first.toCharArray(), second.toCharArray(), 0, 0);
        return editDistance;
    }

    private static void compute(char[] first, char[] second, int firstIndex, int secondIndex) {
        if(first[firstIndex] != second[secondIndex]) {
            editDistance++;
            boolean checkSecond = true;
            boolean misMatch = true;
            for(int i=secondIndex; i < second.length; i++) {
                if(first[firstIndex] == second[i]) {
                    firstIndex++;
                    misMatch = false;
                    checkSecond = false;
                }
            }
            if(checkSecond) {
                for(int i=firstIndex; i < first.length; i++) {
                    if(first[firstIndex] == second[i]) {
                        secondIndex++;
                        misMatch = false;
                    }
                }
            }
            if(misMatch) {
                firstIndex++;
                secondIndex++;
            }
        } else {
            firstIndex++;
            secondIndex++;
        }
        if(!(firstIndex == first.length-1 && secondIndex == second.length-1)) {
            if(firstIndex == first.length-1 && secondIndex != second.length-1)
                editDistance++;
            else if(firstIndex != first.length-1 && secondIndex == second.length-1)
                editDistance++;
            else
                compute(first, second, firstIndex, secondIndex);
        }
    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        String s = scan.next();
        String t = scan.next();

        System.out.println(compute(s, t));
    }

}
