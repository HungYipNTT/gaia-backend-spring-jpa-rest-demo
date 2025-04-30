// File: com/sportfash/data/entities/AuditEntity.java

package com.sportfash.data.entities;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public abstract class Audit {
    private String createdBy;
    private LocalDateTime createDate;
    private String lastUpdBy;
    private LocalDateTime lastUpdDate;
    private Long ver;
}
