package pk.komp.plaza;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pk.komp.plaza.mapper.OrderMapperImpl;
import pk.komp.plaza.model.dto.OrderDto;
import pk.komp.plaza.model.entity.*;
import pk.komp.plaza.service.order.OrderService;

import java.math.BigDecimal;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PlazaApplicationTests {

	@Test
	void contextLoads() {
	}

}
