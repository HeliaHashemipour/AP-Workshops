package ceit.utils;

import ceit.model.Note;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class FileUtils {

    private static final String NOTES_PATH = "./notes/";

    //It's a static initializer. It's executed when the class is loaded.
    //It's similar to constructor
    static {
        boolean isSuccessful = new File(NOTES_PATH).mkdirs();
        System.out.println("Creating " + NOTES_PATH + " directory is successful: " + isSuccessful);
    }

    public static File[] getFilesInDirectory() {
        return new File(NOTES_PATH).listFiles();
    }

    /**
     * read file with bufferedReader
     * @param file file to read
     * @return string of content
     */
    public static String fileReader(File file) {//add
        StringBuilder str = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(file))){
            char[] buffer = new char[1024];
            int count;
            while ((count = in.read(buffer)) != -1) {
                str.append(buffer, 0, count);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return str.toString();
    }

    /**
     * Write on a file with bufferedWriter
     * @param content content to write on file
     */
    public static void fileWriter(String content) {//add
        String fileName = getProperFileName(content);
        try (BufferedWriter out = new BufferedWriter(new FileWriter("./notes/"+ fileName + ".txt"))) {
            out.write(content);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Read file with FileInputStream
     * @param file file to read
     * @return string of content
     */
    public static String reader(File file) {//add
        StringBuilder str = new StringBuilder();
        try (FileInputStream in = new FileInputStream(file)) {
            Scanner input = new Scanner(in);
            while (input.hasNext()) {
                str.append(input.nextLine());
                str.append("\n");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return str.toString();
    }
    /**
     * Write on a file with FileOutputStream
     * @param content content to write on file
     */
    public static void writer(String content) {//add
        String fileName = getProperFileName(content);
        try (FileOutputStream out = new FileOutputStream("./notes/"+ fileName + ".txt")) {
            PrintStream writer = new PrintStream(out);
            writer.print(content);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Serialized object
     * @param file file to read from
     * @return string of content
     * @throws IOException exception
     * @throws ClassNotFoundException exception
     */
    public static String readFromFile(File file) throws IOException, ClassNotFoundException{//add
        FileInputStream inputStream = new FileInputStream(file);
        ObjectInputStream in = new ObjectInputStream(inputStream);
        Note note = (Note) in.readObject();
        inputStream.close();
        in.close();
        return note.toString();
    }

    /**
     * Deserialize object
     * @param content content
     */
    public static void writeToFile(String content) {//add
        String title = getProperFileName(content);
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
        Date date = new Date();
        Note note = new Note(title,content,formatter.format(date));
        String fileAddress = "./notes/" + title + " " + formatter.format(date) + ".ser";
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileAddress))) {
            out.writeObject(note);
            System.out.println("Done");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * get proper name for each file
     * @param content file content
     * @return file name
     */
    private static String getProperFileName(String content) {
        int loc = content.indexOf("\n");
        if (loc != -1) {
            return content.substring(0, loc);
        }
        if (!content.isEmpty()) {
            return content;
        }
        return System.currentTimeMillis() + "_new file.txt";
    }
}
