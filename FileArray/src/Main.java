import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Main {

    private static final int FILE_SIZE = 32;

    public static void main(String[] args) throws IOException {

        if(args.length == 0){
            System.out.println("Filename is missing, please follow the protocol!");
            System.out.println("PROTOCOL: java Main <filename> <operations>\n");
            return;
        }
        if (args.length == 1){
            System.out.println("You missed some arguments, please follow the protocol!");
            System.out.println("PROTOCOL: java Main <filename> <operations>\n");
        }

        File file = new File(args[0]);
        FileArray fileArray;
        
        if(file.exists()){
            fileArray = new FileArray(file);
        }
        else{
            fileArray = new FileArray(file, randomInt());
        }

        for(int i=1; i<args.length; i++){
            switch(args[i]){
                case "p":
                    fileArray.print();
                    break;

                case "i":
                    fileArray.incrementAll();
                    System.out.println("Values incremented\n");
                    break;

                default:
                    System.out.println("'" + args[i] + "' is an invalid operation!\n");
            }
        }
    }

    private static int randomInt(){
        Random random = new Random();
        return random.nextInt(FILE_SIZE)+1;
    }
}
