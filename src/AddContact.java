import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Scanner;

public class AddContact {
    public static void addContacts(){
        String directory = "data";
        String file = "contact.txt";
        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, file);
        Long contactNumber = 0L;
        String nickName = NameGenerator.nickNameGenerator();

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the name of the new contact name");
        String contactName = input.nextLine();
        System.out.println("Please enter the 10 digit number of the new contact");
        try {
            contactNumber = input.nextLong();
        }catch(Exception e){
            System.out.println("Please enter a valid number");
            e.fillInStackTrace();
            addContacts();
        }

        try {

            String formatContact = String.format("%s%-24s |%-28s", contactName, nickName,
                    contactNumber);
            System.out.println(formatContact);
            Files.write(dataFile,
                    Arrays.asList( formatContact),
                    StandardOpenOption.APPEND);
        }catch (Exception e){
            e.fillInStackTrace();
        }
    }
}
