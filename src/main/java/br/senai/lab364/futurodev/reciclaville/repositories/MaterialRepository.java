package br.senai.lab364.futurodev.reciclaville.repositories;

import br.senai.lab364.futurodev.reciclaville.models.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Long> {
}
