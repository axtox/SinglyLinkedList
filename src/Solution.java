import java.util.*;

class Solution {
    public static void main(String args[]) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        SinglyLinkedList singlyLinkedList1 = new SinglyLinkedList();
        HashSet<Integer> integerList = new HashSet<Integer>();  //для соблюдения условия об уникальности чисел, было решено записывать числа в HashSet
        Random random = new Random();                           //т.к. HashSet не может хранить не уникальные чисела
        while (integerList.size() < 16) {
            integerList.add(random.nextInt(100));               //добавляем числа в случайном порядке
        }
        for (int s : integerList) {                             //добавляем в списки одни и те же числа
            singlyLinkedList.add(s);
            singlyLinkedList1.add(s);                           //расположение чисел не будет иметь значения при поиске удаленного элемента
        }
        singlyLinkedList.remove(integerList.iterator().next()); //удаляем число. Можно указать любое число от 0 до 100,
        singlyLinkedList.printList();                           //но чтобы не гадать, просто укажем следующий элемент в integerList
        System.out.println();
        singlyLinkedList1.printList();
        System.out.println();
        singlyLinkedList1.printAllUnequalValues(singlyLinkedList); //с помощью этого метода на экран выводятся все несоотвествия в списках
    }
}
    class Element {
        Element next;                       // указатель на следующий элемент
        int data;
    }
    class SinglyLinkedList {
        private Element first;              // указатель на первый элемент
        private Element last;               // указатель последний элемент
        private int size = 0;               // размер списка

        void add(int data) {                //добавление в конец списка
            Element newData = new Element();
            newData.data = data;
            if (size == 0) {
                first = newData;
                last = newData;
                size++;
            } else {
                last.next = newData;
                last = newData;
                size++;
            }
        }

        void printList() {                  //печать списка
            Element temporary = first;
            while (temporary != null) {
                System.out.print(temporary.data + " ");
                temporary = temporary.next;
            }
        }

        void remove(int data)               //удаление элемента
        {
            if (size == 0) return;

            if (first == last) {            //если список состоит из одного элемента
                first = null;
                last = null;
                return;
            }

            if (first.data == data) {       //если первый элемент
                first = first.next;
                return;
            }

            Element temporary = first;       //иначе начинаем искать
            while (temporary.next != null) {
                if (temporary.next.data == data) {
                    if(last == temporary.next) {
                        last = temporary;
                    }
                    temporary.next = temporary.next.next;
                    return;
                }
                temporary = temporary.next;
            }
        }

        void printAllUnequalValues(SinglyLinkedList linkedList) {   //печать всех не одинаковых элементов в списках
            if ((size == 0) | (linkedList.size == 0)) return;       //метод найдет применение только для выполнения условий Задачи 2

            Element temporary1 = first;

            for (int counter = 0; counter < this.size; counter++) {
                boolean gotIt = false;                              //true - если элементы списка совпали
                Element temporary2 = linkedList.first;
                for (int counter2 = 0; counter2 < linkedList.getSize(); counter2++) {
                    if (temporary1.data == temporary2.data) {
                        gotIt = true;
                        break;
                    }
                    if (temporary2.next != null) {
                        temporary2 = temporary2.next;
                    } else break;
                }
                if (!gotIt) {
                    System.out.print(temporary1.data + " ");
                }
                temporary1 = temporary1.next;
            }
        }

        int getSize() {
            return size;
        }
    }