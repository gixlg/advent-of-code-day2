import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ChecksumChecker {

    int getDiffernceBetweenLargestAndSmallest(ArrayList<Integer> numbers){
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for (int i=0; i<numbers.size(); i++){
            int number = numbers.get(i);
            max = Integer.max(max, number);
            min = Integer.min(min, number);
        }

        return max - min;
    }

    private int getDiffernceBetweenLargestAndSmallestFromRow(String row){
        ArrayList<Integer> numbersInARow = new ArrayList<Integer>();
        for (String number: row.split("\\s+")) {
            numbersInARow.add(Integer.parseInt(number));
        }
        return this.getDiffernceBetweenLargestAndSmallest(numbersInARow);
    }

    public int getChecksum(String path){
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String sCurrentLine;
            int checksum=0;

            while ((sCurrentLine = br.readLine()) != null) {
                checksum+=this.getDiffernceBetweenLargestAndSmallestFromRow(sCurrentLine);
            }
            return checksum;

        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }

    }
}
