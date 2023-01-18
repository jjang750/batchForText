package com.aegisep.batch.beans;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Data
@ToString
public class ResidentVo {
	private String aptcd, orgaptcd, dongho, occu_date, rel;
}
