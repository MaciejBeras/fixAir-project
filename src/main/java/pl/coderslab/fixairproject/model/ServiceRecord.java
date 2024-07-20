package pl.coderslab.fixairproject.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "serviceRecord")
public class ServiceRecord {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long Id;

  @NotEmpty
  private LocalDateTime serviceDate;

  @NotEmpty
  private String typeOfFault;

  private String description;


  @ManyToOne
  @ToString.Exclude
  @JoinColumn(name = "device_id")
  private Device device;

  @PrePersist
  private void onCreate() {
    serviceDate = LocalDateTime.now();
  }
}
