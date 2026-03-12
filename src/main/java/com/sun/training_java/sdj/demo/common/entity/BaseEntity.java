package com.sun.training_java.sdj.demo.common.entity;

import java.util.Date;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Date createdAt;

  private Date updatedAt;

  private Date deletedAt;

  // trigger when insert add created at
  @PrePersist
  protected void onCreate() {
    createdAt = new Date();
  }

  // trigger when update add updated at
  @PreUpdate
  protected void onUpdate() {
    updatedAt = new Date();
  }

  // trigger when delete add deleted at
  @PreRemove
  protected void onDelete() {
    deletedAt = new Date();
  }
}
