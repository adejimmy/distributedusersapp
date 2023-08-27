package com.taxapplication.distributedusers.dto;

import com.taxapplication.distributedusers.domain.LocalGovernment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZonesDto implements Serializable {
    private Long id;
    private String zone;
    private String inactive;
    private Timestamp registered_on;
    private String registered_by;
    private String service_id;
    private String session_id;
    private List<LocalGovernmentDto> localgovernmentarea;
}
