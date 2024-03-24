package pk.komp.plaza.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pk.komp.plaza.model.entity.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
}
