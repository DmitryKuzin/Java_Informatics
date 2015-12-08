import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Gataullin Kamil
 * 23.09.2014 20:04
 */
public class NIOStream {

    public static void main(String[] args) {
        Path path=Paths.get("./data");
        Path dest=Paths.get("./data2");
        copyFileTree();

        try {
//            infoAboutFile();
//            testFiles();
            readString();
//            readFromChannel();
//            writeToChannel("Привет!");
//            walkFileTree();
            watcher();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void infoAboutFile() {
        // Cоздание объекта Path через вызов статического метода get() класса Paths
        Path testFilePath = Paths.get("C:\\test\\testfile.txt");

        //Вывод инормации о файле
        System.out.println("Printing file information: ");
        System.out.println("\t file name: " + testFilePath.getFileName());
        System.out.println("\t root of the path: " + testFilePath.getRoot());
        System.out.println("\t parent of the target: " + testFilePath.getParent());

        //Вывод элементов пути
        System.out.println("Printing elements of the path: ");
        for (Path element : testFilePath) {
            System.out.println("\t path element: " + element);
        }
    }

    private static void testFiles() throws IOException {
        Path path = Paths.get("./testText.txt");
        Path pathData = Paths.get("./testData.dat");

        // Сравнение файлов
        System.out.println("Files.isSameFile(path1, path2) is: "
                + Files.isSameFile(path, pathData));

        // Проверка на существование
        if (Files.exists(path, LinkOption.NOFOLLOW_LINKS)) {
            System.out.println("The file/directory " + path.getFileName() + " exists");
            if (Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS)) {
                System.out.println(path.getFileName() + " is a directory");
            } else {
                System.out.println(path.getFileName() + " is a file");
            }
        } else {
            System.out.println("The file/directory " + path.getFileName() + " does not exist");
        }

        // Проверка возможности чтения и записи
        System.out.printf("Readable: %b, Writable: %b\n", Files.isReadable(path), Files.isWritable(path));

        // Метод getAttribute() позволяет получить свойства (атрибуты) файла
        Object object = Files.getAttribute(path, "creationTime");
        System.out.println("Creation time: " + object);

        object = Files.getAttribute(path, "lastModifiedTime", LinkOption.NOFOLLOW_LINKS);
        System.out.println("Last modified time: " + object);

        object = Files.getAttribute(path, "size");
        System.out.println("Size: " + object);

        object = Files.getAttribute(path, "isDirectory");
        System.out.println("isDirectory: " + object);

        // Копирование файла
        Files.copy(path, Paths.get("./testText2.txt")); // StandardCopyOption.REPLACE_EXISTING
        // при копировании директории не будут копироваться содержащиеся в ней файлы и директории
        // java.nio.file.FileAlreadyExistsException

        // Перемещение файла
        Files.move(path, Paths.get("./testMove.txt"), StandardCopyOption.REPLACE_EXISTING);
//        перемещается и всё содержимое

        // Удаление файла
        Files.delete(Paths.get("./testText3.txt")); // deleteIfExists()
        // java.nio.file.DirectoryNotEmptyException
    }

    private static void walkFileTree() {
        Path pathSource = Paths.get("./data");
        try {
            Files.walkFileTree(pathSource, new MyFileVisitor());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copyFileTree(Path src,Path dest) {

        try {
            Files.walkFileTree(pathSource, new MyFileVisitor());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // 1. Напишите свой Visitor для полного копирования папки
    // используйте destination.resolve(source.relativize(path))
    // где source - откуда копируем
    // destination - куда копируем
    // path - текущее местоположение

    // 2. Напишите свой Visitor для поиска всех HTML страниц в папке data

    private static void readString() throws IOException {    // работает начиная с Java 7 (Path, Paths, and Files)
        Path path = Paths.get("./testText.txt");   // получаем файл

//        или вот так, что тоже самое!
//        File file = new File("./testText.txt");
//        Path path = file.toPath();
        List<String> rows = Files.readAllLines(path, StandardCharsets.UTF_8);
        for (String row : rows) {
            System.out.println(row);
        }
    }

    private static void readFromChannel() {
        int count;
        // Здесь канал открывается по пути, возвращаемому
        // методом Paths.get() в виде объекта типа Path.
        try (SeekableByteChannel fChan = Files.newByteChannel(Paths.get("testText.txt"))) {
            // выделить память под буфер
            ByteBuffer mBuf = ByteBuffer.allocate(128);

            do { // читать данные из файла в буфер
                count = fChan.read(mBuf);
                // прекратить чтение по достижении конца файла
                if (count != -1) {
                    // подготовить буфер к чтению из него данных
                    mBuf.rewind();
                    // читать байты данных из буфера и
                    // выводить их на экран как символы
                    for (int i = 0; i < count; i++)
                        System.out.print((char) mBuf.get());
                }
            } while (count != -1);
            System.out.println();
        } catch (InvalidPathException e) {
            System.out.println("Ошибка указания пути " + e);
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода " + e);
        }
    }

    private static void writeToChannel(String str) {
        // получить канал к файлу в блоке оператора try с ресурсами
        try (FileChannel fChan = (FileChannel)
                Files.newByteChannel(Paths.get("testtt.txt"),
                        StandardOpenOption.WRITE,
                        StandardOpenOption.CREATE)) {
            // создать буфер
            ByteBuffer mBuf = ByteBuffer.allocate(26);
            // записать некоторое количество байтов в буфер
            if (str == null) {
                for (int i = 0; i < 26; i++)
                    mBuf.put((byte) ('A' + i));
            } else {
                mBuf.put(str.getBytes());
            }
            // подготовить буфер к записи данных
            mBuf.rewind();
            // записать данные из буфера в выходной файл
            fChan.write(mBuf);
        } catch (InvalidPathException e) {
            System.out.println("Ошибка указания пути " + e);
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e);
            System.exit(1);
        }
    }

    private static void watcher() {
        Path path = Paths.get("./data");
        WatchService watchService = null;
        try {
            watchService = path.getFileSystem().newWatchService();
            path.register(watchService,
                    StandardWatchEventKinds.ENTRY_CREATE,
                    StandardWatchEventKinds.ENTRY_DELETE,
                    StandardWatchEventKinds.ENTRY_MODIFY);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        // Бесконечный цикл
        for (;;) {
            WatchKey key = null;
            try {
                key = watchService.take();
//                key = watchService.poll(10L, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Итерации для каждого события
            for (WatchEvent event : key.pollEvents()) {
                switch (event.kind().name()) {
                    case "OVERFLOW":
                        System.out.println("We lost some events");
                        break;
                    case "ENTRY_CREATE":
                        System.out.println("File " + event.context() + " is created!");
                        break;
                    case "ENTRY_MODIFY":
                        System.out.println("File " + event.context() + " is modified!");
                        break;
                    case "ENTRY_DELETE":
                        System.out.println("File " + event.context() + " is deleted!");
                        break;
                }
            }
            // Сброс ключа важен для получения последующих уведомлений
            key.reset();
        }
    }

    // 3. Переделайте этот Watcher чтобы он отслеживал все дочерние элементы папки
    
}
