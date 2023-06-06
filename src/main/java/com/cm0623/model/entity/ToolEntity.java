package com.cm0623.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(schema = "depot", name = "tool")
public class ToolEntity {

    @Id
    @Column(name = "code")
    private String code;

    @Column(name = "brand")
    private String brand;

    @ManyToOne
    @JoinColumn(name = "tool_type_id", referencedColumnName = "id")
    private ToolTypeEntity toolTypeEntity;

}
