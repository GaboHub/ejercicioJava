package com.ejercicio.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "phones")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@EqualsAndHashCode
@ToString
public class Phone implements Serializable {

    private static final long serialVersionUID = 3813806609487904985L;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;
    private String number;
    @JsonProperty("citycode")
    private String cityCode;
    @JsonProperty("countrycode")
    private String countryCode;

    @ManyToOne
    @JoinColumn(name="user_id")
    @JsonIgnore
    private User user;
}
