public class Discount_Controller {

    Services internetPayment = new Internet_service();
    Services mobileRecharge = new Mobile_recharge();
    Services donations = new Donations();
    Services landline = new Landline();

    public void createOverallDiscount(double discAmount) {
        Discount oDiscount = new Overall_Discount();
        oDiscount.setDiscount(discAmount);
    }
    public void createSpecificDiscount (double discAmount, String servName) {
        Specific_Discount sDiscount = new Specific_Discount();
        sDiscount.setService(servName);
        sDiscount.setDiscount(discAmount);
    }
    public void removeAllDiscount(){
        Overall_Discount remALlDiscount = new Overall_Discount();
        remALlDiscount.removeDiscount();
    }
    public void removeSpecificDiscount(String name){
        Specific_Discount remSpecDiscount = new Specific_Discount();
        remSpecDiscount.setService(name);
        remSpecDiscount.removeDiscount();
    }

    void returnDiscounts() {
        System.out.println("Discount Applied on Internet Payment Services: " + internetPayment.getDiscount() * 100 + "%" );
        System.out.println("Discount Applied on Mobile Recharge Services: " + mobileRecharge.getDiscount()*100 + "%");
        System.out.println("Discount Applied on Donations Services: " + donations.getDiscount()*100 + "%");
        System.out.println("Discount Applied on Landline Services: " + landline.getDiscount()*100 + "%");
    }
}
