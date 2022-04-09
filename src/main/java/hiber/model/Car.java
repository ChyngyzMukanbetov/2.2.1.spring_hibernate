package hiber.model;

import javax.persistence.*;

@Entity
@Table
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String model;

    @Column
    private int series;

//    @OneToOne(optional = true, mappedBy = "car")
//    private User user;

    public Car () {

    }

    public Car (String model, int series) {
        this.model = model;
        this.series = series;
    }

    public String getModel() {
        return model;
    }

    public void setModel() {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries() {
        this.series = series;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
}
