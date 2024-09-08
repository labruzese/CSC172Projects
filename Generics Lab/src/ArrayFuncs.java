import java.util.function.Function;

/**
 * @author Skylar Abruzese
 */
public final class ArrayFuncs {

    //Task 1
    public static void t1PrintArray(Object[] objArr)
    {
        StringBuilder str = new StringBuilder();
        //Array's should start with open bracket
        str.append("[");

        //Add each object followed by a ','
        for(Object obj : objArr) {
            str.append(obj);
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

    //Task 2
    public static void t2PrintArray(int[] intArr)
    {
        StringBuilder str = new StringBuilder();
        //Array's should start with open bracket
        str.append("[");

        //Add each object followed by a ','
        for(int i : intArr) {
            str.append(i);
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

    public static void t2PrintArray(double[] doubleArr)
    {
        StringBuilder str = new StringBuilder();
        //Array's should start with open bracket
        str.append("[");

        //Add each object followed by a ','
        for(double d : doubleArr) {
            str.append(d);
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

    public static void t2PrintArray(char[] charArr)
    {
        StringBuilder str = new StringBuilder();
        //Array's should start with open bracket
        str.append("[");

        //Add each object followed by a ','
        for(char c : charArr) {
            str.append(c);
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

    public static void t2PrintArray(String[] strArr)
    {
        StringBuilder str = new StringBuilder();
        //Array's should start with open bracket
        str.append("[");

        //Add each object followed by a ','
        for(String s : strArr) {
            str.append(s);
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

    //Task 3
    public static<E> void t3PrintArr(E[] arr)
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

    //Task 4
    /*
    *  Warning: Raw use of parameterized class 'Comparable'
    *  Warning : Unchecked call to 'compareTo(T)' as a member of raw type 'java.lang.Comparable'
    */
    public static Comparable t4GetMax(Comparable[] arr)
    {
        if (arr == null || arr.length == 0) {
            return null;
        }
        Comparable max = arr[0];

        for(Comparable c : arr) {
            if (c.compareTo(max) > 0)
                max = c;
        }

        return max;
    }

    //Task 5
    //E is a comparable that is comparable to any subclass of E
    public static<E extends Comparable<? super E>> E t5GetMax(E[] arr)
    {
        if (arr == null || arr.length == 0){
            return null;
        }

        E max = arr[0];

        for(E elem : arr) {
            if (elem.compareTo(max) > 0)
                max = elem;
        }

        return max;
    }

    //public static Function<Character[], Character> findMax = ArrayFuncs::getMax;
    public static Function<Character[], Character> t6FindMax = (Character[] arr) ->
    {
        if (arr == null || arr.length == 0){
            return null;
        }

        Character max = arr[0];

        for(Character elem : arr) {
            if (elem.compareTo(max) > 0)
                max = elem;
        }

        return max;
    };
}