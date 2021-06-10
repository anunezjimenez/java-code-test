import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CodeTest {
    public static void main(String[] args) {
                
        String[] inputArray = {"aa", "aBCs", "PP", "klmn"};
        String text = "the cat	jumped   over the mat ";
        String wordToFind = "the";
        
        
        System.out.println("1. Execution of 'reverseArray' on {\"aa\", \"aBCs\", \"PP\", \"klmn\"}:");
        String[] reverse = reverseArray(inputArray);
        Arrays.stream(reverse).forEach(x -> System.out.print(x + ",  "));
        
        
        System.out.println("\n\n2. Execution of 'uppercaseArray' on {\"aa\", \"aBCs\", \"PP\", \"klmn\"}:");
        String[] uppercase = uppercaseArray(inputArray);
        Arrays.stream(uppercase).forEach(x -> System.out.print(x + ",  "));
        
        
        System.out.println("\n\n3. Execution of 'findWordCount(\"" + text + "\", \"" + wordToFind + "\")':");
        System.out.println(wordToFind + ": " + findWordCount(text, wordToFind));
        
        
        System.out.println("\n4. Execution of 'composeU' on f(x) = x+1 and f(x) = x*2, with x = 2:");
        Function<Integer, Integer> f = composeU(x -> x + 1, x -> x * 2);
        Integer z = f.apply(2);
        System.out.println(z);
        
        
        System.out.println("\n5. Execution of 'writeContentsToConsole' on file 'test.txt':");
        writeContentsToConsole();
        
        
        System.out.println("\n6. Execution of 'handleInvalidArgument':");
        try {
        	handleInvalidArgument();
        } catch (IllegalArgumentException iae) {
        	System.out.println(iae.getMessage());
        }
        
        
        System.out.println("\n7. Execution of 'puzzle' on {1, 2, 3, 3, 4}:");
        puzzle();
    }
    
    public static String[] reverseArray(String[] input) {
    	String[] reverse = null;
    	Optional<String[]> inputOptional = Optional.ofNullable(input);
    	
    	if (inputOptional.isPresent()) {
    		List<String> inputAsList = Arrays.asList(inputOptional.get());
    		Collections.reverse(inputAsList);
    		reverse = (String[]) inputAsList.toArray();
    	}
        
        return reverse;
    }

    public static String[] uppercaseArray(String[] input) {
    	String[] uppercase = null;
    	
    	if (input != null) {
    		uppercase = Arrays.stream(input)
        			.map(String::toUpperCase)
        			.toArray(String[]::new);
    	}
        
        return uppercase;
    }

    public static int findWordCount(String text, String wordToFind) {
    	int number = 0;
    	
    	Optional<String> optionalText = Optional.ofNullable(text);
    	Optional<String> optionalWordToFind = Optional.ofNullable(wordToFind);
    	
    	if (optionalText.isPresent() && optionalWordToFind.isPresent()) {
            
            Optional<Long> optionalLong = Optional.ofNullable(
	            Arrays.stream(text.split("\\s+"))
	            	.collect(Collectors.groupingBy(x -> x, Collectors.counting()))
	            	.get(optionalWordToFind.get()));
            
            number = optionalLong.isPresent() ? optionalLong.get().intValue() : 0;
    	}
        
        return number;
    }

    public static Function<Integer,Integer> composeU(Function<Integer,Integer> f1, Function<Integer,Integer> f2){
        
    	Function<Integer, Integer> f1Andf2 = f1.andThen(f2);
    	
        return f1Andf2;
    }

    public static void writeContentsToConsole() {
    	Path path = Paths.get("src/resources/test.txt");
    	
		try {
			Files.lines(path).forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    public static void handleInvalidArgument() {
        Integer argInt = 100;
        
        if (argInt > 99) {
        	throw new IllegalArgumentException("Integer too big (" + argInt + ")");
        } else {
        	System.out.println("The argument is: " + argInt);
        }
    }

    public static void puzzle() {
        Integer[] arrayOfInt = {1, 2, 3, 3, 4};
        Integer prevInt = null;
        
        for (Integer currentInt : arrayOfInt) {
        	
        	if (currentInt == prevInt) {
        		System.out.print(currentInt + ",'Snap'");
        		break;
        	} else {
        		prevInt = currentInt;
        		System.out.print(currentInt + ",");
        	}
        }
        
    }
}
