package org.springframework.samples.petclinic.recoveryroom;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="recoveryRooms")
public class RecoveryRoom {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
	
	@NotEmpty
	@Size(min = 3, max = 50)
    String name;
	
	@NotNull
	@Min(0)
    double size;
    
	@NotNull
    boolean secure;
    
    @ManyToOne(optional=false)
    @JoinColumn(name = "roomType", referencedColumnName = "id")
    RecoveryRoomType roomType;
    
     
    
	@Override
	public String toString() {
		return "RecoveryRoom [id=" + id + ", name=" + name + ", size=" + size + ", secure=" + secure + ", roomType="
				+ roomType + "]";
	}
	
	public boolean isNew() {
		return this.id == null;
	}
    
    
}
