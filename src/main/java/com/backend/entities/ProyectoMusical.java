package com.backend.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(
        name="proyectosMusicales"
        // uniqueConstraints = {
        //         @UniqueConstraint(name="proyectoMusical_name_unique",
        //                 columnNames = "name")
        // }
)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProyectoMusical {

    @Id
    @SequenceGenerator(
            name="proyectoMusical_sequence",
            sequenceName = "proyectoMusical_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "proyectoMusical_sequence"
    )

    // ---------------------

    @Column(
            name="id",
            updatable = false
    )
    private Long id;

    // ---------------------

    @Column(
        name = "nombre",
        nullable = false,
        columnDefinition = "TEXT"
    )
    private String nombre;

    // ----------------------

    @Column(
        name = "tipoProyecto",
        nullable = false,
        columnDefinition = "TEXT"
    )
    private String tipoProyecto;

    // ----------------------

    // TODO: duracion del proyecto

    // ---------------------

    @Column(
            name="lanzamiento",
            nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
    )
    private LocalDateTime lanzamiento;

    // ----------------------
    
    @Column(
        name = "descripcion",
        nullable = false,
        columnDefinition = "TEXT"
    )
    private Float descripcion;

    // ----------------------

    @Column(
        name = "imagen",
        nullable = false,
        columnDefinition = "TEXT"
    )
    private String imagen;

    // ----------------------

    @Column(
        name = "canciones",
        nullable = false
    )
    private Integer canciones;

    // ----------------------

    @Column(
        name = "discografica",
        nullable = false,
        columnDefinition = "TEXT"
    )
    private String discografica;

    // ----------------------

    // Relaciones con las tablas de base de datos 

    @ManyToOne
    @JoinColumn(
            name = "artista_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "artista_proyectoMusical_fk"
            )
    )
    private Artista artista;

    // ---------------------

    @OneToMany(
        mappedBy = "proyecto",
        cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
        fetch = FetchType.LAZY
    )
    private List<Cancion> cancion = new ArrayList<>();
    
}
