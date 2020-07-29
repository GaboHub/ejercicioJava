package com.ejercicio.demo.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Singular;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class User implements Serializable {

    private static final long serialVersionUID = 3491326967246353701L;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;
    private LocalDateTime created;
    private LocalDateTime modified;
    @JsonProperty("last_login")
    private LocalDateTime lastLogin;
    private String token;
    @JsonProperty("isactive")
    private boolean active;
    private String name;
    private String email;
    private String password;

    @Singular
    @OneToMany(targetEntity=Phone.class, mappedBy="user", fetch= FetchType.EAGER)
    private List<Phone> phones;

}
