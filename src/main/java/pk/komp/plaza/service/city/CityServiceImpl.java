package pk.komp.plaza.service.city;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pk.komp.plaza.model.dto.CityDto;
import pk.komp.plaza.repository.CityRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    @Override
    public List<CityDto> getAllCities() {
        var cities = cityRepository.findAll();
        List<CityDto> cityDtos = new ArrayList<>();

        cities.forEach(city -> {
            cityDtos.add(new CityDto(city.getCityName(), city.getLongitude(), city.getLatitude()));
        });

        return cityDtos;
    }
}
