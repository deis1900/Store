package system.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Product")
public class Product {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String type;

    @Column
    private String size;

    @Column
    private String material;

    @Column
    private String color;

    @Column
    private long dateOfLastChange;

    public Product() {
    }

    public Product(String type, String size, String material, String color, long dateOfLastChange) {
        this.type = type;
        this.size = size;
        this.material = material;
        this.color = color;
        this.dateOfLastChange = dateOfLastChange;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public long getDateOfLastChange() {
        return dateOfLastChange;
    }

    public void setDateOfLastChange(long dateOfLastChange) {
        this.dateOfLastChange = dateOfLastChange;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", size='" + size + '\'' +
                ", material='" + material + '\'' +
                ", color='" + color + '\'' +
                ", dateOfLastChange=" + dateOfLastChange +
                '}';
    }
}
