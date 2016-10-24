package org.hoccntt.dao;

import java.math.BigDecimal;
import org.springframework.stereotype.Component;

@Component
public class TaxDao {

	public BigDecimal getTaxPercentageForYear(int i) {
	
		return new BigDecimal(1000);
	}

}
