package edu.sample.rest.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class SystemPreference {
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "ID")
	private Long id;
    @Column(name = "PREF_NAME")
	private String preferenceName;
    @Column(name = "PREF_TYPE")
	private String preferenceType;
    @Column(name = "STATUS")
	private String status;
    @Column(name = "VALUE")
	private String value;
    @Column(name = "CREATED_BY")
	private String createdBy;
    @Column(name = "CREATED_TS")
	private Timestamp createdTs;
    @Column(name = "MODIFIED_BY")
	private String modifiedBy;
    @Column(name = "MODIFIED_TS")
	private Timestamp modifiedTs;
	

}
