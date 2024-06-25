package pl.coderslab.fixairproject.model;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
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
  private Long id;

  @NotEmpty(message = "First name is required")
  private String firstName;

  @NotEmpty(message = "Last name is required")
  private String lastName;

  @NotNull(message = "Gender is required")
  @Enumerated(EnumType.STRING)
  private Gender gender;

  @NotEmpty(message = "Email is required")
  private String email;

  @NotEmpty(message = "Phone number is required")
  private String phoneNumber;

  @NotEmpty(message = "Address is required")
  private String address;

  @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Device> devices = new ArrayList<>();

}


