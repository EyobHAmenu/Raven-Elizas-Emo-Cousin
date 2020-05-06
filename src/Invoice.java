public class Invoice {
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

    public Invoice() {
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
    /*
        Raven's Invoice
        To: Dave Wolf
        12 S. Summit Ave
        Gaithersburg, MD 20877

        Items:
        Quantity  Description    Price      Total
        1         Session        100.00     100.00
        10        Questions         .35       3.50

        Total Due: $103.50

        Thank you for doing business with Raven.
     */


    public void bill(){
        double tsp = getPSP() * getSession();
        double tqp = getPQP() * getQuestions();
        double totalDue = tsp + tqp;
        System.out.println("**************************************");
        System.out.println("Raven's Invoice");
        System.out.println("To:" + getName());
        System.out.println(getAddress());
        System.out.println(getCity() + ", " + getState() + " " + getZip() + "\n");
        //System.out.println();
        System.out.println("Items:");
        System.out.printf("%8s%15s%8s%8s", "Quantity", "Description", "Price", "Total");
        System.out.println();
        System.out.printf("%4d%20s%10.2f%10.2f", getSession(), "Session ", getPSP(),tsp);
        System.out.println();
        System.out.printf("%4d%20s%10.2f%10.2f", getQuestions(), "Questions ", getPQP(),tqp);
        System.out.println();
        System.out.println("Total Due: " + totalDue);

    }
}
