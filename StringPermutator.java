import java.util.Scanner;

public class StringPermutator {
	
	/*
	Find list of factorials.
	input: integer number. example: number=3
	output: List of factorials, example: factorials=[1,1*2,1*2*3]
	*/
	public static int [] getFactorialsList(int number) {
	if(number<0){
	        return null;
	}	
        int [] factorials = new int[number+1];
        factorials[0] = 1;
        for (int i = 1; i<=number;i++) {
            factorials[i] = factorials[i-1] * i;
        }
        return factorials;
	}
	
	/*
	Find String Permutations.
	input: string to permutate and list of factorials for the input string.
	output: list of permutations.
	*/
	public static String [] findPermutations(String string,int [] factorials) {
        String [] resutls= new String[factorials[string.length()]+1];

        for (int i = 0; i < factorials[string.length()]; i++) {
            String onePermutation="";
            String temp = string;
            int positionCode = i;
            for (int position = string.length(); position > 0 ;position--){
                int selected = positionCode / factorials[position-1];
                onePermutation += temp.charAt(selected);
                positionCode = positionCode % factorials[position-1];
                temp = temp.substring(0,selected) + temp.substring(selected+1);
            }
            resutls[i]=onePermutation;
        }
        
        return resutls;
	}
	
	
	/*
	print list of strings.
	input: array of Strings and the size of the list.
	output: print all list elements on the screen.
	*/
        public static void printStrings(String[] strings,int size) {
	    
        for (int i = 0; i < size; i++) {
           System.out.println(strings[i]);
        }
	}	

	public static void main(String[] args) {
		System.out.print("Enter string to permutate: ");
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		scanner.close();
		int [] factorials =getFactorialsList(string.length());
	    String [] permutations=findPermutations(string,factorials);
	    printStrings(permutations,factorials[string.length()]);
	    
	}
	
}
