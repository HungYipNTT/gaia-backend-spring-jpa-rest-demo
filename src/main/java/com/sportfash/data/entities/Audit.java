// File: com/sportfash/data/entities/AuditEntity.java

package com.sportfash.data.entities;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;

@Slf4j
@Getter
@Setter
@MappedSuperclass
public abstract class Audit {

    @PrePersist
    public void prePresist() {
        log.info("PrePresist...");
        this.createDate = LocalDateTime.now();
        this.ver = 0l;
    }

    @PreUpdate
    public void preUpdate() {
        log.info("PreUpdate...");
        this.lastUpdDate = LocalDateTime.now();
        this.incrVersion();
    }

    @CreatedBy
    private String createdBy;

    @CreatedDate
    private LocalDateTime createDate;

    @LastModifiedBy
    private String lastUpdBy;

    @LastModifiedDate
    private LocalDateTime lastUpdDate;

    @Version
    private Long ver;

    public void incrVersion() {
        this.ver = (this.ver==null?0l:this.ver) + 1l;
    }
}
