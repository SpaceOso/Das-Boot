package tech.spaceoso.dasboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.spaceoso.dasboot.model.Shipwreck;

public interface ShipwreckRepository extends JpaRepository<Shipwreck, Long> {

}
