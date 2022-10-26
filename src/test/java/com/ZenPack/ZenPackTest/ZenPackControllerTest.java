package com.ZenPack.ZenPackTest;

import com.ZenPack.Dto.FeatureDto;
import com.ZenPack.Dto.MenuDto;
import com.ZenPack.Dto.ZenPackDto;
import com.ZenPack.service.Impl.ZenPackServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ZenPackControllerTest {

    @MockBean
    private ZenPackServiceImpl service;

    ObjectMapper mapper=new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @BeforeClass
    public static void init(){
        ZenPackDto zenPackDto = new ZenPackDto();
        zenPackDto.setZenPackId(1L);
        zenPackDto.setName("Zen_Pack");
        zenPackDto.setCreatedDate(new Date());
        zenPackDto.setCreatedBy("Murugan");
        zenPackDto.setUpdatedBy("Sethu");
        zenPackDto.setUpdatedTime(new Date());
        MenuDto menuDto = new MenuDto();
        menuDto.setMenuName("Test1");
        menuDto.setParentMenuId(101);
        menuDto.setCreatedTime(new Date());
        menuDto.setCreatedBy("Mithun");

        FeatureDto featureDto = new FeatureDto();
        featureDto.setFeatureId("1");
        featureDto.setFeatureUrl("www.google.com");
        featureDto.setIcon("Feature");
        featureDto.setId(1);
        featureDto.setIsSettingMenu(true);
        featureDto.setParent(1);
        featureDto.setText("Contains Menu");

        List<FeatureDto> featureList = new ArrayList<FeatureDto>();
        featureList.add(featureDto);
        menuDto.setFeatures(featureList);

        List<MenuDto> menuList = new ArrayList<MenuDto>();
        menuList.add(menuDto);

        zenPackDto.setMenus(menuList);
    }

    @Test
    public void shouldCreateNewZenPack() throws JsonProcessingException, Exception {

        ZenPackDto zenPackDto = new ZenPackDto();
        zenPackDto.setZenPackId(1L);
        zenPackDto.setName("ZenPack");
        zenPackDto.setCreatedDate(new Date());
        zenPackDto.setCreatedBy("Murugan");
        zenPackDto.setUpdatedBy("Mithun");
        zenPackDto.setUpdatedTime(new Date());
        MenuDto menuDto = new MenuDto();
        menuDto.setMenuName("Test");
        menuDto.setParentMenuId(101);
        menuDto.setCreatedTime(new Date());
        menuDto.setCreatedBy("Sethu");

        FeatureDto featureDto = new FeatureDto();
        featureDto.setFeatureId("1");
        featureDto.setFeatureUrl("www.google.com");
        featureDto.setIcon("Icon");
        featureDto.setId(1);
        featureDto.setIsSettingMenu(true);
        featureDto.setParent(1);
        featureDto.setText("Menu Contains");

        List<FeatureDto> featureList = new ArrayList<FeatureDto>();
        featureList.add(featureDto);
        menuDto.setFeatures(featureList);

        List<MenuDto> menuList = new ArrayList<MenuDto>();
        menuList.add(menuDto);

        zenPackDto.setMenus(menuList);

        String uri = "/api/v1/create";

        String dto = mapper.writeValueAsString(zenPackDto);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(dto))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertThat(200).isEqualTo(status);

    }
}
