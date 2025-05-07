package br.senai.lab364.futurodev.reciclaville.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String cnpj;

    @Column(nullable = false)
    private String economicActivity;

    @Column(nullable = false)
    private String accontable;
}
