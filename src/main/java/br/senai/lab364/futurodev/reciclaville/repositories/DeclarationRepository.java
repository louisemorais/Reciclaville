package br.senai.lab364.futurodev.reciclaville.repositories;

import br.senai.lab364.futurodev.reciclaville.models.Declaration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeclarationRepository extends JpaRepository<Declaration, Long> {
    @Query("""
    SELECT di.material.name, SUM(di.tonsCompensation)
    FROM Declaration d
    JOIN d.itens di
    GROUP BY di.material.name
""")
    List<Object[]>dashboard();
}
