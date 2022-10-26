package com.ZenPack.ZenPackTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ZenPack.Dto.FeatureDto;
import com.ZenPack.Dto.MenuDto;
import com.ZenPack.model.ZenPack;
import com.ZenPack.repository.ZenPackRepository;
import com.ZenPack.service.Services.ZenPackService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ZenPackServiceTest {

    @Autowired
    private ZenPackService zenPackService;

    @MockBean
    private ZenPackRepository repository;

    @Test
    public void saveZenPackTest() {

        ZenPack zenPack = new ZenPack();
        zenPack.setZenPackId(210L);
        zenPack.setName("Test_Service");
        zenPack.setCreatedBy("Team2");
        zenPack.setCreatedDate(new Date());
        zenPack.setUpdatedBy("Team 2");
        zenPack.setUpdatedTime(new Date());
        MenuDto menuDto = new MenuDto();
        menuDto.setMenuName("Test_zenpack1_menu");
        menuDto.setParentMenuId(101);
        menuDto.setCreatedTime(new Date());
        menuDto.setCreatedBy("Team2");

        FeatureDto featureDto = new FeatureDto();
        featureDto.setFeatureId("202");
        featureDto.setFeatureUrl("http://localhost:8091/api/v1/create");
        featureDto.setIcon("feature1");
        featureDto.setId(201);
        featureDto.setIsSettingMenu(true);
        featureDto.setParent(101);
        featureDto.setText("Menu Feature");

        List<FeatureDto> featureList = new ArrayList<FeatureDto>();
        featureList.add(featureDto);
        menuDto.setFeatures(featureList);

        List<MenuDto> menuList = new ArrayList<MenuDto>();
        menuList.add(menuDto);

        zenPack.setMenus(menuList);

        ResponseEntity<ZenPack> responseEntity = zenPackService.saveZenPack(zenPack);
        assertThat(responseEntity.getStatusCode().value());

        assertThat(responseEntity).isNotNull();

        assertThat(responseEntity.getStatusCode()).isEqualTo(responseEntity.getStatusCode().CREATED);
    }

}
