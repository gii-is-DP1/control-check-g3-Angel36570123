package org.springframework.samples.petclinic.recoveryroom;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="recoveryRoomTypes")
public class RecoveryRoomType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
	
	@NotEmpty
	@Size(min = 5, max = 50)
	@Column(unique=true)
    String name;

	@Override
	public String toString() {
		return "RecoveryRoomType [id=" + id + ", name=" + name + "]";
	}
	
	
}
