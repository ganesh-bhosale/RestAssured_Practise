package PayloadManage.POJO.Practice;

public class BookingDates {

    private String checkin;
    private String checkout;

    BookingDates(){

    }

    public String getCheckin(){
        return checkin;
    }

    public void setCheckin(String checkin){
        this.checkin = checkin;
    }

    public String getCheckout(){
        return checkout;
    }

    public void setCheckout(String checkout){
        this.checkout = checkout;
    }

}
