import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.function.Function;

public class Testing {

    public static boolean task1() { Random rand = new Random(); return task1(rand.nextLong()); }
    public static boolean task1(long seed){

        /*
        This defines how to generate a random string
         */
        Function<Random, String> randomStringFunction = (Random rand) -> "" +
                (char)rand.nextInt('a','z') +
                (char)rand.nextInt('a','z') +
                (char)rand.nextInt('a','z');

        /*
        Generate our random object array.
        Each object has a 50% chance of being an int, 25% chance of a double,
        25% chance of a String
         */
        Object[] objectArray = randomArray(
                seed,
                randomStringFunction::apply,
                Object.class
        );

        System.out.println("\tTask 1 Seed: \n\t\t" + seed); //For debugging

        //Test our task 1 method
        System.out.print("\tObject Array: \n\t\t");
        ArrayFuncs.t1PrintArray(objectArray);

        return true;
    }

    public static boolean task2() { Random rand = new Random(); return task2(rand.nextLong()); }
    public static boolean task2(long seed) {
        Random rand = new Random(seed);

        /*
        Since java loves its primitives and making everything difficult,
        when we pass in int.class it gets auto-boxed into an Integer so that
        it plays nice with the generics. However, it doesn't nicely unbox
        when I want it to be an int[] again, so we have to map each value
        back into an int so that we can have our primitive int[].
        */
        int[] intArray = Arrays.stream(
                randomArray (
                    seed,
                    randomObject -> randomObject.nextInt(100),
                    Integer.class
                )
            ).mapToInt(Integer::intValue).toArray();

        double[] doubleArray = Arrays.stream(
                randomArray(
                    seed,
                    RandomObject -> RandomObject.nextDouble(100),
                    Double.class
                )
            ).mapToDouble(Double::doubleValue).toArray();

        /*
        Furthermore, the arrays stream doesn't have a nice way to interpret
        my stream as a char[] so we are going to have to do this one the
        old-fashioned way
        */
        Character[] tempCharacterArray = randomArray(
                seed,
                (Random r) -> (char) r.nextInt('a', 'z' + 1),
                Character.class
        );
        char[] charArray = new char[tempCharacterArray.length];
        for (int i = 0; i < tempCharacterArray.length; i++)
            charArray[i] = tempCharacterArray[i];

        /*
        Strings are not primitive so this one can be normal
         */
        String[] stringArray = randomArray(
                seed,
                (Random r) -> {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < 3; i++) sb.append((char)r.nextInt('a', 'z' + 1));
                    return sb.toString(); },
                String.class
        );

        System.out.println("\tTask 2 Seed: \n\t\t" + seed);

        //Test task 2 part 1 int[] method
        System.out.print("\tInt Array: \n\t\t");
        ArrayFuncs.t2PrintArray(intArray);

        //Test task 2 part 2 double[] method
        System.out.print("\tDouble Array: \n\t\t");
        ArrayFuncs.t2PrintArray(doubleArray);

        //Test task 2 part 3 char[] method
        System.out.print("\tChar Array: \n\t\t");
        ArrayFuncs.t2PrintArray(charArray);

        //Test task 2 part 4 String[] method
        System.out.print("\tString Array: \n\t\t");
        ArrayFuncs.t2PrintArray(stringArray);

        return true;
    }

    public static boolean task3() { Random rand = new Random(); return task3(rand.nextLong()); }
    public static boolean task3(long seed){
        String[] stringArray = randomArray(seed, (Random rand) -> "" +
                (char)rand.nextInt('a','z') +
                (char)rand.nextInt('a','z') +
                (char)rand.nextInt('a','z'),
                String.class
        );

        /*
        Generic methods won't accept a double[] unfortunately. Therefore,
        task 3 has to use a Double[].
         */
        Double[] doubleArray = randomArray(
                seed,
                (Random rand) -> rand.nextDouble(100),
                Double.class
        );

        System.out.println("\tTask 5 Seed: \n\t\t" + seed);

        //Test task 3 with strings
        System.out.print("\tString Array Printing: \n\t\t");
        ArrayFuncs.t3PrintArr(stringArray);


        //Test task 3 with doubles
        System.out.print("\tDouble Array Printing: \n\t\t");
        ArrayFuncs.t3PrintArr(doubleArray);

        return true;
    }

    public static boolean task4() { Random rand = new Random(); return task4(rand.nextLong()); }
    public static boolean task4(long seed){
        Function<Random, String> randomStringFunction = (Random r) -> {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 3; i++) sb.append((char)r.nextInt('a', 'z' + 1));
            return sb.toString();
        };

        String[] stringArray = randomArray(
                seed,
                randomStringFunction,
                String.class
        );

        //This should be our successful case
        @SuppressWarnings("rawtypes")
        Comparable stringAnswer = ArrayFuncs.t4GetMax(stringArray);

        //This will be our failure case (why raw types might not be a good idea haha)
        @SuppressWarnings("rawtypes")
        Comparable[] mixedArray = randomArray(
                seed,
                (Random rand) ->
                    rand.nextBoolean()? rand.nextInt(100) : randomStringFunction.apply(rand),
                Comparable.class
        );

        System.out.println("\tTask 4 Seed: \n\t\t" + seed);

        //print our arrays so that we can check our answers
        System.out.print("\tString Array: \n\t\t");
        ArrayFuncs.t3PrintArr(stringArray);

        System.out.print("\tMixed Array: \n\t\t");
        ArrayFuncs.t3PrintArr(mixedArray);

        //Before printing our answers I will attempt to get an answer for the mixed array
        @SuppressWarnings("rawtypes")
        Comparable mixedAnswer = null;
        try{
            mixedAnswer = ArrayFuncs.t4GetMax(mixedArray);
        } catch (Exception e) { //of course this will always fail
            System.out.println("\t\033[0;31mException caught while getting mixed error: " + e.getMessage() + "\033[0m");
        }

        System.out.println("\tTask 4 Answer:" + "\n\t\tString Array: " + stringAnswer + "\n\t\tMixed Array: " + mixedAnswer);

        //This will be the successfulness of our test (this one will always fail)
        return mixedAnswer != null;
    }

    public static boolean task5() { Random rand = new Random(); return task5(rand.nextLong()); }
    public static boolean task5(long seed) {
        String[] stringArray = randomArray(
                seed,
                (Random r) -> {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < 3; i++) sb.append((char)r.nextInt('a', 'z' + 1));
                    return sb.toString(); },
                String.class
        );

        //Again, generics won't accept a primitive[]
        Integer[] integerArray = randomArray(
                seed,
                (Random rand) -> rand.nextInt(100),
                Integer.class
        );


        String stringAnswer = ArrayFuncs.t5GetMax(stringArray);
        Integer integerAnswer = ArrayFuncs.t5GetMax(integerArray);

        System.out.println("\tTask 5 Seed: \n\t\t" + seed);

        System.out.print("\tString Array: \n\t\t");
        ArrayFuncs.t3PrintArr(stringArray);

        System.out.print("\tInteger Array: \n\t\t");
        ArrayFuncs.t3PrintArr(integerArray);

        System.out.println("\tTask 5 Answer: " + "\n\t\tString Array: " + stringAnswer + "\n\t\tInteger Array: " + integerAnswer);

        return true;
    }

    public static boolean task6() { Random rand = new Random(); return task6(rand.nextLong()); }
    public static boolean task6(long seed){
        Character[] characterArray = randomArray(
                seed,
                (Random rand) -> (char)rand.nextInt('a','z'),
                Character.class
        );

        //This is how we invoke and capture output Function(the class)
        Character answer = ArrayFuncs.t6FindMax.apply(characterArray);

        System.out.println("\tTask 6 Seed: \n\t\t" + seed);

        System.out.print("\tCharacter Array: \n\t\t");
        ArrayFuncs.t3PrintArr(characterArray);

        System.out.println("\tTask 6 Answer: \n\t\t" + answer);

        return true;
    }

    /**
     * @param seed the seed used to generate the random data
     * @param createRandomEObject lambda used to create a random instance
     *                            of an E object for the array
     * @param myClass the class of object that the array will contain (should match type E)
     * @return a new array between lengths 0 and 15 (lower inclusive) (upper exclusive) with "random" elements
     * @param <E> The type of array to be created
     */
    private static<E> E[] randomArray(long seed, Function<Random, E> createRandomEObject, Class<E> myClass) {

        Random rand = new Random(seed);
        int size = rand.nextInt(0,15);

        //We just yolo this cast since we know that the type we're passing to the method is 'E'
        @SuppressWarnings("unchecked")
        E[] arr = (E[]) Array.newInstance(myClass, size);

        for(int i = 0; i < arr.length; i++){
            arr[i] = createRandomEObject.apply(rand);
        }

        return arr;
    }

    public static void main(String[] args) {
        boolean result;

        System.out.println("\u001B[1mRunning Task 1:\033[0m");
        result = task1();
        System.out.println("\u001B[1mTask 1 result: " + (result ? "\033[0;32mPassed\033[0m (expected \033[0;32mPassed\033[0m)" : "\033[0;31mFailed\033[0m (expected \033[0;32mPassed\033[0m)"));

        System.out.print("---------------------------------------------");

        System.out.println("\u001B[1m\nRunning Task 2:\033[0m");
        result = task2();
        System.out.println("\u001B[1mTask 2 result: " + (result ? "\033[0;32mPassed\033[0m (expected \033[0;32mPassed\033[0m)" : "\033[0;31mFailed\033[0m (expected \033[0;32mPassed\033[0m)"));

        System.out.print("---------------------------------------------");

        System.out.println("\u001B[1m\nRunning Task 3:\033[0m");
        result = task3();
        System.out.println("\u001B[1mTask 3 result: " + (result ? "\033[0;32mPassed\033[0m (expected \033[0;32mPassed\033[0m)" : "\033[0;31mFailed\033[0m (expected \033[0;32mPassed\033[0m)"));

        System.out.print("---------------------------------------------");

        System.out.println("\u001B[1m\nRunning Task 4:\033[0m");
        result = task4();
        System.out.println("\u001B[1mTask 4 result: " + (result ? "\033[0;32mPassed\033[0m (expected \033[0;31mFailed\033[0m -- check to see if mixed array randomly got assigned only 1 type)" : "\033[0;31mFailed\033[0m (expected \033[0;31mFailed\033[0m)"));

        System.out.print("---------------------------------------------");

        System.out.println("\u001B[1m\nRunning Task 5:\033[0m");
        result = task5();
        System.out.println("\u001B[1mTask 5 result: " + (result ? "\033[0;32mPassed\033[0m (expected \033[0;32mPassed\033[0m)" : "\033[0;31mFailed\033[0m (expected \033[0;32mPassed\033[0m)"));

        System.out.print("---------------------------------------------");

        System.out.println("\u001B[1m\nRunning Task 6:\033[0m");
        result = task6();
        System.out.println("\u001B[1mTask 6 result: " + (result ? "\033[0;32mPassed\033[0m (expected \033[0;32mPassed\033[0m)" : "\033[0;31mFailed\033[0m (expected \033[0;32mPassed\033[0m)"));

        System.out.println("\n*Note that passed does not check that findMax gets the right answer, rather that each method doesn't crash/throw an exception and that the answer can be interpreted properly");
    }
}
