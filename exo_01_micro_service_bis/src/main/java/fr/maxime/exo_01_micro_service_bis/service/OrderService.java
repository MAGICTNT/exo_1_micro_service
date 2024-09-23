package fr.maxime.exo_01_micro_service_bis.service;

import fr.maxime.exo_01_micro_service_bis.Util.RestClient;
import fr.maxime.exo_01_micro_service_bis.dto.UserDto;
import fr.maxime.exo_01_micro_service_bis.entity.Order;
import fr.maxime.exo_01_micro_service_bis.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order getById(long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Order save (Order order) {
        RestClient<UserDto> userRestClient = new RestClient<>("http://localhost:8081/api/user/"+order.getIdUser());
        UserDto authorDto = userRestClient.getRequest(UserDto.class);
        if(authorDto != null){
            Order orderSave = Order.builder()
                    .idOrder(order.getIdOrder())
                    .idUser(authorDto.getId())
                    .product(order.getProduct())
                    .build();

            return orderRepository.save(orderSave);
        }
        throw new RuntimeException("user not found");
    }

    public Order getByUserId(long userId) {
        return orderRepository.findByIdUser(userId);
    }
}
