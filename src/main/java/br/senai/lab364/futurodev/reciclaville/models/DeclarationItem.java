package br.senai.lab364.futurodev.reciclaville.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeclarationItem {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Declaration declaration;

    @ManyToOne(optional = false)
    private Material material;

    @Column(nullable = false)
    private double percentage;

    @Column(nullable = false)
    private double tonsDeclared;

    @Column(nullable = false)
    private double tonsCompensation;
}
