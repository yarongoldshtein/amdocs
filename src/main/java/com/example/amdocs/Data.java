package com.example.amdocs;

import java.util.Date;
import java.util.Objects;

public class Data {
    private final long id;
    private final String order_description;
    private final String first_name;
    private final String last_name;
    private final String email;
    private final String price;
    private final Date order_date;
    private final String order_status;


    public Data(long id, String order_description, String first_name, String last_name, String email, String price, Date order_date, String order_status) {
        this.id = id;
        this.order_description = order_description;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.price = price;
        this.order_date = order_date;
        this.order_status = order_status;
    }

    public long getId() {
        return id;
    }

    public String getOrder_description() {
        return order_description;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public String getPrice() {
        return price;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public String getOrder_status() {
        return order_status;
    }

    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                ", order_description='" + order_description + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", price='" + price + '\'' +
                ", order_date=" + order_date +
                ", order_status='" + order_status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Data data = (Data) o;
        return id == data.id &&
                Objects.equals(order_description, data.order_description) &&
                Objects.equals(first_name, data.first_name) &&
                Objects.equals(last_name, data.last_name) &&
                Objects.equals(email, data.email) &&
                Objects.equals(price, data.price) &&
                Objects.equals(order_date, data.order_date) &&
                Objects.equals(order_status, data.order_status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, order_description, first_name, last_name, email, price, order_date, order_status);
    }
}
