public class Main<T> {

    private int size = 0;
    private Object[] elements;

    public Main() {
        this.elements = new Object[10];
    }

    /**
     * Сначала проверяем, достиг ли размер массива вместимости.
     * Если достиг — увеличиваем вместимость, иначе сразу добавляем элемент
     */
    public void add(T newElement) {
        // Допишите проверку
        if (size == elements.length) {
            grow();
        }
        elements[size] = newElement;
        size = size + 1;

    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Element with index " + index + " does not exist");
        }
        return (T) this.elements[index];
    }

    /**
     * Заменяем текущий массив элементов elements на новый с вместимостью +50%
     */
    private void grow() {
        // Новый массив
        Object[] newArray = new Object[elements.length + elements.length / 2];

        for (int i = 0; i < elements.length; i++) {
            newArray[i] = elements[i];
        }

        // Возвращаемый новый массив
        this.elements = newArray;
    }

    public static void main(String[] args) {
        final var ar = new Main<>();
        for (int i = 0; i < 2000; i++) {
            ar.add(i);
        }
        System.out.println(ar.size);
    }
}