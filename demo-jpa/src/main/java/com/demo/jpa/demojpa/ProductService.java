package com.demo.jpa.demojpa;


import com.demo.jpa.demojpa.entity.Customer;
import com.demo.jpa.demojpa.entity.Order;
import com.demo.jpa.demojpa.entity.Product;
import com.demo.jpa.demojpa.repository.CustomerRepository;
import com.demo.jpa.demojpa.repository.OrderRepository;
import com.demo.jpa.demojpa.repository.ProductRepository;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


import java.util.*;
import java.math.BigDecimal;


@Component
public class ProductService implements ApplicationListener<ContextRefreshedEvent>
{
    @Autowired ProductRepository productRepository;
    @Autowired CustomerRepository customerRepository;
    @Autowired OrderRepository orderRepository;


    public void saveData()
    {

    }


    @Override
    public void onApplicationEvent( ContextRefreshedEvent event )
    {
        System.out.println( "Hello" );


        //TODO: WE HAVE TO PUT CASCADE.TYPE=ALL EVERYWHERE
//        createUser();
//        Optional<Customer> customer = customerRepository.findById( 2 );
//        Order order = new Order( 122, 123, "new orders" );
//        ArrayList<Order> orderList = new ArrayList<>();
//        order.setCustomer( customer.get() );
//        orderList.add( order );
//        customer.get().setOrderList( orderList );
//        Product product = new Product( "banana", "bags nad ", "https://anbc.com", new BigDecimal( 1213.12 ) );
//        product.setOrder( order );
//        Product product2 = new Product( "apple", "keep doc away", "https://anbc.com", new BigDecimal( 1213.12 ) );
//        product2.setOrder( order );
//        Product product3 = new Product( "grapes", "just enjoy", "https://anbc.com", new BigDecimal( 1213.12 ) );
//        product3.setOrder( order );
//        List<Product> products = new ArrayList<>();
//        products.add( product );
//        products.add( product2 );
//        products.add( product3 );
//        order.setProductList( products );
//
//        orderRepository.save( order );
        editOrderDetails( 23 );

    }


    void editOrderDetails( int orderId )
    {
        Optional<Order> orderInRepo = orderRepository.findById( orderId );

        Optional<Customer> customerInRepo = customerRepository.findById( 1 );

        Order order = orderInRepo.get();
        System.out.println( "Fetch type for order is lazy"+order ); Customer customer = customerInRepo.get();
        System.out.println("Now it wil be fetched"+ order.getProductList());
        customer.setAddress( "Changed to bangalore" );
        order.setCustomer( customer );
        orderRepository.save( order );

    }


    void createUser()
    {
        Customer customer = new Customer( 99, "dhiraj kumar", "jakariapur patna", new Integer( 767680 ) );
        customerRepository.save( customer );

    }
}
