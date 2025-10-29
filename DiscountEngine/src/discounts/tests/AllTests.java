package discounts.tests;

public class AllTests {
    public static void main(String[] args) {
        System.out.println("Running all discount tests at the same time: ");
        BuyXgetYFreeTest.main(new String[]{});
        OrderByValueTest.main(new String[]{});
        ApplyComboDiscountTest.main(new String[]{});
        System.out.println("All tests completed.");
    }
}


