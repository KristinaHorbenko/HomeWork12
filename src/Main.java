import java.util.List;

public class Main {
    public static void main(String[] args) {
        FileNavigator fileNavigator = new FileNavigator();

        fileNavigator.add(new FileData("files.txt, firstApp.java", 100, "/path/to/file"));
        fileNavigator.add(new FileData("files.txt1, firstApp.java", 120, "/path1/to/file"));
        fileNavigator.add( new FileData("files.txt2, firstApp.java", 150, "/path2/to/file"));

       // fileNavigator.display();

        FileData file = new FileData("example.txt", 100, "/path/to/file");
        // Додавання файлу за вказаним шляхом
        fileNavigator.addFile(file);
        fileNavigator.display();

        System.out.println();

        String path = "/path/to/file";
        List<FileData> foundFiles = fileNavigator.find(path);
        System.out.println("Файли знайдено за шляхом " + path + ":");
        for (FileData fileData : foundFiles) {
            System.out.println(fileData.getName());
        }

        System.out.println();

        // Фільтрація файлів за розміром
        long maxSize = 100;
        List<FileData> filteredFiles = fileNavigator.filterBySize(maxSize);
        System.out.println("Файли з розміром <= " + maxSize + ":");
        for (FileData fileData : filteredFiles) {
            System.out.println(fileData.getName());
        }

        System.out.println();

        // Видалення файлу за шляхом
        fileNavigator.remove("/path/to/file");
        System.out.println("Файли після видалення:");
        fileNavigator.display();

        System.out.println();

        // Сортування файлів за розміром
        List<FileData> sortedFiles = fileNavigator.sortBySize();
        System.out.println("Файли відсортовані за розміром:");
        for (FileData fileData : sortedFiles) {
            System.out.println(fileData.getName() + " - " + fileData.getSize() + " байтів");
        }
    }
}

