public class Person {
    /*
        An Invoice shall contain the name, address and contact information
        of the user, a list of items to charge for as shown below.

     */
    private String name;
    private String address;
    private String city;
    private String state;
    private int zip;
    private int questions;
    private int session;
    final private double PSP = 100;
    final private double PQP = 0.35;

    public Person() {
        this.questions = 0;
        this.session = 0;
    }

    public String getName() {
        return name;
    }

    public int getQuestions() {
        return questions;
    }

    public void setQuestions(int questions) {
        this.questions = questions + 1;
    }

    public int getSession() {
        return session;
    }

    public void setSession(int session) {
        this.session = session + 1;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public double getPSP() {
        return PSP;
    }

    public double getPQP() {
        return PQP;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public void bill(){
        double tsp = getPSP() * getSession();
        double tqp = getPQP() * getQuestions();
        double totalDue = tsp + tqp;
        System.out.println("*****************Receipt*********************");
        System.out.println("Raven's Invoice");
        System.out.println("To:" + getName());
        System.out.println(getAddress());
        System.out.println(getCity() + ", " + getState() + " " + getZip() + "\n");
        System.out.println("Items:");
        System.out.printf("%8s%15s%8s%8s", "Quantity", "Description", "Price", "Total");
        System.out.println();
        System.out.printf("%4d%20s%10.2f%10.2f", getSession(), "Session ", getPSP(),tsp);
        System.out.println();
        System.out.printf("%4d%20s%10.2f%10.2f", getQuestions(), "Questions ", getPQP(),tqp);
        System.out.println();
        System.out.println("Total Due: " + totalDue);
    }
    public int positiveCounter(String [] arr){
        String [] positive = {"good", "glad", "happy", "relaxed", "accomplished", "alert", "creative"};
        int positiveWords = 0;
        for(String x : arr){
            for(String p : positive){
                if(x.equalsIgnoreCase(p)){
                    positiveWords++;
                }
            }
        }
        return positiveWords;
    }

    public int negativeCounter(String [] arr){
        String [] negative = {"bad", "sad", "tired", "angry", "anxious", "hungry", "moody", "afraid"};
        int negativeWords = 0;
        for(String x : arr){
            for(String n : negative){
                if(x.equalsIgnoreCase(n)){
                    negativeWords++;
                }
            }
        }
        return negativeWords;
    }
}
