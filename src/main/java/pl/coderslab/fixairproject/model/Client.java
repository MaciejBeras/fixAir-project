package pl.coderslab.fixairproject.model;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "client")
public class Client {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long Id;

  private String firstName;

  private String lastName;

  private Gender gender;

  private String email;

  private String phoneNumber;

  private String address;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "device_id", referencedColumnName = "id")
  private Device device;

}
