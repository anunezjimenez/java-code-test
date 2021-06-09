package main.java;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CodeTest {
    public static void main(String[] args) {
        System.out.println("Please replace this with calls to all completed tests.");
        String[] input = {"aa", "aBCs", "PP", "klmn"};
//        String [] input = null;
//        String[] inversa = reverseArray(input);
//        String[] inversa = uppercaseArray(input);
//        for (String cadena : inversa) {
//        	System.out.println(cadena);
//        }
        
//        System.out.println(findWordCount("the cat	jumped   over the mat ", "the"));
//        System.out.println(findWordCount(null, "the"));
        
//        Function<Integer, Integer> f = composeU(x -> x + 1, x -> x * 2);
//        Integer z = f.apply(2);
//        System.out.println(z);
        
        writeContentsToConsole();
    }

    public static String[] reverseArray(String[] input) {
    	String[] reverse = null;
    	Optional<String[]> inputOptional = Optional.ofNullable(input);
    	
    	if (inputOptional.isPresent()) {
//    	if (input != null) {
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
//    		List<String> inputAsList = Arrays.asList(input);inputAsList.replaceAll(String::toUpperCase);
    	}
        
        return uppercase;
    }

    public static int findWordCount(String text, String wordToFind) {
    	int number = 0;
    	
//    	if (text != null && wordToFind != null) {
//    		Stream<String> textAsStream = Arrays.stream(text.split("\\s+"));
//            Map<Object, Long> wordsMap = textAsStream.collect(Collectors.groupingBy(x -> x, Collectors.counting()));
//            Long numberLong = wordsMap.get(wordToFind);
//            
//            if (numberLong != null) {
//            	number = numberLong.intValue();
//            }
//    	}
    	
    	Optional<String> optionalText = Optional.ofNullable(text);
    	Optional<String> optionalWordToFind = Optional.ofNullable(wordToFind);
    	
    	if (optionalText.isPresent() && optionalWordToFind.isPresent()) {
//    		Stream<String> textAsStream = Arrays.stream(text.split("\\s+"));
//    		Map<Object, Long> wordsMap = textAsStream.collect(Collectors.groupingBy(x -> x, Collectors.counting()));
//    		Optional<Long> optionalLong = Optional.ofNullable(wordsMap.get(optionalWordToFind.get()));
            
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
    	Path path = Paths.get("prueba.txt");
    	
		try {
//			SeekableByteChannel inputChannel = Files.newByteChannel(path, StandardOpenOption.READ);
//			
//			ByteBuffer buffer = ByteBuffer.allocate(8192);
//			
//	        while (inputChannel.read(buffer) >= 0) {
//	        	buffer.flip();
//	            
//	        	buffer.clear();
//	        }
	        
//			Stream<String> fileStream = Files.lines(path);
//			fileStream.forEach(System.out::println);
			Files.lines(path).forEach(System.out::println);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public static void handleInvalidArgument() {
        // add code here
    }

    public static void puzzle() {
        // add code here
    }
}
