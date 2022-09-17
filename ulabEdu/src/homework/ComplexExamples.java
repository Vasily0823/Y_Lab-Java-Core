package homework;

import dto.Author;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;


public class ComplexExamples {

    static class Person {
        final int id;

        final String name;

        Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Person person)) return false;
            return getId() == person.getId() && getName().equals(person.getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getId(), getName());
        }

        @Override
        public String toString() {
            return name +" ("+id +")";
        }
    }

    private static Person[] RAW_DATA = new Person[]{
            new Person(0, "Harry"),
            new Person(0, "Harry"), // дубликат
            new Person(1, "Harry"), // тёзка
            new Person(2, "Harry"),
            new Person(3, "Emily"),
            new Person(4, "Jack"),
            new Person(4, "Jack"),
            new Person(5, "Amelia"),
            new Person(5, "Amelia"),
            new Person(6, "Amelia"),
            new Person(7, "Amelia"),
            new Person(8, "Amelia"),
    };


    public static void main(String[] args) {
        System.out.println("Raw data:");
        System.out.println();

        for (Person person : RAW_DATA) {
            System.out.println(person.id + " - " + person.name);
        }



        // Task1
        System.out.println();
        System.out.println("**************************************************");
        System.out.println();
        System.out.println("Duplicate filtered, grouped by name, sorted by name and id");
        System.out.println();

        personsSortByIdGroupingByName(RAW_DATA);




        //Task2
        System.out.println();
        System.out.println("**************************************************");
        System.out.println();
        System.out.println("Output a pair of numbers in brackets [], giving the sum of the given number");
        System.out.println();

        int [] numbers={3,4,2,7};
        int result=10;
        System.out.println(findPair(numbers, result));








        //Task3
        System.out.println();
        System.out.println("**************************************************");
        System.out.println();
        System.out.println("Implement a fuzzy substring search function in a string");
        System.out.println();




        System.out.println(fuzzySearch("car", "ca6$$#_rtwheel"));
        System.out.println(fuzzySearch("cwhl", "cartwheel"));
        System.out.println(fuzzySearch("cwhee", "cartwheel"));
        System.out.println(fuzzySearch("cartwheel", "cartwheel"));
        System.out.println(fuzzySearch("cwheeel", "cartwheel"));
        System.out.println(fuzzySearch("lw", "cartwheel"));



    }


    static void personsSortByIdGroupingByName(Person[] persons){
        if(zeroCheck(persons)) return;


        Map<String, Long> uniqPersons = Arrays.stream(RAW_DATA)
                .distinct()
                .sorted(Comparator.comparing(Person::getId))
                .map(Person::getName)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        for (Map.Entry entry : uniqPersons.entrySet()) {
            System.out.println("Key:" + entry.getKey() + "\n" + "Value:"
                    + entry.getValue());
        }

    }

    static String findPair(int[] numbers, int result){
        if(numbers==null||numbers.length<2)  return "There is no such pair";

        Set<Integer> set = new HashSet<>();
        String isResult=null;

        for (int firstNumber : numbers) {
            int secondNumber = result - firstNumber;
            if (set.contains(secondNumber)) {
                isResult= ("[" + secondNumber + ", " + firstNumber + "]");
                return isResult;
            }
            set.add(firstNumber);
        }

        return "There is no such pair";
    }

    static boolean fuzzySearch(String searchString, String sourceString) {

        if(searchString==null||sourceString==null
                ||searchString.length()==0
                ||sourceString.length()==0
                ||searchString.length()>sourceString.length())
            return false;


        char[] search = searchString.toCharArray();
        char[] source = sourceString.toCharArray();
        int matchedSymbols = 0;


        for (char symbol : source) {
            if (symbol == search[matchedSymbols]) matchedSymbols++;
            if (matchedSymbols == search.length) return true;
        }
        return false;
    }

    static boolean zeroCheck(Person[] persons){
        if(persons==null||persons.length==0){
            System.out.println("Empty array");
            return true;
        }else{
            for (Person person : persons) {
                if (person == null||person.getName()==null) {
                    System.out.println("Empty person");
                    return true;
                }
            }
        }
        return false;
    }

}
