package com.admin.medical.model;

import java.io.Serializable;

import javax.persistence.*;
import lombok.Data;
/**
 *
 * @author Mauricio
 */
@Data
@Entity
@Table(name = "user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String userName;
    private String userPass;
}
