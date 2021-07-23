import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class SortedDToretto {

    private File fileIn;
    private File fileOut;

    private List<Integer> inputList;
    private List<Integer> filteredList;
    private List<Integer> newFiltered;

    public SortedDToretto() {
        inputList = new ArrayList<>();
        filteredList = new ArrayList<>();
        newFiltered = new ArrayList<>();
    }

    public static void main(String[] args) {

        SortedDToretto filtered = new SortedDToretto();
        String pathIn = "src/main/resources/input.txt";
        String pathOut = "src/main/resources/output.txt";


        filtered.setFileIn(new File(pathIn).getAbsoluteFile());
        filtered.setFileOut(new File(pathOut).getAbsoluteFile());
        filtered.readFile();

        filtered.filter();
        filtered.roadToSqr();
        filtered.sortedList();
        filtered.outputList();

    }

    public void setFileIn(File fileIn) {
        this.fileIn = fileIn;
    }

    public void setFileOut(File fileOut) {
        this.fileOut = fileOut;
    }

    public void readFile() {
        try (Scanner in = new Scanner(fileIn)) {
            while (in.hasNextLine()) {
                int num = in.nextInt();
                this.inputList.add(num);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.fillInStackTrace());
        }
    }


    public void filter() {
        int size = inputList.size();

        //this.filteredList = inputList.stream().filter(integer -> integer % 2 == 0).collect(Collectors.toList());

        for (int i = 0; i < size; i++) {
            if (inputList.get(i) % 2 == 0 && inputList.get(i) != 0) {
                this.filteredList.add(inputList.get(i));
            }
        }
    }

    public void setInputList(List<Integer> inputList) {
        this.inputList = inputList;
    }

    public void roadToSqr() {
        int size = filteredList.size();
        for (int i = 0; i < size; i++) {
            this.newFiltered.add(filteredList.get(i) * filteredList.get(i));
        }
    }

    public void sortedList() {
        Collections.sort(newFiltered);
    }

    public void outputList() {
        try (FileWriter out = new FileWriter(fileOut)) {
            int size = newFiltered.size();
            for (int i = 0; i < size; i++) {
                out.write(newFiltered.get(i) + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
