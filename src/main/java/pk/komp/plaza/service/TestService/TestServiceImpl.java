package pk.komp.plaza.service.TestService;

import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
    @Override
    public String test() {
        return "Test";
    }
}
