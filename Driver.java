import java.util.ArrayList;
import java.util.Arrays; // Need method.
import java.util.Scanner;

public class Driver {
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>(); // The monkeys list

    public static void main(String[] args) {
        // The dog and monkey lists
        initializeDogList();
        initializeMonkeyList();

        String input = ""; // The input itself
        Scanner scnr = new Scanner(System.in); // The input scanner

        // A loop that displays the menu, accepts the users input and takes the appropriate action.
        while (true) {
            displayMenu();
            input = scnr.nextLine();

            switch(input) {
                case "1":
                    intakeNewDog(scnr);
                    break;
                case "2":
                    intakeNewMonkey(scnr);
                    break;
                case "3":
                    reserveAnimal(scnr);
                    break;
                case "4":
                    printAnimals("dog");
                    break;
                case "5":
                    printAnimals("monkey");
                    break;
                case "6":
                    printAnimals("unreserved");
                    break;
                case "q":
                    quitApplication(scnr);
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    // This method prints the menu options
    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection");
    }


    // Adds dogs to a list for testing
    public static void initializeDogList() {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake", false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false, "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", true, "Canada");
        Dog dog4 = new Dog("Vegas", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", false, "Canada"); // Added for testing

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
        dogList.add(dog4);
    }

    // Adds monkeys to a list for testing
    public static void initializeMonkeyList() {
        Monkey monkey1 = new Monkey("TB", "Capuchin", "female", "2", "25.6", "04-30-2022", "Nigeria", "intake", false, "United States", "1.6", "26.7", "24");
        Monkey monkey2 = new Monkey("Mike", "Macaque", "male", "6", "35.2", "12-23-2021", "Nigeria", "Phase I", false, "United States", "2.7", "37.5", "35");
        Monkey monkey3 = new Monkey("Brandon", "Squirrel monkey", "male", "8", "25.6", "11-16-2020", "South Africa", "in service", true, "Canada", "3.8", "45.8", "43");
        Monkey monkey4 = new Monkey("Cake", "Squirrel monkey", "female", "8", "25.6", "11-16-2020", "South Africa", "in service", false, "Canada", "3.8", "45.8", "43");

        monkeyList.add(monkey1);
        monkeyList.add(monkey2);
        monkeyList.add(monkey3);
        monkeyList.add(monkey4);
    }


    // intakeNewDog method
    public static void intakeNewDog(Scanner scanner) {
        System.out.println("What is the dog's name?");
        String name = scanner.nextLine();
        for(Dog dog: dogList) {
            if(dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis dog is already in our system\n\n");
                return; //returns to menu
            }
        }

        // Add the code to instantiate a new dog and add it to the appropriate list
    }

    // intakeNewMonkey method prompts user for input, sets data for attributes and adds
    // new monkey to monkeyList.
    public static void intakeNewMonkey(Scanner scanner) {
        String str = ""; // String used for all input

        // Validate and/or assign the monkey name (check if it exists)
        System.out.println("What is the monkey's name?");
        str = scanner.nextLine(); // String used for all input
        for(Monkey m : monkeyList) {
            if(m.getName().equalsIgnoreCase(str)) {
                System.out.println("\n\nThis monkey is already in our system\n\n");
                return; //returns to menu
            }
        }
        Monkey monkey = new Monkey(); // Empty monkey
        monkey.setName(str);

        // Validate and assign the monkey species against the allowed species list
        System.out.println("What is the monkey's species?");
        do {
            // List species
            for (String s : Monkey.getMonkeySpecies()) {
                System.out.println(s);
            }
            System.out.println("");

            // Get new line
            str = scanner.nextLine();
            if (!Arrays.asList(Monkey.getMonkeySpecies()).contains(str.toLowerCase())) {
                System.out.println("Enter a valid species:");
                str = "invalid"; // Set loop condition
            }
        } while(str.equals("invalid"));
        monkey.setSpecies(str);

        // Validate and assign the monkey gender
        System.out.println("What is the monkey's gender?");
        str = scanner.nextLine();
        while (!str.toLowerCase().equals("male") && !str.toLowerCase().equals("female")) {
            System.out.println("Enter a valid gender (male or female):");
            str = scanner.nextLine();
        }
        monkey.setGender(str);

        // Validate and assign the monkey age
        System.out.println("What is the monkey's age?");
        do {
            str = scanner.nextLine();

            try {
                if (Integer.valueOf(str) < 1) {
                    System.out.println("Enter a valid age (above 0):");
                    str = "invalid";
                }
            }
            catch (NumberFormatException ex) {
                System.out.println("Enter a number for the age:");
                str = "invalid";
            }
        } while(str.equals("invalid"));
        monkey.setAge(str);

        // Validate and assign the monkey weight
        System.out.println("What is the monkey's weight?");
        do {
            str = scanner.nextLine();

            try {
                if (Double.valueOf(str) < 1.0) {
                    System.out.println("Enter a valid weight (above 0):");
                    str = "invalid";
                }
            }
            catch (NumberFormatException ex) {
                System.out.println("Enter a number for the weight:");
                str = "invalid";
            }
        } while(str.equals("invalid"));
        monkey.setWeight(str);

        // Validate and assign the monkey tail length
        System.out.println("What is the monkey's tail length?");
        do {
            str = scanner.nextLine();

            try {
                if (Double.valueOf(str) < 1.0) {
                    System.out.println("Enter a valid tail length (above 0):");
                    str = "invalid";
                }
            }
            catch (NumberFormatException ex) {
                System.out.println("Enter a number for the tail length:");
                str = "invalid";
            }
        } while(str.equals("invalid"));
        monkey.setTailLength(str);

        // Validate and assign the monkey height
        System.out.println("What is the monkey's height?");
        do {
            str = scanner.nextLine();

            try {
                if (Double.valueOf(str) < 1.0) {
                    System.out.println("Enter a valid height (above 0):");
                    str = "invalid";
                }
            }
            catch (NumberFormatException ex) {
                System.out.println("Enter a number for the height:");
                str = "invalid";
            }
        } while(str.equals("invalid"));
        monkey.setHeight(str);

        // Validate and assign the monkey body length
        System.out.println("What is the monkey's body length?");
        do {
            str = scanner.nextLine();

            try {
                if (Double.valueOf(str) < 1.0) {
                    System.out.println("Enter a valid body length (above 0):");
                    str = "invalid";
                }
            }
            catch (NumberFormatException ex) {
                System.out.println("Enter a number for the body length:");
                str = "invalid";
            }
        } while(str.equals("invalid"));
        monkey.setBodyLength(str);

        // Assign the monkey acquisition date
        System.out.println("What is the monkey's acquisition date?");
        do {
            str = scanner.nextLine();
            if (str.equals("")) {
                System.out.println("Enter a date:");
            }
        } while(str.equals(""));
        monkey.setAcquisitionDate(str);

        // Assign the monkey acquisition location
        System.out.println("What is the monkey's acquisition location?");
        do {
            str = scanner.nextLine();
            if (str.equals("")) {
                System.out.println("Enter a location:");
            }
        } while(str.equals(""));
        monkey.setAcquisitionLocation(str);

        // Validate and assign the monkey training status
        System.out.println("What is the monkey's training status?");
        String[] statuses = {"intake", "phase i", "Phase ii", "Phase iii", "Phase iv", "Phase v", "in service", "farm"};
        do {
            // List status
            System.out.println("intake");
            System.out.println("Phase I");
            System.out.println("Phase II");
            System.out.println("Phase III");
            System.out.println("Phase IV");
            System.out.println("Phase V");
            System.out.println("in service");
            System.out.println("farm");
            System.out.println("");

            // Get new line
            str = scanner.nextLine();
            if (!Arrays.asList(statuses).contains(str.toLowerCase())) {
                System.out.println("Enter a valid status:");
                str = "invalid"; // Set loop condition
            }
        } while(str.equals("invalid"));
        monkey.setTrainingStatus(str);

        // Assign the monkey in service country
        //! The specs indicate that animal intake tracks the training status of dogs.
        //! It then states that the in service country is recorded when a dog is in service.
        //! As such, I am only getting input for the in service country when training status
        //! is in service. Otherwise, it is the acquisition country.
        if (monkey.getTrainingStatus().equals("in service")) {
            System.out.println("What is the monkey's in service country?");
            do {
                str = scanner.nextLine();
                if (str.equals("")) {
                    System.out.println("Enter a country:");
                }
            } while(str.equals(""));
            monkey.setInServiceCountry(str);
        }
        else {
            monkey.setInServiceCountry(monkey.getAcquisitionLocation());
        }

        // Assign the monkey in service country
        //! The specs indicate that animal intake tracks the training status of dogs.
        //! It then states that the reservation is recorded when a dog is in service.
        //! As such, I am only getting input for the reservation status when training status
        //! is in service. Otherwise, it stays the default (false).
        if (monkey.getTrainingStatus().equals("in service")) {
            System.out.println("What is the monkey's reservation status (true/false)?");
            str = scanner.nextLine();
            while (!str.toLowerCase().equals("true") && !str.toLowerCase().equals("false")) {
                System.out.println("Enter a valid reservation status (true/false):");
                str = scanner.nextLine();
            }
            if (str.toLowerCase().equals("true")) {
                monkey.setReserved(true);
            } // else nothing happens and it remains the default of false
        }

        monkeyList.add(monkey);
    }

    // reserveAnimal method, finds the animal by animal type and in service country.
    public static void reserveAnimal(Scanner scanner) {
        System.out.println("The method reserveAnimal needs to be implemented");

    }

    // Implements the print animals method
    public static void printAnimals(String listType) {
        // Takes the argument string and runs the correct list printer
        switch(listType) {
            case "dog":
                // Loops through dog list and lists all dogs
                System.out.println("The dog list needs to be implemented");
                break;
            case "monkey":
                // Loops through monkey list and lists all monkeys
                System.out.println("The monkey list needs to be implemented");
                break;
            case "unreserved":
                // Merges dog and monkey lists into one animal list
                ArrayList<RescueAnimal> animalList = new ArrayList<RescueAnimal>();
                animalList.addAll(dogList);
                animalList.addAll(monkeyList);

                // Loops through animal list and lists all animals available for assignment (i.e. in service but not reserved)
                for (RescueAnimal animal : animalList) {
                    if (animal.getTrainingStatus().equals("in service") && animal.getReserved() == false) {
                        System.out.println(animal.getName() + ", " + animal.getTrainingStatus() + ", " + animal.getAcquisitionLocation() + ", " + animal.getReserved());
                    }
                }
                break;
        }
    }

    // Quit method, because one didn't exist before and this program needs a way to exit.
    public static void quitApplication(Scanner scnr) {
        System.out.println("Application quitting. Press enter to exit.");
        scnr.nextLine(); // Pause the screen
        System.exit(0);
    }
}
