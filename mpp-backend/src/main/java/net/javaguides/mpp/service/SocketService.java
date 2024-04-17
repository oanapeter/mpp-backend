package net.javaguides.mpp.service;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOServer;
import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import net.javaguides.mpp.dto.CatDto;
import net.javaguides.mpp.entity.Cat;
import net.javaguides.mpp.mapper.CatMapper;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@org.springframework.stereotype.Service
public class SocketService {
    private final Service service;
    private SocketIOServer server;
    private final int maxCats=15;
    private int count=0;

    public SocketService(Service service){
        this.service = service;
    }

    @PostConstruct
    public void init(){
        Configuration config = new Configuration();
        config.setHostname("localhost");
        config.setPort(9092);

        server = new SocketIOServer(config);
        server.start();
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(this::sendNewCat, 10, 30, TimeUnit.SECONDS);
    }

    @PreDestroy
    public void onDestroy(){
        server.stop();
    }

    private void sendNewCat(){
        if(count>=maxCats){
            return;
        }
        Faker faker = new Faker();
        String name = faker.name().firstName();
        String description = faker.lorem().sentence();
        String color = faker.color().name();
        Integer age = faker.number().numberBetween(1, 10);

        Cat newCat = new Cat(-1, name, description, color, age);
        CatDto newCatDto = service.addCat(CatMapper.mapToCatDto(newCat));
        newCat = CatMapper.mapToCat(newCatDto);
        server.getBroadcastOperations().sendEvent("newCat", service.getAllCats());
    }

}
