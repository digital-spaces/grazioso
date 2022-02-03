public class Monkey extends RescueAnimal {
    // Instance variable
    private String species;
    private String tailLength;
    private String height;
    private String bodyLength;

    // Monkey constructor creates a new monkey from provided data.
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

    // Accessor Method
    public String getSpecies() {
        return this.species;
    }

    // Mutator Method
    public void setSpecies(String monkeySpecies) {
        this.species = monkeySpecies;
    }

    // Accessor Method
    public String getTailLength() {
        return this.tailLength;
    }

    // Mutator Method
    public void setTailLength(String monkeyTailLength) {
        this.tailLength = monkeyTailLength;
    }

    // Accessor Method
    public String getHeight() {
        return this.height;
    }

    // Mutator Method
    public void setHeight(String monkeyHeight) {
        this.height = monkeyHeight;
    }
    
    // Accessor Method
    public String getBodyLength() {
        return this.bodyLength;
    }

    // Mutator Method
    public void setBodyLength(String monkeyBodyLength) {
        this.bodyLength = monkeyBodyLength;
    }
}
