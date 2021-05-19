public class Vector<T>
{
    private Object[] arr;
    private int count;
    private int capacity;

    public Vector()
    {
        arr = new Object[8];
        count = 0;
        capacity = 8;
    }

    public Vector(int count, T fill)
    {
        if(count < 0) throw new VectorIndexOutOfBoundsException("Vector index out of range");
        capacity = (int)Math.pow(2, (int)(Math.log(count) / Math.log(2)) + 1);
        if(capacity < 8) capacity = 8;
        arr = new Object[capacity];
        this.count = count;
        for(int i = 0; i < count; i++) arr[i] = fill;
    }

    public T at(int index)
    {
        if(index >= count || index < 0) throw new VectorIndexOutOfBoundsException("Vector index out of range");
        return (T)arr[index];
    }

    public void add(T element, int index)
    {
        if(index < 0 || index > count) throw new VectorIndexOutOfBoundsException("Vector index out of range");
        if(count == capacity) resizeUp();
        for(int i = count; i > index; i--) arr[i] = arr[i - 1];
        arr[index] = element;
        count++;
    }

    public void add(T element)
    {
        add(element, count);
    }

    public T remove(int index)
    {
        if(index < 0 || index >= count) throw new VectorIndexOutOfBoundsException("Vector index out of range");
        for(int i = index; i < count - 1; i++) arr[i] = arr[i + 1];
        count--;
        if(capacity > 8 && count <= capacity / 4) resizeDown();
        return (T)arr[index];
    }

    public T replace(T element, int index)
    {
        if(index < 0 || index >= count) throw new VectorIndexOutOfBoundsException("Vector index out of range");
        T tmp = (T)arr[index];
        arr[index] = element;
        return tmp;
    }

    public T remove()
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

    private void resizeUp()
    {
        Object[] newArr = new Object[capacity * 2];
        for(int i = 0; i < count; i++) newArr[i] = arr[i];
        capacity *= 2;
        arr = newArr;
    }

    private void resizeDown()
    {
        Object[] newArr = new Object[capacity / 2];
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