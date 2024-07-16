package pl.coderslab.fixairproject.model;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "device")
public class Device {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotEmpty(message = "Name is required")
  private String name;

  @NotEmpty(message = "Serial number is required")
  private int serialNumber;

  private LocalDateTime installationDate;

  // usunąć serviceDate, zastąpić opisem.

//  private LocalDateTime serviceDate;

  @Size(max = 600)
  private String description;

  @OneToOne
  @ToString.Exclude
  private Client client;

  @ToString.Exclude
  @OneToMany(mappedBy = "device", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<ServiceRecord> serviceRecords = new ArrayList<>();

  @PrePersist
  private void onCreate() {
    installationDate = LocalDateTime.now();
  }

  @PreUpdate
  private void onUpdate() {
    installationDate = LocalDateTime.now();
  }

}
