import java.time.LocalDateTime;
import java.util.*;

public class EventTester {

    public static Deadline[] addDeadline(Deadline[] arr, Deadline d) {
        Deadline[] newArr = new Deadline[arr.length + 1];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        newArr[arr.length] = d;
        return newArr;
    }

    public static Meeting[] addMeeting(Meeting[] arr, Meeting m) {
        Meeting[] newArr = new Meeting[arr.length + 1];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        newArr[arr.length] = m;
        return newArr;
    }

    public static Deadline[] removeDeadline(Deadline[] arr, Deadline d) {
        Deadline[] newArr = new Deadline[arr.length - 1];
        int c = 0;
        for(Deadline deadline : arr) {
            if(deadline != d) {
                newArr[c] = deadline;
                c++;
            }
        }
        return newArr;
    }

    public static Meeting[] removeMeeting(Meeting[] arr, Meeting m) {
        Meeting[] newArr = new Meeting[arr.length - 1];
        int c = 0;
        for(Meeting meeting : arr) {
            if(meeting != m) {
                newArr[c] = meeting;
                c++;
            }
        }
        return newArr;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Deadline[] deadlines = new Deadline[0];
        Meeting[] meetings = new Meeting[0];
        Deadline dl;
        Meeting mt;
        LocalDateTime date1;
        LocalDateTime date2;
        int inputi;
        String inputs;
        boolean again = true;

        while(again) {

            for(Deadline d : deadlines) {
                if(d.isComplete()) {
                    deadlines = removeDeadline(deadlines, d);
                }
            }
            for(Meeting m : meetings) {
                if(m.isComplete()) {
                    meetings = removeMeeting(meetings, m);
                }
            }

            System.out.println("What would you like to do?");
            System.out.println("\t(1) Add deadline");
            System.out.println("\t(2) Add meeting");
            System.out.println("\t(3) Mark deadline complete");
            System.out.println("\t(4) Mark meeting complete");
            System.out.println("\t(5) See active events");
            System.out.println("\t(6) Exit program\n");

            inputi = scan.nextInt();
            if(scan.hasNextLine()) {
                scan.nextLine();
            }
            switch(inputi) {
                case 1:
                    System.out.println("Enter deadline name:");
                    inputs = scan.nextLine();
                    System.out.println("Enter deadline as \"yyyy-mm-ddThh:mm:ss\":");
                    date1 = LocalDateTime.parse(scan.nextLine());
                    dl = new Deadline(inputs, date1);
                    deadlines = addDeadline(deadlines, dl);
                    break;
                case 2:
                    System.out.println("Enter meeting name:");
                    inputs = scan.nextLine();
                    System.out.println("Enter start of meeting as \"yyyy-mm-ddThh:mm:ss\":");
                    date1 = LocalDateTime.parse(scan.nextLine());
                    System.out.println("Enter end of meeting as \"yyyy-mm-ddThh:mm:ss\":");
                    date2 = LocalDateTime.parse(scan.nextLine());
                    System.out.println("Enter meeting location:");
                    mt = new Meeting(inputs, date1, date2, scan.nextLine());
                    meetings = addMeeting(meetings, mt);
                    break;
                case 3:
                    System.out.println("Which deadline would you like to mark complete?");
                    inputs = scan.nextLine();
                    if(true) {
                        boolean found = false;
                        for (Deadline d : deadlines) {
                            if (d.getName().equals(inputs)) {
                                d.complete();
                                found = true;
                            }
                        }
                        if (found) {
                            System.out.println("Task marked complete!");
                        } else {
                            System.out.println("Please enter a valid deadline");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Which meeting would you like to mark complete?");
                    inputs = scan.nextLine();
                    if(true) {
                        boolean found = false;
                        for (Meeting m : meetings) {
                            if (m.getName().equals(inputs)) {
                                m.complete();
                                found = true;
                            }
                        }
                        if (found) {
                            System.out.println("Task marked complete!");
                        } else {
                            System.out.println("Please enter a valid deadline");
                        }
                    }
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Active meetings:");
                    for(Meeting m : meetings) {
                        System.out.print("\t* " + m.getName() + " - ");
                        System.out.print("starts " + m.getDateTime().toString() + " | ");
                        System.out.print("ends " + m.getEndTime().toString() + " | ");
                        System.out.println("at " + m.getLocation());
                    }
                    System.out.println("Active deadlines:");
                    for(Deadline d : deadlines) {
                        System.out.print("\t* " + d.getName() + " - ");
                        System.out.println("due " + d.getDateTime().toString());
                    }
                    break;
                case 6:
                    System.out.println("Are you sure you want to exit? (y/n)");
                    inputs = scan.nextLine();
                    if(inputs.equals("y") || inputs.equals("Y")) {
                        again = false;
                    }
                    break;
                default:
                    System.out.println("Please enter a valid option");
            }
            System.out.println();
        }
    }
}