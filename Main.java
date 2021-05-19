public class Main
{
    public static void main(String[] args)
    {
        Vector<Integer> v = new Vector<Integer>(10, 300);
        for(int i = 1; i <= 20; i++) v.add(i, 0);
        for(int i = 1; i <= 18; i++) v.replace(100 + i, i);
    }
}