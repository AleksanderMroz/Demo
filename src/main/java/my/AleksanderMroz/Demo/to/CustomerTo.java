package my.AleksanderMroz.Demo.to;

public class CustomerTo {
    private Long id;
    private String customerName;
    private String password;
    private String address;

    public CustomerTo()
    {
    }

    public CustomerTo(Long id, String customerName, String password, String address) {
        this.id = id;
        this.customerName = customerName;
        this.password = password;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
