package pl.coderslab.fixairproject.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "technicalSupport")
public class TechnicalSupport {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long Id;

  private String firstName;

  private String lastName;

  private Gender gender;

  private  String jobTitle;

  private String email;

  private String phoneNumber;

  private String address;
}
