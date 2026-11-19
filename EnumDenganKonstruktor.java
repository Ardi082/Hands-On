enum AccountType {
    SAVINGS("SA", 2.5),
    CREDIT("CR", 12.0);

    private String code;
    private double interestRate;

    private AccountType(String code, double interestRate) {
        this.code = code;
        this.interestRate = interestRate;
    }

    public String getCode() {
        return code;
    }

    public double getInterestRate() {
        return interestRate;
    }
}

public class EnumDenganKonstruktor {

    public static void main(String[] args) {

        for (AccountType account : AccountType.values()) {

            System.out.println("Nama Akun: " + account.name());
            System.out.println("Kode: " + account.getCode());
            System.out.println("Suku Bunga: " + account.getInterestRate() + "%");
            System.out.println("-----------------------------");
        }
    }
}