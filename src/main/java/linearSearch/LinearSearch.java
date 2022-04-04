package linearSearch;

public class LinearSearch {

    public static int getIndexOfSearchingItem(int[] array, int searchingItem) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) { //Проходимся по массиву линейно, с начала до конца
            if (array[i] == searchingItem)
                return searchingItem; //В случае нахождения элемента, возвращаем его
        }
        return -1;  //Если искомый элемент не найден в массиве, возвращаем "-1"
    }
}
