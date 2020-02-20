public class Prospect {
    private String name;
    private double total;
    private double loan;
    private float interest;
    private float years;
    private double monthlypay;
    private int payments;


    public int getPayments() {
        return payments;
    }

    public void setPayments() {
        this.payments = (int) (this.years * 12 );
    }


    public Prospect(String name, double total ,float interest, float years) {
        this.name = name;
        this.total = total;
        this.interest = interest/100;
        this.years = years;
        setPayments();
        calculateMonthlyPay();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getLoan() {
        return loan;
    }

    public void setLoan(double loan) {
        this.loan = loan;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public float getYears() {
        return years;
    }

    public void setYears(float years) {
        this.years = years;
    }

    public double getMonthlypay() {
        return monthlypay;
    }

    public void calculateMonthlyPay() {

        this.monthlypay = total * interest * powerof(1+interest,payments)/(powerof(1+interest,payments)-1);

    }

    private float powerof(float base, int exponent) {
        float n=1;

        while(exponent != 0){
            n *= base;
            --exponent;
        }


        return n;

    }

}
