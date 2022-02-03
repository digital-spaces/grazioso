import java.util.ArrayList;
import java.util.Arrays; // Need method.
import java.util.Scanner;

public class Driver {
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>(); //* The monkeys list

    public static void main(String[] args) {
        initializeDogList();
        initializeMonkeyList();

        // Add a loop that displays the menu, accepts the users input
        // and takes the appropriate action.
	// For the project submission you must also include input validation
        // and appropriate feedback to the user.
        // Hint: create a Scanner and pass it to the necessary
        // methods 
	// Hint: Menu options 4, 5, and 6 should all connect to the printAnimals() method.
        String[] validInputs = {"1", "2", "3", "4", "5", "6", "q"}; //* Array of valid inputs
        String input = ""; //* The input itself
        Scanner scnr = new Scanner(System.in); //* The input scanner

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
        Dog dog4 = new Dog("Vegas", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", false, "Canada");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
        dogList.add(dog4);
    }


    // Adds monkeys to a list for testing
    // Optional for testing
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


    // Complete the intakeNewDog method
    // The input validation to check that the dog is not already in the list
    // is done for you
    public static void intakeNewDog(Scanner scanner) {
        System.out.println("What is the dog's name?");
        String name = scanner.nextLine();
        for(Dog dog: dogList) {
            if(dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis dog is already in our system\n\n");
                return; //returns to menu
            }
        }

        Dog dog = new Dog(); //* Create new dog
        String str = ""; //* Placeholder string to store input
        
        //& Dog breed validation and assignment
        System.out.println("What is the dog's breed?");
        str = scanner.next();
        dog.setBreed(str);

        //& Dog gender validation and assignment
        System.out.println("What is the dog's gender?");
        str = scanner.next();
        while (!str.equals("male") && !str.equals("female")) {
            System.out.println("Enter a valid gender (male or female):");
            str = scanner.next();
        }
        dog.setGender(str);

        //& Dog age validation and assignment
        System.out.println("What is the dog's age?");
        do {
            str = scanner.next();

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
        } while(str == "invalid");
        dog.setAge(str);

        //& Dog weight validation and assignment
        System.out.println("What is the dog's weight?");
        do {
            str = scanner.next();

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
        } while(str == "invalid");
        dog.setWeight(str);

    }


    // Complete intakeNewMonkey
    //Instantiate and add the new monkey to the appropriate list
        // For the project submission you must also  validate the input
    // to make sure the monkey doesn't already exist and the species type is allowed
    public static void intakeNewMonkey(Scanner scanner) {
        System.out.println("The method intakeNewMonkey needs to be implemented");
    }

    // Complete reserveAnimal
    // You will need to find the animal by animal type and in service country
    public static void reserveAnimal(Scanner scanner) {
        System.out.println("The method reserveAnimal needs to be implemented");

    }

    //* Implemented all print print animal lists because the assignment only said I didn't HAVE TO, not that I HAD TO NOT.
    public static void printAnimals(String listType) {
        //* Takes the argument string and runs the correct list printer
        switch(listType) {
            case "dog":
                //* Loops through dog list and lists all dogs
                for (Dog dog : dogList) {
                    System.out.println(dog.getName() + ", " + dog.getTrainingStatus() + ", " + dog.getAcquisitionLocation() + ", " + dog.getReserved());
                }
                break;
            case "monkey":
                //* Loops through monkey list and lists all monkeys
                for (Monkey monkey : monkeyList) {
                    System.out.println(monkey.getName() + ", " + monkey.getTrainingStatus() + ", " + monkey.getAcquisitionLocation() + ", " + monkey.getReserved());
                }
                break;
            case "unreserved":
                //* Merges dog and monkey lists into one animal list
                ArrayList<RescueAnimal> animalList = new ArrayList<RescueAnimal>();
                animalList.addAll(dogList);
                animalList.addAll(monkeyList);

                //* Loops through animal list and lists all animals available for assignment (i.e. in service but not reserved)
                for (RescueAnimal animal : animalList) {
                    if (animal.getTrainingStatus() == "in service" && animal.getReserved() == false) {
                        System.out.println(animal.getName() + ", " + animal.getTrainingStatus() + ", " + animal.getAcquisitionLocation() + ", " + animal.getReserved());
                    }
                }
                break;
        }
    }

    //* Quit method
    public static void quitApplication(Scanner scnr) {
        System.out.println("Application quitting.");
        scnr.nextLine();
        System.exit(0);
    }
}

