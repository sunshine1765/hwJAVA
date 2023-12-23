import java.util.*;

public class PhoneBook {
    public static void main(String[] args) {
        // Создание и заполнение телефонной книги
        Map<String, List<String>> phoneBook = new HashMap<>();
        addContact(phoneBook, "Иванов", "555-1111");
        addContact(phoneBook, "Петров", "555-2222");
        addContact(phoneBook, "Сидоров", "555-3333");
        addContact(phoneBook, "Иванов", "555-4444");
        addContact(phoneBook, "Петров", "555-5555");
        addContact(phoneBook, "Сидоров", "555-6666");

        // Получение и сортировка списка контактов
        List<Map.Entry<String, List<String>>> sortedContacts = new ArrayList<>(phoneBook.entrySet());
        sortedContacts.sort(Comparator.comparing(entry -> entry.getValue().size(), Comparator.reverseOrder()));

        // Вывод отсортированных контактов
        for (Map.Entry<String, List<String>> entry : sortedContacts) {
            String name = entry.getKey();
            List<String> phoneNumbers = entry.getValue();
            System.out.println(name + ": " + phoneNumbers);
        }
    }

    private static void addContact(Map<String, List<String>> phoneBook, String name, String phoneNumber) {
        if (phoneBook.containsKey(name)) {
            List<String> phoneNumbers = phoneBook.get(name);
            phoneNumbers.add(phoneNumber);
        } else {
            List<String> phoneNumbers = new ArrayList<>();
            phoneNumbers.add(phoneNumber);
            phoneBook.put(name, phoneNumbers);
        }
    }
}
