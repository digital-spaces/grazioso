public class Monkey extends RescueAnimal {
    private static String[] monkeySpecies = {"capuchin", 
                                             "guenon", 
                                             "macaque", 
                                             "marmoset", 
                                             "squirrel monkey", 
                                             "tamarin"}; // Static variable, stores monkey species

    public static String[] getMonkeySpecies() { // Accessor for the monkey species list
        return monkeySpecies;
    }

    //& Instance variable
    private String species; //! Could also be an enum; left as string for consistency with Dog
    //! These would normally be doubles (most likely) but are strings to maintain consistency with the other data.
    private String tailLength;
    private String height;
    private String bodyLength;

    //& Monkey constructors
    // all-args constructor creates a new monkey from provided data.
    public Monkey(String name, String breed, String gender, String age,
    String weight, String acquisitionDate, String acquisitionCountry,
	String trainingStatus, boolean reserved, String inServiceCountry,
    String tailLength, String height, String bodyLength) {
        setName(name);
        setSpecies(species);
        setGender(gender);
        setAge(age);
        setWeight(weight);
        setAcquisitionDate(acquisitionDate);
        setAcquisitionLocation(acquisitionCountry);
        setTrainingStatus(trainingStatus);
        setReserved(reserved);
        setInServiceCountry(inServiceCountry);
        setTailLength(tailLength);
        setHeight(height);
        setBodyLength(bodyLength);
    }

    // no-args constructor
    public Monkey() {
        setName("name");
        setSpecies("species");
        setGender("gender");
        setAge("age");
        setWeight("weight");
        setAcquisitionDate("acquisitionDate");
        setAcquisitionLocation("acquisitionCountry");
        setTrainingStatus("trainingStatus");
        setReserved(false);
        setInServiceCountry("inServiceCountry");
        setTailLength("-1.0");
        setHeight("-1.0");
        setBodyLength("-1.0");
    }

    //& Accessor and mutator methods for monkey instance variables
    // Species
    public String getSpecies() {
        return this.species;
    }

    public void setSpecies(String monkeySpecies) {
        this.species = monkeySpecies;
    }

    // Tail length
    public String getTailLength() {
        return this.tailLength;
    }

    public void setTailLength(String monkeyTailLength) {
        this.tailLength = monkeyTailLength;
    }

    // Height
    public String getHeight() {
        return this.height;
    }

    public void setHeight(String monkeyHeight) {
        this.height = monkeyHeight;
    }
    
    // Body length
    public String getBodyLength() {
        return this.bodyLength;
    }

    public void setBodyLength(String monkeyBodyLength) {
        this.bodyLength = monkeyBodyLength;
    }
}
