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
public class Declaration {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Client client;

    @Column(nullable = false)
    private Date dateOfDeclaration;

    @Column(nullable = false)
    private Date startDate;

    @Column(nullable = false)
    private Date endDate;

    @Column
    private double materialTotal;

    @Column
    private double compensationTotal;
}
