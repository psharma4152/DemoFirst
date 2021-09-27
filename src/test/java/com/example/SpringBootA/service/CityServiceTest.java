package com.example.SpringBootA.service;

import com.example.SpringBootA.model.City;
import com.example.SpringBootA.repository.CityRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.*;


import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ContextConfiguration
@AutoConfigureMockMvc
@RunWith(MockitoJUnitRunner.class)
public class CityServiceTest {

    @Autowired
    ObjectMapper mapper;

    @Autowired
    MockMvc mockMvc;

    private CityService cityService = Mockito.mock(CityServiceImpl.class);
    private CityRepository cityRepository = Mockito.mock(CityRepository.class);


    @Test
    @DisplayName("To check for the availability of all the cities")
    public void ToCheckForAllCities() throws Exception {
        City objCityMock1 = new City(1L, "Vidisha", 1000);
        City objCityMock2 = new City(2L, "Bhopal", 2000);
        City objCityMock3 = new City(3L, "Indore", 20000);
        List<City> listCity = Arrays.asList(objCityMock1, objCityMock2,objCityMock3);
        when(cityRepository.findAll()).thenReturn(listCity);
        mockMvc.perform(MockMvcRequestBuilders.get("/cities"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)));
    }


    @Test
    @DisplayName("To Check for getting a city Detail")
    public void ToCheckForACity() throws Exception {
/*        City objCity = new City();
        objCity.setName("Vidisha1");
        when(cityRepository.findById(1L)).thenReturn(Optional.of(objCity));*/
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.get("/cities/1");
        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("Vidisha")));

    }

    @Test
    @DisplayName("To check for the addition of a city")
    public void ToCheckForAddition() throws Exception {
        City objCityMock = new City(22L, "Lucknow", 20000);
        when(cityRepository.save(objCityMock)).thenReturn(objCityMock);
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/addCity")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(objCityMock));

        mockMvc.perform(mockRequest).andExpect(status().isCreated());
    }

}
