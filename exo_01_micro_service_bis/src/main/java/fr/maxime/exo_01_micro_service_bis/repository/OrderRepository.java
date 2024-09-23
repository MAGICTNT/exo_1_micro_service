package fr.maxime.exo_01_micro_service_bis.repository;

import fr.maxime.exo_01_micro_service_bis.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    public Order findByIdUser(long idUser);
}
