/**
 * 
 */
package cz.unicorn.tga.tractor.model.dto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.*;

/**
 * @author DZCJS9F
 *
 */

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarNewForm {

	private String type;
	private String vin;
	private BigDecimal price;
	private Date dateOfAcquisition;
	private Date dateOfLastTechnicalCheck;

}
