public class Main {

    public static void main(String[] args) {
        ChecksumChecker checksumChecker = new ChecksumChecker();
        int checksum = checksumChecker.getChecksum("puzzleInput.txt");
        System.out.println("The output is: "+ checksum);
    }
}
