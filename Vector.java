public class Vector
{
    private long[] arr;
    private int count;
    private int capacity;

    public Vector()
    {
        this(0, 0);
    }

    public Vector(int count)
    {
        this(count, 0);
    }

    public Vector(int count, long fill)
    {
        if(count < 0) throw new VectorIndexOutOfBoundsException("Vector index out of range");

        if(count > 0) capacity = (int)Math.pow(2, (int)(Math.log(count) / Math.log(2)) + 1);
        else capacity = 8;

        if(capacity < 8) capacity = 8;
        arr = new long[capacity];
        this.count = count;
        for(int i = 0; i < count; i++) arr[i] = fill;
    }

    public long at(int index)
    {
        if(index >= count || index < 0) throw new VectorIndexOutOfBoundsException("Vector index out of range");
        return (long)arr[index];
    }

    public void add(int index, long element)
    {
        if(index < 0 || index > count) throw new VectorIndexOutOfBoundsException("Vector index out of range");
        if(count == capacity) resizeUp();
        for(int i = count; i > index; i--) arr[i] = arr[i - 1];
        arr[index] = element;
        count++;
    }

    public void add(long element)
    {
        add(count, element);
    }

    public long remove(int index)
    {
        if(index < 0 || index >= count) throw new VectorIndexOutOfBoundsException("Vector index out of range");

        for(int i = index; i < count - 1; i++) arr[i] = arr[i + 1];
        count--;
        if(capacity > 8 && count <= capacity / 4) resizeDown();
        return (long)arr[index];
    }

    public long replace(int index, long element)
    {
        if(index < 0 || index >= count) throw new VectorIndexOutOfBoundsException("Vector index out of range");

        long tmp = (long)arr[index];
        arr[index] = element;
        return tmp;
    }

    public long remove()
    {
        return remove(count - 1);
    }

    public int count()
    {
        return count;
    }

    public int capacity()
    {
        return capacity;
    }

    public boolean isEmpty()
    {
        return count == 0;
    }

    @Override
    public String toString()
    {
        String str = "[";
        for(int i = 0; i < count - 1; i++) str += arr[i] + ", ";
        str += arr[count - 1] + "]";
        return str;
    }

    private void resizeUp()
    {
        long[] newArr = new long[capacity * 2];
        for(int i = 0; i < count; i++) newArr[i] = arr[i];
        capacity *= 2;
        arr = newArr;
    }

    private void resizeDown()
    {
        long[] newArr = new long[capacity / 2];
        for(int i = 0; i < count; i++) newArr[i] = arr[i];
        capacity /= 2;
        arr = newArr;
    }
}

class VectorIndexOutOfBoundsException extends ArrayIndexOutOfBoundsException
{
    public VectorIndexOutOfBoundsException(String message)
    {
        super(message);
    }
}