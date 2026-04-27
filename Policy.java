public class Policy
{
   private String policyNumber;
   private String providerName;
   private PolicyHolder policyHolder;

   // static counter
   private static int policyCount = 0;

   public Policy()
   {
      policyNumber = "";
      providerName = "";
      policyHolder = new PolicyHolder();
      policyCount++;
   }

   public Policy(String pNumber, String pName, PolicyHolder holder)
   {
      policyNumber = pNumber;
      providerName = pName;

      // defense
      policyHolder = new PolicyHolder(holder);

      policyCount++;
   }

   // Getters
   public String getPolicyNumber() { return policyNumber; }
   public String getProviderName() { return providerName; }

   // (security)
   public PolicyHolder getPolicyHolder()
   {
      return new PolicyHolder(policyHolder);
   }

   // Static getter
   public static int getPolicyCount()
   {
      return policyCount;
   }

   public double getPrice()
   {
      final double BASE_PRICE = 600;
      final double ADDITIONAL_FEE_AGE = 75;
      final double ADDITIONAL_FEE_SMOKING = 100;
      final double ADDITIONAL_FEE_PER_BMI = 20;

      final int AGE_THRESHOLD = 50;
      final int BMI_THRESHOLD = 35;

      double price = BASE_PRICE;

      if (policyHolder.getAge() > AGE_THRESHOLD)
         price += ADDITIONAL_FEE_AGE;

      if (policyHolder.getSmokingStatus().equalsIgnoreCase("smoker"))
         price += ADDITIONAL_FEE_SMOKING;

      if (policyHolder.getBMI() > BMI_THRESHOLD)
         price += ((policyHolder.getBMI() - BMI_THRESHOLD) * ADDITIONAL_FEE_PER_BMI);

      return price;
   }

   // toString method
   public String toString()
   {
      return "Policy Number: " + policyNumber + "\n" +
             "Provider Name: " + providerName + "\n" +
             policyHolder.toString() +
             String.format("Policy Price: $%.2f\n", getPrice());
   }
}
