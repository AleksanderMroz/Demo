package my.AleksanderMroz.Demo.to;

import my.AleksanderMroz.Demo.enumeration.Cities;


public class OutpostTo {



    private Long id;
    private String logo;
    private Cities location;

    public OutpostTo(){}

    public OutpostTo(Long id, String logo, Cities location) {
        this.id = id;
        this.logo = logo;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public String getLogo() {
        return logo;
    }

    public Cities getLocation() {
        return location;
    }
}
