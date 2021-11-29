package org.arm.resource.mngt.entity;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ApiErrors {
private Timestamp timestamp;
 private String message;
private int status;
private String error;
//public ApiErrors() {
//	super();
//	this.timestamp = timestamp;
//	this.message = message;
//	this.status = status;
//	this.error = error;
//}

}

