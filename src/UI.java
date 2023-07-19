import java.util.Scanner;

public class UI {
    public void start() {
        CipherCaesar cipherCaesar = new CipherCaesar();
        BruteForceMethod bruteForceMethod = new BruteForceMethod();
        System.out.println("Выберите опцию:\n 1. Шифрование по методу Цезаря\n 2. Расшифровка по методу Цезаря\n 3. Криптоанализ методом brute force");
        try (Scanner scanner = new Scanner(System.in)) {
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    cipherCaesar.encryptFile(scrFilePath(), destFilePath(), setOffset());
                    break;
                case 2:
                    cipherCaesar.decryptFile(scrFilePath(), destFilePath(), setOffset());
                    break;
                case 3:
                    printDecryptedMessage();
                    break;
                default:
                    System.out.println("Введите цифру 1, 2 или 3.");
                    break;
            }
        } catch (Exception ex) {
            System.out.println("Введите цифру 1, 2 или 3.");
        }
    }

    public String scrFilePath() {
        System.out.println("Введите путь к файлу, из которого считываем данные.");
        Scanner scanner = new Scanner(System.in);
        String scrFilePath = scanner.nextLine();
        return scrFilePath;
    }

    public String destFilePath() {
        System.out.println("Введите путь к файлу, куда записываем данные.");
        Scanner scanner = new Scanner(System.in);
        String destFilePath = scanner.nextLine();
        return destFilePath;
    }

    public Integer setOffset() {
        System.out.println("Введите ключ(сдвиг).");
        Scanner scanner = new Scanner(System.in);
        Integer offset = scanner.nextInt();
        return offset;
    }
    public void successEncrypt(){
        System.out.println("Шифрование прошло успешно.");
    }
    public void successDecrypt(){
        System.out.println("Расшифровка прошла успешно.");
    }
    public void failedDecrypt(){
        System.out.println("Не найдено правильного решения. Расшифровка не выполнена.");
    }
    public void printDecryptedMessage() {
        BruteForceMethod bruteForceMethod = new BruteForceMethod();
            System.out.println("Правильное расшифрованное сообщение: " + bruteForceMethod.bruteForceDecrypt(scrFilePath()));
    }

}