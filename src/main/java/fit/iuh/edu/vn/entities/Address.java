package fit.iuh.edu.vn.entities;

import fit.iuh.edu.vn.emums.CountryCode;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity
@EqualsAndHashCode(of={"id"})
@Table(name="address")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Address {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "add_id")
    private long id;

    private String city;

    private String street;
    private String number;

    private String zipcode;

    private CountryCode country;



    public Address( String city, String street, String number, String zipcode, CountryCode country) {

        this.city = city;
        this.street = street;
        this.number = number;
        this.zipcode = zipcode;
        this.country = country;

    }
}
