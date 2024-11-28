import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PairGenerator {

    private static final Random rnd = new Random();

    /**
     * Разбивает список незнакомцев по парам.
     */

    public List<List<Stranger>> splitByPairs(List<Stranger> strangers) {

        List<List<Stranger>> pairs = new ArrayList<>();
        while (!strangers.isEmpty()) {

            List<Stranger> pair = getRandomPair(strangers);
            // Добавьте новый элемент в набор пар.
            pairs.add(pair);
        }

        return pairs;
    }

    /**
     * Возвращает одну пару и удаляет её из списка strangers
     */
    private List<Stranger> getRandomPair(List<Stranger> strangers) {

        // Генерируем два случайных индекса в пределах списка
        int p1Index = rnd.nextInt(strangers.size());
        int p2Index = rnd.nextInt(strangers.size());
        while (p2Index == p1Index) {
            p2Index = rnd.nextInt(strangers.size());
        }

        // Получаем элементы по сгенерированным индексам
        Stranger strangerOne = strangers.get(p1Index);
        Stranger strangerTwo = strangers.get(p2Index);

        /* Осталось только удалить двух найденных незнакомцев из списка strangers, 
           а затем вернуть их в качестве результата! */
        List<Stranger> pair = List.of(strangerOne, strangerTwo);
        List<Stranger> toRemove = new ArrayList<>(pair);
        strangers.removeAll(toRemove);
        return pair;
    }
}