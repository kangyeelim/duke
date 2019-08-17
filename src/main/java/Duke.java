import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        String greeting = "Hello! I'm Duke\n"
                + "What can I do for you?\n";
        System.out.println(greeting);
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();
        String[] tasks = new String[100];
        int index = 0;
        while (!command.equals("bye")) {
            if (!command.equals("list")) {
                tasks[index] = command;
                index++;
                String commandMsg = "added: " + command + "\n";
                System.out.println(commandMsg);
            }
            command = sc.nextLine();
        }

        String exitMsg = "Bye. Hope to see you again soon!\n";
        System.out.println(exitMsg);
    }
}
