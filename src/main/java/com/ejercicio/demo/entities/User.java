package com.ejercicio.demo.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@ToString
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
    @OneToMany(targetEntity=Phone.class, fetch= FetchType.EAGER, cascade= CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<Phone> phones;

    @Builder
    public User(UUID id, LocalDateTime created, LocalDateTime modified, LocalDateTime lastLogin, String token, boolean active, String name, String email, String password, List<Phone> phones) {
        this.id = id;
        this.created = created;
        this.modified = modified;
        this.lastLogin = lastLogin;
        this.token = token;
        this.active = active;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phones = new ArrayList<>(phones);
    }
}
