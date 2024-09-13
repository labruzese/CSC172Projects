import java.util.function.Function;

/**@author Skylar Abruzese*/
public class ArrayFuncs {
//    //Task 1
//    public static void printArray(Object[] objArr)
//    {
//        StringBuilder str = new StringBuilder();
//        //Array's should start with open bracket
//        str.append("[");
//
//        //Add each object followed by a ','
//        for(Object obj : objArr) {
//            str.append(obj);
//            str.append(",");
//        }
//
//        //Remove comma after last object if it's printed
//        if(str.length() > 1)
//            str.deleteCharAt(str.length()-1);
//
//        //Close our array with a closing bracket
//        str.append("]");
//
//        //Print array to console
//        System.out.println(str);
//    }

//    //Task 2
//    public static void printArray(int[] intArr)
//    {
//        StringBuilder str = new StringBuilder();
//        //Array's should start with open bracket
//        str.append("[");
//
//        //Add each object followed by a ','
//        for(int i : intArr) {
//            str.append(i);
//            str.append(",");
//        }
//
//        //Remove comma after last object if it's printed
//        if(str.length() > 1)
//            str.deleteCharAt(str.length()-1);
//
//        //Close our array with a closing bracket
//        str.append("]");
//
//        //Print array to console
//        System.out.println(str);
//    }
//
//    public static void printArray(double[] doubleArr)
//    {
//        StringBuilder str = new StringBuilder();
//        //Array's should start with open bracket
//        str.append("[");
//
//        //Add each object followed by a ','
//        for(double d : doubleArr) {
//            str.append(d);
//            str.append(",");
//        }
//
//        //Remove comma after last object if it's printed
//        if(str.length() > 1)
//            str.deleteCharAt(str.length()-1);
//
//        //Close our array with a closing bracket
//        str.append("]");
//
//        //Print array to console
//        System.out.println(str);
//    }
//
//    public static void printArray(char[] charArr)
//    {
//        StringBuilder str = new StringBuilder();
//        //Array's should start with open bracket
//        str.append("[");
//
//        //Add each object followed by a ','
//        for(char c : charArr) {
//            str.append(c);
//            str.append(",");
//        }
//
//        //Remove comma after last object if it's printed
//        if(str.length() > 1)
//            str.deleteCharAt(str.length()-1);
//
//        //Close our array with a closing bracket
//        str.append("]");
//
//        //Print array to console
//        System.out.println(str);
//    }
//
//    public static void printArray(String[] strArr)
//    {
//        StringBuilder str = new StringBuilder();
//        //Array's should start with open bracket
//        str.append("[");
//
//        //Add each object followed by a ','
//        for(String s : strArr) {
//            str.append(s);
//            str.append(",");
//        }
//
//        //Remove comma after last object if it's printed
//        if(str.length() > 1)
//            str.deleteCharAt(str.length()-1);
//
//        //Close our array with a closing bracket
//        str.append("]");
//
//        //Print array to console
//        System.out.println(str);
//    }

    //Task 3
    public static<E> void printArray(E[] arr)
    {
        StringBuilder str = new StringBuilder();
        //Array's should start with open bracket
        str.append("[");

        //Add each object followed by a ','
        for(E elem : arr) {
            str.append(elem);
            str.append(",");
        }

        //Remove comma after last object if it's printed
        if(str.length() > 1)
            str.deleteCharAt(str.length()-1);

        //Close our array with a closing bracket
        str.append("]");

        //Print array to console
        System.out.println(str);
    }

//    //Task 4
//    /*
//    *  Warning: Raw use of parameterized class 'Comparable'
//    *  Warning : Unchecked call to 'compareTo(T)' as a member of raw type 'java.lang.Comparable'
//    */
//    public static Comparable getMax(Comparable[] arr)
//    {
//        //check special cases
//        if (arr == null || arr.length == 0) {
//            return null;
//        }
//
//        //Basic find max algorithm
//        Comparable max = arr[0];
//
//        for(Comparable c : arr) {
//            if (c.compareTo(max) > 0)
//                max = c;
//        }
//
//        return max;
//    }

    //Task 5
    //E is a comparable that is comparable to any subclass of E
    public static<E extends Comparable<? super E>> E getMax(E[] arr)
    {
        //check special cases
        if (arr == null || arr.length == 0){
            return null;
        }

        //Basic find max algorithm
        E max = arr[0];

        for(E elem : arr) {
            if (elem.compareTo(max) > 0)
                max = elem;
        }

        return max;
    }

    //Task 6
    //public static Function<Character[], Character> findMax = ArrayFuncs::getMax;
    public static Function<Character[], Character> findMax = (Character[] arr) ->
    {
        //check special cases
        if (arr == null || arr.length == 0){
            return null;
        }

        //Basic find max algorithm
        Character max = arr[0];

        for(Character elem : arr) {
            if (elem.compareTo(max) > 0)
                max = elem;
        }

        return max;
    };

    public static void main(String[] args) {
        Integer [] intArray = {1, 2, 3, 4, 5 };
        Double [] doubleArray = {1.1, 2.2, 3.3, 4.4};
        Character [] charArray = {'H','E','L', 'L', 'O' };
        String [] strArray = {"once", "upon", "a", "time" };
        printArray(intArray);
        printArray(doubleArray);
        printArray(charArray);
        printArray(strArray);

        System.out.println("max Integer is: " + getMax(intArray));
        System.out.println("max Double is: " + getMax(doubleArray));
        System.out.println("max Character is: " + getMax(charArray));
        System.out.println("max String is: " + getMax(strArray));
        
        System.out.println("max Character (Functional call) is: " + findMax.apply(charArray));
    }
}