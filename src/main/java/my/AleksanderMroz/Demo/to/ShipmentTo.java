//package my.AleksanderMroz.Demo.to;
//
//import my.AleksanderMroz.Demo.entity.CustomerEntity;
//import my.AleksanderMroz.Demo.enumeration.ShipmentStatus;
//
//import javax.persistence.*;
//
//public class ShipmentTo {
//    private Long id;
//    private String destination;
//    private long value;
//    private ShipmentStatus status;
//
//    private CustomerEntity owner;
//
//
//    public ShipmentTo() {
//    }
//
//    public ShipmentTo(Long id, String destination, long value, ShipmentStatus status, CustomerEntity owner) {
//        this.id = id;
//        this.destination = destination;
//        this.value = value;
//        this.status = status;
//        this.owner = owner;
//    }
//
//    public CustomerEntity getOwner() {
//        return owner;
//    }
//
//    public void setOwner(CustomerEntity owner) {
//        this.owner = owner;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getDestination() {
//        return destination;
//    }
//
//    public void setDestination(String destination) {
//        this.destination = destination;
//    }
//
//    public long getValue() {
//        return value;
//    }
//
//    public void setValue(long value) {
//        this.value = value;
//    }
//
//    public ShipmentStatus getStatus() {
//        return status;
//    }
//
//    public void setStatus(ShipmentStatus status) {
//        this.status = status;
//    }
//}
