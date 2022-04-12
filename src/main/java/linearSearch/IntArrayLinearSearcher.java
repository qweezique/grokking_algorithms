package linearSearch;

public class IntArrayLinearSearcher {

    public static int getIndexOfSearchingItem(int[] array, int searchingItem) {
        for (int j : array) { //Проходимся по массиву линейно, с начала до конца
            if (j == searchingItem)
                return searchingItem; //В случае нахождения элемента, возвращаем его
        }
        return -1;  //Если искомый элемент не найден в массиве, возвращаем "-1"
    }
}
