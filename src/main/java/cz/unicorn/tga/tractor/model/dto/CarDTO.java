/**
 * 
 */
package cz.unicorn.tga.tractor.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.*;

/**
 * @author User
 *
 */
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarDTO implements Serializable {

	private Long id;
	private String type;
	private String vin;
	private String carState;
	private Date dateOfAcquisition;
	private Date dateOfLastTechnicalCheck;
	private BigDecimal price;

}
