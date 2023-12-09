package com.petshop.ambrozziospetshop.domain.services.implementations;

import com.petshop.ambrozziospetshop.domain.dtos.ItemOrderDTO;
import com.petshop.ambrozziospetshop.domain.dtos.OrderDTO;
import com.petshop.ambrozziospetshop.domain.entities.*;
import com.petshop.ambrozziospetshop.domain.events.ClientUpdateEvent;
import com.petshop.ambrozziospetshop.domain.events.EmployeeUpdateEvent;
import com.petshop.ambrozziospetshop.domain.repositories.*;
import com.petshop.ambrozziospetshop.domain.services.IOrderService;
import com.petshop.ambrozziospetshop.domain.utils.observer.EventManager;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements IOrderService {
    private final IClientRepository clientRepository;
    private final IEmployeeRepository employeeRepository;
    private final IProductRepository productRepository;
    private final IOrderRepository orderRepository;
    private final EventManager eventManager;

    @Override
    public OrderEntity create(OrderDTO orderDTO) {
        OrderEntity orderEntity = new OrderEntity();

        Optional<ClientEntity> clientEntityOptional = clientRepository.findById(orderDTO.getClientId());
        if (clientEntityOptional.isEmpty()) throw new EntityNotFoundException("Error: Client not found!");
        ClientEntity clientEntity = clientEntityOptional.get();

        Optional<EmployeeEntity> employeeEntityOptional = employeeRepository.findById(orderDTO.getEmployeeId());
        if (employeeEntityOptional.isEmpty()) throw new EntityNotFoundException("Error: Employee not found!");
        EmployeeEntity employeeEntity = employeeEntityOptional.get();

        List<ItemOrderEntity> itemOrderEntities = new ArrayList<>();
        double totPrice = 0;
        for (ItemOrderDTO itemOrderDTO : orderDTO.getItemOrderDTOS()) {
            ItemOrderEntity itemOrderEntity = new ItemOrderEntity();

            Optional<ProductEntity> productEntityOptional = productRepository.findById(itemOrderDTO.getProductId());

            if (productEntityOptional.isEmpty()) throw new EntityNotFoundException("Error: Product not found!");

            itemOrderEntity.setQuantity(itemOrderDTO.getQuantity());
            itemOrderEntity.setProductEntity(productEntityOptional.get());
            itemOrderEntities.add(itemOrderEntity);

            totPrice += itemOrderEntity.getTotPrice();
        }

        int totClientOrders = orderRepository.countAllByClientEntity(clientEntity);
        clientEntity.setSaldo(clientEntity.getSaldo() + (totPrice * ((double) totClientOrders / 100)));
        eventManager.notifyAll(new ClientUpdateEvent(clientEntity));

        int totEmployeeOrders = orderRepository.countAllByEmployeeEntity(employeeEntity);
        employeeEntity.setBonus((employeeEntity.getSalario() / 1000) * totEmployeeOrders);
        eventManager.notifyAll(new EmployeeUpdateEvent(employeeEntity));

        orderEntity.setItemOrderEntities(itemOrderEntities);
        orderEntity.setClientEntity(clientEntity);
        orderEntity.setEmployeeEntity(employeeEntity);

        return orderRepository.save(orderEntity);
    }

    @Override
    public List<OrderEntity> findAll() {
        return orderRepository.findAll();
    }
}
