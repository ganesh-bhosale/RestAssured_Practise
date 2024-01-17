package PayloadManage.POJO.JSONObject;

import PayloadManage.POJO.Practice.BookingDates;

public class Employee {

    private String firstname;
    private String lastname;
    private Integer totatprice;
    private Boolean depositpaid;
    private BookingDates bookingDates;
    private String additionalneeds;

    Employee(){
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getTotatprice() {
        return totatprice;
    }

    public void setTotatprice(Integer totatprice) {
        this.totatprice = totatprice;
    }

    public Boolean getDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(Boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public BookingDates getBookingDates() {
        return bookingDates;
    }

    public void setBookingDates(BookingDates bookingDates) {
        this.bookingDates = bookingDates;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }
}
