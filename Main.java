public class Main
{
    public static void main(String[] args)
    {
        Vector v = new Vector(10, 300);
        for(int i = 1; i <= 20; i++) v.add(0, i);
        for(int i = 1; i <= 18; i++) v.replace(i, 100 + i);
        print(v);
    }

    private static void print(Object o)
    {
        System.out.println(o);
    }
}