import java.util.*;

public class FileNavigator {

    private final Map<String, List<FileData>> fileByPath;

    public FileNavigator() {
        fileByPath = new HashMap<>();
    }

    public void add(FileData fileData) {
        String path = fileData.getPath();
        List<FileData> fileList = fileByPath.getOrDefault(path, new ArrayList<>());
        fileList.add(fileData);
        fileByPath.put(path, fileList);
    }

    public List<FileData> find(String path) {
        return fileByPath.getOrDefault(path, new ArrayList<>());
    }

    public List<FileData> filterBySize(long maxSize) {
        List<FileData> result = new ArrayList<>();
        for (List<FileData> fileList : fileByPath.values()) {
            for (FileData fileData : fileList) {
                if (fileData.getSize() <= maxSize) {
                    result.add(fileData);
                }
            }
        }
        return result;
    }

    public void remove(String path) {
        fileByPath.remove(path);

    }
    public List<FileData> sortBySize() {
        List<FileData> allFiles = new ArrayList<>();
        for (List<FileData> fileList : fileByPath.values()) {
            allFiles.addAll(fileList);
        }
        Collections.sort(allFiles, Comparator.comparingLong(FileData::getSize));
        return allFiles;
    }
    public void addFile(FileData fileData) {
        String path = fileData.getPath();
        System.out.println("Файл додано за шляхом: " + path);
        if (!fileByPath.containsKey(path)) {
            System.out.println("Помилка: неможливо додати FileData. Шлях не знайдено: " + path);
            return;
        }
        add(fileData);
    }
    public void display () {
                for (String key : fileByPath.keySet())
                    System.out.println(key + " : " + fileByPath.get(key));
            }
        }





