/**
 * @author Helia Sadat Hashemipour
 * @version 2020.10.23
 */
public class Music {
    private String Address;
    private String name;
    private String publishYear;
    public Music(String Address,String name,String publishYear){
        this.Address=Address;
        this.name=name;
        this.publishYear=publishYear;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return Address;
    }

    public String getPublishYear() {
        return publishYear;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void setPublishYear(String publishYear) {
        this.publishYear = publishYear;
    }
}
